import java.io.*;
import java.util.*;
public class DFS
{
	private int vertices;
	private boolean[] visited;
	private LinkedList<Integer> adj[];
	DFS(int v)
	{
		vertices = v;
		visited = new boolean[v];
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i] = new LinkedList<>();
		}
	}
	void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	void traversal(int v)
	{
		visited[v] = true;
		System.out.print(v+" ");

		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n])
			{
				traversal(n);
			}
		}
	}
	public static void main(String[] args)
	{
		DFS g = new DFS(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        g.traversal(2);
        System.out.println();
	}
}