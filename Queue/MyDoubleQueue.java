import java.io.*;

public class MyDoubleQueue
{
	int left = -1;
	int right = -1;
	int[] dq;

	MyDoubleQueue()
	{
		this.dq = new int[10];
	}

	public void insertLeft(int a)
	{
		if(right == -1)
		{
			right = 0;
		}
		if((left + 1)% dq.length == 0)
		{
			System.out.println("Overflow");
		}
		if(left == 0)
		{
			left = dq.length -1;
		}
		else
		{
			left = left-1;
		}
		dq[left] = a;
	}
	public void insertRight(int a)
	{
		if(left == -1)
		{
			left = 0;
		}
		if(right == dq.length-1 || right == left-1)
		{
			System.out.println("Overflow");
		}
		right = (right+1)%dq.length;
		dq[right] = a;
	}
	public int deleteRight()
	{
		if(right == -1)
		{
			System.out.println("Underflow");
			return -1;
		}
		else
		{
			int a = dq[right];
			if(right == 0)
			{
				right = dq.length-1;
			}
			else
			{
				right = right-1;
			}
			return a;
		}
	}
	public int deleteLeft()
	{
		if(left == -1)
		{
			System.out.println("Underflow");
			return -1;
		}
		else
		{
			int a = dq[left];
			left = (left+1)%dq.length;
			return a;
		}
	}
	public void printQueue()
	{
		if(right > left)
		{
			for(int i=left;i<=right;i++)
			{
				System.out.println(dq[i]);
			}
		}
		else
		{
			for(int i=left;i<dq.length-1;i++)
			{
				System.out.println(dq[i]);
			}
			for(int i=0;i<=right;i++)
			{
				System.out.println(dq[i]);
			}
		}
	}
}