public class Node
{
	Node left;
	Node right;
	int value;
	int height;
	Node(int data)
	{
		left = null;
		right = null;
		value = data;
		height = 1;
	}
}