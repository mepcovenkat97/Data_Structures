import java.io.*;
import java.util.Scanner;

public class MenuForStack
{
    public static void main(String[] args)
    {
        MyStack mt = new MyStack();
        int option;
        Scanner in = new Scanner(System.in);
        do
        {
            System.out.println("Menu\n1.Push\n2.Pop\n3.Peek\n4.Print\n5.Exit");
            option = in.nextInt();
            switch(option)
            {
                case 1:
                    int data = in.nextInt();
                    int res = mt.pushEle(data);
                    if(res != -1)
                    {
                        System.out.println("Pushed into the Stack");
                    }
                    else
                    {
                        System.out.println("Overflow");
                    }
                    break;
                case 2:
                    int popdata = mt.popEle();
                    if(popdata != -1)
                    {
                        System.out.println("Poped Data is "+ popdata);
                    }
                    else
                    {
                        System.out.println("Underflow");
                    }
                    break;
                case 3:
                    int peekdata = mt.peek();
                    if(peekdata!= -1)
                    {
                        System.out.println("Top Element is "+mt.peek());
                     }
                     else
                     {
                        System.out.println("Stack is Empty");
                     }
                    break;
                case 4:
                    mt.printEle();
                    break;
                case 5:
                    break;
                default:
            }
        }while(option != 5);
    }
}
