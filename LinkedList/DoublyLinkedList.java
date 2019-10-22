import java.io.*;

class DNode
{
	int data;
	DNode next;
	DNode previous;
	DNode()
	{
		this.next = null;
		this.previous = null;
	}
	DNode(int ele)
	{
		this.data = ele;
		this.next = null;
		this.previous = null;
	}
}

public class DoublyLinkedList
{
	DNode HEAD;
	DNode FOOT;
	DoublyLinkedList()
	{
		HEAD = new DNode();
		FOOT = new DNode();
		HEAD.next = FOOT;
		HEAD.previous = FOOT;
		FOOT.previous = HEAD;
		FOOT.next = HEAD;
	}

	public void insertFront(int ele)
	{
		DNode n = new DNode(ele);
		if(HEAD.next != FOOT)
		{
			n.previous = HEAD;
			HEAD.next.previous = n;
			n.next = HEAD.next;
			HEAD.next = n;
		}
		else
		{
			n.previous = HEAD;
			n.next = FOOT;
			HEAD.next = n;
			FOOT.previous = n;
		}
	}

	public void insertLast(int ele)
	{
		DNode n = new DNode(ele);
		DNode t = HEAD;
		while(t.next != FOOT)
		{
			t = t.next;
		}
		n.previous = t;
		n.next = t.next;
		t.next = n;
	}
	public void insertBefore(int ele,int before)
	{
		DNode n = new DNode(ele);
		DNode t = HEAD;
		if(t.next == FOOT)
			this.insertFront(ele);
		else
		{
			while(t.next.data != before)
			{
				t = t.next;
				if(t == FOOT)
				{
					System.out.println("Element Not Found");
					break;
				}
			}
			n.next = t.next;
			t.next.previous = n;
			n.previous = t;
			t.next = n;
		}
	}
	public void insertAfter(int ele,int after)
	{
		DNode n = new DNode(ele);
		DNode t = HEAD.next;
		if(t == FOOT)
			this.insertFront(ele);
		else
		{
			while(t.data != after)
				t = t.next;
			n.next = t.next;
			t.next.previous = n;
			n.previous = t;
			t.next = n;
		}
	}

	public void deleteFirst()
	{
		DNode t = HEAD;
		if(t.next == FOOT)
			System.out.println("List is Empty");
		else
		{
			t.next = t.next.next;
			t.next.previous = HEAD;
		}
	}
	public void deleteLast()
	{
		DNode t = HEAD;
		if(t.next == FOOT)
			System.out.println("List is Empty");
		else
		{
			while(t.next.next != FOOT)
				t = t.next;
			t.next = FOOT;
			FOOT.previous = t;
		}
	}
	public void deleteBefore(int before)
	{
		DNode t = HEAD;
		if(t.next == FOOT)
			System.out.println("List is Empty");
		else
		{
			while(t.next.next.data != before)
				t = t.next;
			t.next.next.previous = t;
			t.next = t.next.next;
		}
	}
	public void deleteAfter(int after)
	{
		DNode t = HEAD;
		if(t.next == FOOT)
			System.out.println("List is Empty");
		else
		{
			while(t.data != after)
				t = t.next;
			t.next.previous = t;
			t.next = t.next.next;
		}
	}
	public void printList()
	{
		DNode t = HEAD;
		if(t.next == FOOT)
			System.out.println("List is Empty");
		else
		{
			while(t.next != FOOT)
			{
				System.out.println(t.next.data);
				t = t.next;
			}
		}
	}
}