import java.io.*;
import java.util.Stack;
import java.util.Queue;

import java.util.LinkedList;

public class Prob15
{
	public static void cheakString(String A)
	{
		Stack<Character> mt = new Stack<Character>();
		Queue<Character> qt = new LinkedList<Character>();
		int flag = 1;
		String[] B = A.split("C");
		if(B[0].length() != B[1].length())
		{
			System.out.println("Not Equal");
		}
		else
		{
			/*
				Implement Without Stack or Queue
			*/

			// int l = B[1].length()-1;
			// for(int i=0;i<B[0].length();i++)
			// {
			// 	if(B[0].charAt(i) != B[1].charAt(l))
			// 	{	
			// 		flag = 0;
			// 		break;
			// 	}
			// 	else
			// 	{
			// 		l--;
			// 	}
			// }
			// if(flag == 0)
			// 	System.out.println("Not Equal");
			// else
			// 	System.out.println("Same");

			/*
				Implement With Stack
			*/
			for(int i=0;i<B[0].length();i++)
			{
				mt.push(B[0].charAt(i));
			}
			for(int j=0;j<B[1].length();j++)
			{
				if(mt.peek() != B[1].charAt(j))
				{
					flag = 0;
					break;
				}
				else
				{
					mt.pop();
				}
			}
			if(flag == 0)
				System.out.println("Not Equal");
			else
				System.out.println("Same");

			/*
				Implement With Queue(Not Working)
			*/
			/*for(int i=0;i<B[0].length();i++)
			{
				qt.add(B[0].charAt(i));
			}
			for(int j=B[1].length()-1;j<=0;j++)
			{
				if(qt.peek() != B[1].charAt(j))
				{
					flag = 0;
					break;
				}
				else
				{
					qt.remove();
				}
				//System.out.println(qt.element());
			}
			if(flag == 0)
				System.out.println("Not Equal");
			else
				System.out.println("Same");*/
		}
	}
	public static void main(String[] args)
	{
		String A = "abcaCazba";
		cheakString(A);
	}
}