import java.io.*;
public class MyStack
{
    int[] arr;
    int top;
    
    //Constructor
    MyStack()
    {
        this.arr = new int[100];
        this.top = -1;
    }
    /*
    Func - Pushing an Element into Stack
    I/p - number
    o/p - 0 - on Success
         -1 - on Failure
    */
    public int pushEle(int data)
    {
        if( top != 100)
        {
            top++;
            //System.out.println("Before COnvert "+data);
            arr[top] = data;
            //System.out.println("Inside MYStack "+arr[top]);
            return -2;
        }
        else
        {
            return -1;
        }
        
    }
    
    /*
    Func - Pop an Element from Stack
    I/p -  --nil--
    o/p - poped number - on Success
         -1 - on Failure
    */
    public int popEle()
    {
        if(top != -1)
        {
            int i = arr[top];
            top--;
            return i;
        }
        else
        {
            return -1;
        }
    }
}
