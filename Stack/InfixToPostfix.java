import java.io.*;
import java.util.Scanner;

public class InfixToPostfix
{
	public static boolean checkOpertor(char s)
    {
        int flag = 0;
        char[] operator = {'+','-','*','/','^'};
        for (char o:operator)
        {
            if(s==o)
            {
                flag =1;
                break;
            }
        }
        if(flag==1)
        {
            flag = 0;
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int checkPrecedence(char c)
    {
    	switch (c) 
    	{
    	    case '+':
    	    case '-':
    	        return 0;
    	    case '*':
    	    case '/':
    	        return 1;
    	    case '^':
    	        return 2;
    	    default:
    	        throw new IllegalArgumentException("Operator unknown: "+c);
    	}
    }
	public static void main(String[] args) 
	{
		Scanner in  = new Scanner(System.in);
		MyCharStack mt = new MyCharStack();
		String infix = in.next();
		String postfix = "";
		char r = mt.pushEle('(');
		infix = infix+")";
		int flag = 0;
		for(int i=0;i<infix.length();i++)
		{
			if(infix.charAt(i)=='(')
			{
				mt.pushEle(infix.charAt(i));
			}
			else if(!checkOpertor(infix.charAt(i)))
			{
				if(infix.charAt(i) == ')')
				{
					for(int j=0;;j++)
					{
						char res = mt.popEle();
						if(res != '(')
						{
							postfix = postfix+res;
						}
						else
						{
							break;
						}
					}
				}
				else
				{
					postfix = postfix+infix.charAt(i);
					System.out.println("Postfix - "+postfix);
				}
			}
			else if(checkOpertor(infix.charAt(i)))
			{
				String temp = postfix;
				for(int j=0;;j++)
				{
					if(flag == 0)
					{
						mt.pushEle(infix.charAt(i));
						flag = 1;
						break;
					}
					else
					{
						char rest = mt.peekEle();
						if(rest == '(')
						{
							for(int k=0;k<j;k++)
							{
								mt.pushEle(postfix.charAt(postfix.length()-(k+1)));
							}
							mt.pushEle(infix.charAt(i));
							postfix = temp;
							break;
						}
						else 
						{
							char res = mt.popEle();
							if(checkPrecedence(res) < checkPrecedence(infix.charAt(i)))
							{
								postfix = postfix+res;
							}
							else if(checkPrecedence(res) >= checkPrecedence(infix.charAt(i)))
							{
								postfix = postfix+res;
								mt.pushEle(infix.charAt(i));
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(postfix);
	}
}
