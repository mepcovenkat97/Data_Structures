class Node
{
	Node[] child;
	char val;
	boolean isEnd;
	Node()
	{
		isEnd = false;
		//for(int i=0;i<26;i++)
		// 	child[i] = null;
	}
	Node(char c)
	{
		val = c;
		isEnd = false;
		for(int i=0;i<26;i++)
			child[i] = null;
	}
}