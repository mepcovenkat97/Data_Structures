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
    	int p = 0,j=0;
    	for(int i=0;i<infix.length;i++)
    	{
    		if(infix[i] == root.data)
    		{
    			p=i;
    			j=i+1;
    			break;
   			}
    	}
    	if(p>=2)
    	{
    		char leftin[]= new char[infix.length-p];
    		char leftpost[]= new char[infix.length-p];
    		char rightin[]= new char[infix.length-p-1];
    		char rightpost[] = new char[infix.length-p-1];
    		int flag = 0,z=0;
    		for(int i=0;i<p;i++)
    		{
    			leftin[i] = infix[i];
    			leftpost[i] = postfix[i];
    			z=i+1;
    		}
    		int k =0,q=0;
    		for(int i=z;i<postfix.length-1;i++)
    		{
    			q=i+1;
    			rightin[k] = infix[q];
    			rightpost[k] = postfix[i];
    			k++;
    		}
    		ExNode nleft = constructTree2(leftin,leftpost);
    		//System.out.println("3  =>"+nleft.data);
    		root.left = nleft;
    		ExNode nright = constructTree2(rightin,rightpost);
    		//System.out.println("4  =>"+nright.data);
    		root.right = nright;
    		return root;
    	}
    	else if(p == 1)
    	{
    		if(infix.length/2 == p)
    		{
    			ExNode nleft = new ExNode(infix[0]);
    			ExNode nright = new ExNode(infix[infix.length -1]);
    			root.left = nleft;
    			root.right = nright;
    			return root;
    		}
    	}
    	else
    	{
    		ExNode nright;
    		ExNode nleft;
    		if(infix.length > 1)
    		{
    			nright = new ExNode(infix[infix.length-1]);
    			root.right = nright;
    		}
    	 	else if(postfix.length > 1)
    		{
    			nleft = new ExNode(postfix[postfix.length-1]);
    			root.left = nleft;
    		}
    		
    		return root;
    	}
    	return root;
    }

    public static ExNode constructTree3(char prefix[], char postfix[], int start, int end)
    {
    	ExNode root = new ExNode(postfix[end])
    	if(start == end) return null;
    	for(int i=0;i<prefix.length;i++)
    	{
    		if(prefix[i] == postfix[end--])
    			left[i] = prefix[i]
    	}
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

    public static void main(String[] args)
    {
    	// Scanner in = new Scanner(System.in);
    	// String infix = in.next();
    	// String res = infixtoPostfix(infix);
    	// //System.out.println("Postfix \n"+res);
    	// char[] post = res.toCharArray();
    	// char[] inf = infix.toCharArray();
    	

    	char[] post = {'8','4','5','2','6','7','3','1'};
    	char[] inf  = {'4','8','2','5','1','6','3','7'};
    	ExNode root = constructTree2(inf,post);
    	//ExNode root = constructTree(post);
    	//System.out.println("Inorder");
    	inorderPrintExpression(root);
    	System.out.println();
    	//System.out.println(res);
    }
}