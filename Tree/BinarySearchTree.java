class Node
{
	Node left;
	Node right;
	int data;
	Node()
	{
		left = null;
		right = null;
		//data = null;
	}
	Node(int e)
	{
		left = null;
		right = null;
		data = e;
	}
}
public class BinarySearchTree
{
	Node root = new Node();
	public void insert(Node n)
	{
		Node parent = search(n);
		//System.out.println(parent.data);
		if(root.data == 0)
		{
			System.out.println("Root =>"+parent.data);
			root = n;
		}
		else if(parent.data > n.data)
		{
			parent.left = n;
			System.out.println("Left =>"+parent.left.data);
		}
		else
		{
			parent.right = n;
			System.out.println("Right =>"+parent.right.data);
		}
		
	}
	public Node search(Node n)
	{
		{
			Node temp = root;
			Node parent = new Node();
			while(temp!=null)
			{
				if(temp.data == n.data)
					return temp;
				if(temp.data < n.data)
				{
					parent = temp;
					temp = temp.right;
				}
				else
				{
					parent = temp;
					temp = temp.left;
				}
			}
			System.out.println("Search =>"+parent.data);
			return parent;
		}
	}

	public void inorder(Node n)
	{
		if(n != null)
		{
			inorder(n.left);
			System.out.println(n.data);
			inorder(n.right);
		}
	}
}