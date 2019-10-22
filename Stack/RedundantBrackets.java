import java.io.*;
import java.util.Stack;
import java.util.Scanner;

public class RedundantBrackets
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String A = in.next();
		Stack<Character> mt = new Stack<Character>();
		for(int i=0;i<A.length();i++)
		{
			if(A.charAt(i) != ')')
			{
				System.out.println(A.charAt(i));
				mt.push(A.charAt(i));
			}
			else
			{
				for(int j=0;;j++)
				{
					char res = mt.pop();
					System.out.println(res);
					if(res == '(')
					{
						if(mt.peek() == '(')
						{
							System.out.println("Yes");
							break;
						}
						else
						{
							System.out.println("No");
							break;
						}
					}
				}
			}
		}
	}
}