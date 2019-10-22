class Node
{
	int data;
	Node next;
	Node()
	{
		this.next = null;
	}
	Node(int ele)
	{
		this.data = ele;
		this.next = null;
	}
}

public class CircularQueueUsingLinkedList
{
	Node HEAD;
	Node TAIL;
	CircularQueueUsingLinkedList()
	{
		HEAD = new Node();
		TAIL = new Node();
		HEAD.next = null;
		//TAIL.next = HEAD.next;
	}
	public void enqueue(int ele)
	{
		Node n = new Node(ele);
		Node t = HEAD.next;
		if(HEAD.next == null)
		{
			HEAD.next = n;
			n.next = n;
		}
		else
		{
			while(t.next != HEAD.next)
				t = t.next;
			n.next = HEAD.next;
			t.next = n;
		}
	}

	public void dequeue()
	{
		if(HEAD.next == null)
			System.out.println("i-Queue is Empty");
		Node t = HEAD.next;
		Node p = HEAD.next;
		if(t.next == HEAD.next)
			HEAD.next = null;
		else
		{
			while(t.next != HEAD.next)
				t = t.next;
			HEAD.next = p.next;
			t.next = HEAD.next;
		}
	}

	public void printQueue()
	{
		if(HEAD.next == null)
			System.out.println("Queue is Empty");
		else
		{	
			Node t = HEAD.next;
			// if(t.next == HEAD.next)
			// 	System.out.println(t.data);
			while(t.next != HEAD.next)
			{
				System.out.println(t.data);
				t = t.next;
			}
			System.out.println(t.data);
		}
	}
}