import java.io.*;
import java.util.Stack;

public class IBPost
{
	public static boolean checkOpertor(String s)
    {
        int flag = 0;
        String[] operator = {"+","-","*","/"};
        for (String o:operator)
        {
            if(s.equals(o))
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
	public static void main(String[] args)
	{
		String[] A = {"2", "1", "+", "3", "*"};
		Stack<String> mt = new Stack<String>();
		int res = 0;
		String[] B = new String[A.length + 1];
		for(int i =0;i<A.length;i++)
		{
			B[i] = A[i];
		}
		B[B.length-1] = ")";
		for(int i=0;i<B.length;i++)
		{
			if(!(B[i].equals(")")))
            {
                boolean isOperator = checkOpertor(B[i]);
                if(!isOperator)
                {
                    mt.push(B[i]);
                }
                else
                {
                    int tA = Integer.parseInt(mt.pop());
                    int tB = Integer.parseInt(mt.pop());
                    switch(B[i])
                    {
                        case "+":
                            res = tA+tB;
                            //System.out.println(A+"+"+B+"="+res);
                            mt.push(String.valueOf(res));
                            res = 0;
                            break;
                        case "-":
                            res = tB-tA;
                            //System.out.println(A+"-"+B+"="+res);
                            mt.push(String.valueOf(res));
                            res = 0;
                            break;
                        case "*":
                            res = tA*tB;
                            //System.out.println(A+"*"+B+"="+res);
                            mt.push(String.valueOf(res));
                            res = 0;
                            break;
                        case "/":
                            res= tB/tA;
                            //System.out.println(A+"/"+B+"="+res);
                            mt.push(String.valueOf(res));
                            res = 0;
                            break;
                        default:
                    }
                }
            }
            else
            {
                String ans = mt.pop();
                System.out.println(ans);
            }
		}
	}
}