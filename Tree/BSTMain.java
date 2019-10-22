public class BSTMain
{
	public static void main(String[] args)
	{
		//Node root = new Node();
		BinarySearchTree bst = new BinarySearchTree();
		Node n1 = new Node(5);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(7);
		Node n5 = new Node(8);
		Node n6 = new Node(1);
		bst.insert(n1);
		bst.insert(n2);
		bst.insert(n3);
		bst.insert(n4);
		bst.insert(n5);
		bst.insert(n6);
		bst.inorder(n1);
	}
}