import java.io.*;
import java.util.*;
class Node
{
	int data; 
    Node left, right; 
    public Node(int item) 
    { 
        data = item; 
        left = null; 
        right = null; 
    } 
}
public class BFS
{
	//This is Level order Traversal for Tree
	
	/*Node root;
	void traversal()
	{
		Queue<Node> tq = new LinkedList<Node>();
		tq.add(root);
		while(!tq.isEmpty())
		{
			Node temp = tq.poll();
			System.out.print(temp.data+" ");
			if(temp.left != null)
				tq.add(temp.left);
			if(temp.right != null)
				tq.add(temp.right);
		}
	}
	public static void main(String[] args)
	{
		BFS tree = new BFS();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(4); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5);
        tree.traversal();
	}*/
	public int vertices;
	public LinkedList<Integer> adj[];
	BFS(int v)
	{
		vertices = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList();
	}
	void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	void traversal(int s)
	{
		boolean[] visited = new boolean[vertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		while(queue.size() != 0)
		{
			s = queue.poll();
			System.out.print(s+" ");
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		BFS g = new BFS(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        g.traversal(2);
	}
}