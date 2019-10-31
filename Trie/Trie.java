public class Trie
{
	static Node root;
	static void insert(String c)
	{
		int i,index;
		int length = c.length();
		Node crawl = root;
		for(i=0;i<length;i++)
		{
			System.out.println(c.charAt(i));
			index = c.charAt(i) - 'a';
			if(crawl.child[index] == null)
			 	crawl.child[index] = new Node();
			crawl = crawl.child[index];
		}
		crawl.isEnd = true;
	}

	static boolean search(String key)
	{
		int i,index;
		int length = key.length();
		Node crawl = root;
		for(i=0;i<length;i++)
		{
			index = key.charAt(i) - 'a';
			if(crawl.child[index] == null)
				return false;
			crawl = crawl.child[index];
		}
		return (crawl!=null &&  crawl.isEnd);
	}
	public static void main(String[] args)
	{
		root = new Node();
		insert("akshy");
		//if(search("akshy") == true)
			System.out.println("True");
	}
}