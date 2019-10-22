import java.io.*;
public class MyCharStack
{
    char[] arr;
    int top;
    
    //Constructor
    MyCharStack()
    {
        this.arr = new char[100];
        this.top = -1;
    }
    /*
    Func - Pushing an Element into Stack
    I/p - number
    o/p - 0 - on Success
         -1 - on Failure
    */
    public char pushEle(char data)
    {
        if( top != 100)
        {
            top++;
            //System.out.println("Before COnvert "+data);
            arr[top] = data;
            //System.out.println("Inside MYStack "+arr[top]);
            return '0';
        }
        else
        {
            return '1';
        }
        
    }
    
    /*
    Func - Pop an Element from Stack
    I/p -  --nil--
    o/p - poped number - on Success
         -1 - on Failure
    */
    public char popEle()
    {
        if(top != -1)
        {
            char i = arr[top];
            top--;
            return i;
        }
        else
        {
            return '1';
        }
    }
    public char peekEle()
    {
        if(top != -1)
        {
            return arr[top];
        }
        else
        {
            return '1';
        }
    }
}
