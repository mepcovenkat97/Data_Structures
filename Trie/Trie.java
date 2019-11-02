import java.io.*;
import java.util.Scanner;

public class Trie
{
	static Node root;
	static void insert(String c)
	{
		int i,index=0;
		int length = c.length();
		Node crawl = root;
		for(i=0;i<length;i++)
		{
			//System.out.println(c.charAt(i));
			if(c.charAt(i)>='a' && c.charAt(i)<='z')
				index = c.charAt(i) - 'a';
			if(c.charAt(i)>='A' && c.charAt(i)<='Z')
				index = c.charAt(i) - 'A';
			if(crawl.child[index] == null)
			{
			 	crawl.child[index] = new Node();
			 	crawl.child[index].val = c.charAt(i);
			}
			crawl = crawl.child[index];
		}
		crawl.isEnd = true;
	}

	static boolean search(String key)
	{
		int i,index=0;
		int length = key.length();
		Node crawl = root;
		for(i=0;i<length;i++)
		{
			if(key.charAt(i)>='a' && key.charAt(i)<='z')
				index = key.charAt(i) - 'a';
			if(key.charAt(i)>='A' && key.charAt(i)<='Z')
				index = key.charAt(i) - 'A';
			if(crawl.child[index] == null)   //if(crawl.child[index].val == null)
				return false;
			crawl = crawl.child[index];
		}
		return (crawl!=null &&  crawl.isEnd);
	}
	public static void main(String[] args)
	{
		root = new Node();
		insert("akshy");
		insert("akshi");
		insert("a");
		insert("ass");
		insert("ask");
		insert("aks");
		insert("Zebra");
		insert("boat");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a search String");
		String ser = in.next();
		if(search(ser) == true)
			System.out.println("True");
		else
			System.out.println("False");
	}
}