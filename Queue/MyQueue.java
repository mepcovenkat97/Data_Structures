import java.io.*;

public class MyQueue
{
	int front = -1;
	int rear = -1;
	int[] ele;

	MyQueue(){
		ele = new int[10];
	}

	public int enqueue(int data)
	{
		if(rear == ele.length-1 || rear==front-1)
		{
			//System.out.println("Overflow Condition");
			return -1;
		}
		else
		{
			rear++;
			ele[rear] = data;
			if(front == -1)
				front++;
			return 0;
		}
	}

	public int dequeue()
	{
		if(front == -1)
		{
			return -1;
		}
		else
		{
			int data = ele[front];
			if(front == rear)
			{
				front = -1;
				rear = -1;
			}
			else
			{
				front++;
				if(front == ele.length-1)
					front = 0;
			}
			return data;
		}
	}
	public void printQueue()
	{
		if( front < rear && rear<ele.length)
		{
			for(int i=0;i<=rear;i++)
			{
				System.out.println(ele[i]);
			}
		}
		else
		{
			if(front > rear)
			{
				for(int i=front;i<ele.length;i++)
				{
					System.out.println(ele[i]);
				}
				for(int j=0;j<rear;j++)
				{
					SYstem.out.println(ele[i]);
				}
			}
		}
	}
}