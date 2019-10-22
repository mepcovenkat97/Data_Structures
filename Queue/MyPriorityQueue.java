import java.io.*;
import java.util.*;

public class MyPriorityQueue
{
	ArrayList<Item> arr;
	int top = -1;
	int rear = -1;
	MyPriorityQueue()
	{
		this.arr = new ArrayList<Item>(10);
	}
	void enqueue(Item data)
	{
		if(top == -1)
		{
			top = 0;
		}
		rear = (rear+1)%10;//10 is arraylist size
		arr.add(rear, data);
	}
	void dequeue()
	{
		int priority = arr.get(top).priority;
		Item removed = arr.get(top);
		int removedIndex = 0;
		if(top<rear)
		{
			for (int i=top;i<=rear;i++) 
			{
				int current = arr.get(i).priority;
				if(current > priority)
				{
					priority = current;
					removedIndex = i;
				}
			}
			System.out.println(arr.get(removedIndex).value);
			arr.remove(removedIndex);
			rear--;
			// for(int i=0;i<arr.size();i++)
			// 	System.out.println(arr.get(i).value);
			return;
		}
		else
		{
			for(int i=top;i<arr.size();i++)
			{
				int current = arr.get(i).priority;
				if(current > priority)
				{
					priority = current;
					removedIndex = i;
				}
			}
		
			for(int i=0;i<=rear;i++)
			{
				int current = arr.get(i).priority;
				if(current > priority)
				{
					priority = current;
					removedIndex = i;
				}
			}
			System.out.println(arr.get(removedIndex).value);
			// for(int i=0;i<arr.size();i++)
			// 	System.out.println(arr.get(i).value);
		}
	}
}