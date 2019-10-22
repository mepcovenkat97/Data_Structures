import java.io.*;
import java.util.Scanner;
public class PreEval
{
    public static boolean checkOpertor(char s)
    {
        int flag = 0;
        char[] operator = {'+','-','*','/'};
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
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        MyStack mt = new MyStack();
        String str = in.next();
        str = "("+str;
        int res;
        for(int i=str.length()-1;i>=0;i--)
        {
            if(str.charAt(i) != '(')
            {
                boolean isOperator = checkOpertor(str.charAt(i));
                if(!isOperator)
                {
                    mt.pushEle(Character.getNumericValue(str.charAt(i)));
                }
                else
                {
                    int A = mt.popEle();
                    int B = mt.popEle();
                    switch(str.charAt(i))
                    {
                        case '+':
                            res = A+B;
                            //System.out.println(A+"+"+B+"="+res);
                            mt.pushEle(res);
                            res = 0;
                            break;
                        case '-':
                            res = A-B;
                            //System.out.println(A+"-"+B+"="+res);
                            mt.pushEle(res);
                            res = 0;
                            break;
                        case '*':
                            res = A*B;
                            //System.out.println(A+"*"+B+"="+res);
                            mt.pushEle(res);
                            res = 0;
                            break;
                        case '/':
                            res= A/B;
                            //System.out.println(A+"/"+B+"="+res);
                            mt.pushEle(res);
                            res = 0;
                            break;
                        default:
                    }
                }
            }
            else
            {
                int ans = mt.popEle();
                System.out.println(ans);
            }
        }
    }
}
