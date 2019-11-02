import java.io.*;
import java.util.Scanner;
public class ShortestPath
{
	public static void Warshall(int matrix[][])
	{
		int [][]temp = new int[4][4];
		for (int i = 0; i < 4; i++)
		{ 
            for (int j = 0; j < 4; j++) 
                temp[i][j] = matrix[i][j];
        }
        for(int k=0;k<4;k++)
        {
        	for(int i=0;i<4;i++)
        	{
        		for(int j=0;j<4;j++)
        		{
        			if(temp[i][k]+temp[k][j] < temp[i][j])
        				temp[i][j] = temp[i][k]+temp[k][j];
        		}
        	}
        }
        printMatrix(temp);
	}

	public static void printMatrix(int temp[][])
	{
		System.out.println();
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[][] matrix = new int[4][4];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				matrix[i][j] = in.nextInt();
			}
		}
		Warshall(matrix);
	}
}