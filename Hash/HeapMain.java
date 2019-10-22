public class HeapMain
{
	public static void main(String[] args)
	{
		MaxHeap mp = new MaxHeap(10);
		mp.printHeap();
		mp.insert(43);
		mp.insert(12);
		mp.insert(72);
		mp.insert(5);
		mp.insert(89);
		mp.insert(32);
		mp.insert(29);
		mp.insert(46);
		mp.insert(59);
		mp.printHeap();
	}
}