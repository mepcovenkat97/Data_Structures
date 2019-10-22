public class MenuForLinkedList
{
	public static void main(String[] args)
	{
		MyLinkedList mt = new MyLinkedList();
		// mt.insertFront(5);
		// mt.insertFront(4);
		// mt.insertFront(3);
		// //mt.printList();
		// mt.insertAfter(6,5);
		// mt.insertAfter(7,6);
		// mt.insertAfter(8,7);
		// //mt.printList();
		// //mt.insertLast(9);
		// mt.insertLast(10);
		// mt.insertBefore(2,3);
		mt.insertFront(5);
		mt.insertFront(3);
		mt.insertFront(2);
		mt.sortedInsert(4);
		mt.sortedInsert(1);
		mt.sortedInsert(6);
		mt.printList();
		// mt.insertAfter(15,10);
		// mt.printList();
		// mt.deleteBefore(3);
		// mt.deleteFirst();
		// mt.printList();
		// mt.deleteLast();
		// mt.printList();
		// mt.deleteAfter(4);
		// mt.printList();
		// mt.deleteBefore(7);
		// mt.printList();
		// mt.deleteEle(7);
		// mt.printList();
	}
}