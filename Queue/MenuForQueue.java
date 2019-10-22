import java.io.*;
import java.util.Scanner;

public class MenuForQueue
{
    public static void main(String[] args)
    {
        MyPriorityQueue mt = new MyPriorityQueue();
        Item vt1 = new Item(10,2);
        mt.enqueue(vt1);
        Item vt2 = new Item(11,1);
        mt.enqueue(vt2);
        Item vt3 = new Item(12,2);
        mt.enqueue(vt3);
        Item vt4 = new Item(13,3);
        mt.enqueue(vt4);
        Item vt5 = new Item(5,25);
        mt.enqueue(vt5);
        mt.dequeue();
        mt.dequeue();
        mt.dequeue();
        mt.dequeue();
        mt.dequeue();
        /*int option;
        Scanner in = new Scanner(System.in);
        do
        {
            System.out.println("Menu\n1.Enqueue\n2.Dequeue\n3.Print\n4.Exit");
            option = in.nextInt();
            switch(option)
            {
                case 1:
                    int data = in.nextInt();
                    int res = mt.enqueue(data);
                    if(res != -1)
                    {
                        System.out.println("Enqueued in the Queue");
                    }
                    else
                    {
                        System.out.println("Overflow");
                    }
                    break;
                case 2:
                    int popdata = mt.dequeue();
                    if(popdata != -1)
                    {
                        System.out.println("Dequeued Data is "+ popdata);
                    }
                    else
                    {
                        System.out.println("Underflow");
                    }
                    break;
                case 3:
                    mt.printQueue();
                    break;
                case 4:
                    break;
                default:
            }
        }while(option != 4);*/
    }
}
