import java.io.*;

public class MenuForDoublyLinkedList
{
	public static void main(String[] args)
	{
		DoublyLinkedList dt = new DoublyLinkedList();
		dt.insertFront(5);
		dt.insertLast(7);
		dt.insertBefore(6,7);
		dt.insertAfter(8,7);
		//dt.deleteFirst();
		//dt.deleteLast();
		//dt.deleteAfter(6);
		dt.insertBefore(4,5);
		dt.insertBefore(2,3);
		dt.printList();
	}
}