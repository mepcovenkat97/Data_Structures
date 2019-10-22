import java.io.*;

public class CQSLL
{
	public static void main(String[] args)
	{
		CircularQueueUsingLinkedList ct = new CircularQueueUsingLinkedList();
		ct.enqueue(3);
		ct.enqueue(4);
		ct.dequeue();
		ct.dequeue();
		ct.dequeue();
		ct.printQueue();
	}
}