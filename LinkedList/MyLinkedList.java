import java.io.*;

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

public class MyLinkedList
{
	Node HEAD;
	MyLinkedList()
	{
		HEAD = new Node();
	}
	public void insertFront(int data)
	{
		Node n = new Node(data);
		n.next = HEAD.next;
		HEAD.next = n;
		//System.out.println("Front "+HEAD.next.data);
	}
	public void insertBefore(int ele, int before)
	{
		Node n = new Node(ele);
		Node t = HEAD;
		if(t.next.data == before)
		{
			this.insertFront(ele);
		}
		else
		{
			while(t.next.data != before)
				t = t.next;
			n.next = t.next;
			t.next = n;
		}
	}
	public void sortedInsert(int ele)
	{
		Node n = new Node(ele);
		Node t = HEAD.next;
		int flag = 0;
		if(t.data > ele || t == null)
			this.insertFront(ele);
		else
		{
			while(!(t.data <= ele));
			{
				t = t.next;
				if(t.next == null);
					flag = 1;
				//System.out.println(t.data);
			}
			if(flag == 1)
				this.insertLast(ele);
			else
				this.insertBefore(ele,t.next.data);
		}
	}
	public void insertAfter(int data, int after)
	{
		Node n = new Node(data);
		Node t = HEAD;
		while(t.data != after)
		{
			t = t.next;
			//System.out.println("After "+t.data);
		}
		n.next = t.next;
		t.next = n;
	}
	public void insertLast(int data)
	{
		Node n = new Node(data);
		Node t = HEAD;
		while(t.next != null)
		{
			t = t.next;
			//System.out.println("Last "+t.data);
		}
		n.next = null;
		t.next = n;
	}

	public void deleteFirst()
	{
		Node n = HEAD;
		if(n.next != null)
			HEAD.next = HEAD.next.next;
		else
			System.out.println("List Empty");
	}

	public void deleteEle(int ele)
	{
		Node t = HEAD;
		if(t.next == null)
			System.out.println("List Empty");
		while(t.next.data != ele)
		{
			t = t.next;
		}
		t.next = t.next.next;

	}

	public void deleteAfter(int ele)
	{
		Node t = HEAD.next;
		while(t.data != ele)
		{
			t = t.next;
		}
		if(t.next != null)
			t.next = t.next.next;
		else
			System.out.println("No Elements to delete After that");
	}
	public void deleteBefore(int ele)
	{
		Node t = HEAD;
		if(t.next.data == ele)
			System.out.println("No Elements to Delete Before");
		else
		{
			while(t.next.next.data != ele)
			{
				t = t.next;
			}
			t.next = t.next.next;
		}
	}
	public void deleteLast()
	{
		 Node t = HEAD;
		 while(t.next.next != null)
		 {
		 	t = t.next;
		 }
		 t.next = null;
	}
	public void deleteAll()
	{
		HEAD.next = null;
	}
	public void printList()
	{
		Node t = HEAD;
		while(t.next != null)
		{
			System.out.print(t.next.data+" ");
			t = t.next;
		}
		System.out.println();
	}
}