import java.util.Stack;

class ExNode
{
	ExNode left;
	ExNode right;
	char data;
	ExNode()
	{
		left = null;
		right = null;
	}
	ExNode(char ele)
	{
		left = null;
		right = null;
		data = ele;
	}
}
public class ExpressionTree
{
	public boolean isOperator(char c)
	{
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
			return true;
		else
			return false;
	}

	public void PrintExpression(ExNode t)
	{
		if(t!=null)
		{
			PrintExpression(t.left);
			System.out.print(t.data+" ");
			PrintExpression(t.right);
		}
	}

	public ExNode constructTree(char expression[])
	{
		Stack<ExNode> st = new Stack();
		ExNode t,t1,t2;
		for(int i=0;i<expression.length;i++)
		{
			if(!isOperator(expression[i]))
			{
				t = new ExNode(expression[i]);
				st.push(t);
			}
			else
			{
				t = new ExNode(expression[i]);
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
	public static void main(String[] args)
	{
		ExpressionTree et = new ExpressionTree();
		String expression = "ab+ef*g*-";
		char[] exp = expression.toCharArray();
		ExNode root = et.constructTree(exp);
		et.PrintExpression(root);
	}	
}
