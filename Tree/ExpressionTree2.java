import java.util.Stack;
import java.util.Scanner;
// class ENode
// {

// }
public class ExpressionTree2
{
	static boolean isOperator(char c)
	{
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
			return true;
		else
			return false;
	}
	static int checkPrecedence(char c)
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
    static String infixtoPostfix(String exp)
    {
    	Stack<Character> st = new Stack();
    	String postfix = "";
    	st.push('(');
    	exp = exp + ')';
    	int flag = 0;
    	for(int i=0;i<exp.length();i++)
    	{
    		if(exp.charAt(i) == '(')
    			st.push(exp.charAt(i));
    		else if(!isOperator(exp.charAt(i)))
    		{
    			if(exp.charAt(i) == ')')
    			{
    				for(int j=0;;j++)
    				{
    					char res = st.pop();
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
    				postfix = postfix+exp.charAt(i);
    				//return postfix;
    			}
    		}
    		else if(isOperator(exp.charAt(i)))
    		{
    			String temp = postfix;
    			for(int j=0;;j++)
    			{
    				if(flag == 0)
    				{
    					st.push(exp.charAt(i));
    					flag = 1;
    					break;
    				}
    				else
    				{
    					char rest = st.peek();
    					if(rest == '(')
    					{
    						for(int k=0;k<j;k++)
							{
								st.push(postfix.charAt(postfix.length()-(k+1)));
							}
							st.push(exp.charAt(i));
							postfix = temp;
							break;
    					}
    					else
    					{
    						char res = st.pop();
    						if(checkPrecedence(res) < checkPrecedence(exp.charAt(i)))
    						{
    							postfix = postfix + res;
    						}
    						else if(checkPrecedence(res) >= checkPrecedence(exp.charAt(i)))
    						{
    							postfix = postfix + res;
    							st.push(exp.charAt(i));
    							break;
    						}
    					}
    				}
    			}
    		}
    	}
    	return postfix;
    }
    public static ExNode constructTree(char postfix[])
    {

		Stack<ExNode> st = new Stack();
		ExNode t,t1,t2;
		for(int i=0;i<postfix.length;i++)
		{
			if(!isOperator(postfix[i]))
			{
				t = new ExNode(postfix[i]);
				st.push(t);
			}
			else
			{
				t = new ExNode(postfix[i]);
				t1 = st.pop();
				t2 = st.pop();
				t.right = t1;
				t.left = t2;
				st.push(t);
			}
		}
		t = st.peek();
		st.pop();
		return t;
    }

    public static ExNode constructTree2(char infix[],char postfix[])
    {
    	ExNode root = new ExNode(postfix[postfix.length -1]);
    	char[] left = new char[postfix.length/2];
    	char[] right= new char[postfix.length/2];
    	int flag = 0,j=0;
    	for(int i=0;i<infix.length;i++)
    	{
    		if(infix[i] != root.data)
    		{
    			left[i] = infix[i];
    		}
    		else if(infix[i] == root.data)
    		{
    			j=i;
    			flag = 0;
    			break;
    		}
    	}
    	for(int i=j+1;i<infix.length;i++)
    	{
    		right[i] = infix[i];
    	}
    	ExNode nleft = new ExNode(postfix[left.length-1]);
    	ExNode nright = new ExNode(postfix[(left.length+right.length)-1]);
    	root.left = nleft;
    	root.right = nright;
    	constructTree2(left,postfix);
    	constructTree2(right,postfix);
    	return root;
    }

    public static void inorderPrintExpression(ExNode t)
	{
		if(t!=null)
		{
			inorderPrintExpression(t.left);
			System.out.print(t.data+" ");
			inorderPrintExpression(t.right);
		}
	}
/*
	public static void preorderPrintExpression(ExNode t)
	{
		if(t!= null)
		{
			System.out.print(t.data);
			preorderPrintExpression(t.left);
			preorderPrintExpression(t.right);
		}
	}
*/
    public static void main(String[] args)
    {
    	Scanner in = new Scanner(System.in);
    	String infix = in.next();
    	String res = infixtoPostfix(infix);
    	System.out.println("Postfix \n"+res);
    	char[] post = res.toCharArray();
    	char[] inf = infix.toCharArray();
    	ExNode root = constructTree2(post,inf);
    	System.out.println("Inorder");
    	inorderPrintExpression(root);
    	//System.out.println(res);
    }
}