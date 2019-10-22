import java.util.*;

public class RadixSort
{
	public static int largest(int[] A, int n)
	{
		int mx = A[0];
		for(int i=0;i<A.length;i++)
		{
			if(A[i]>mx)
				mx = A[i];
		}
		return mx;
	}
	public static int digits(int n)
	{
		int digits = 0;
		while(n !=0)
		{
			digits++;
			n = n/10;
		}
		return digits;
	}
	public static void dSort(int[] A,int n,int exp)
	{
		int[] op = new int[n];
		int i;
		int[] count = new int[10];
		Arrays.fill(count,0);
		for(i=0;i<n;i++)
			count[(A[i]/exp)%10]++;

		for(i=1;i<10;i++)
			count[i] += count[i-1];

		for(i = n-1;i>=0;i--)
		{
			op[count[(A[i]/exp)%10]-1] = A[i];
			count[(A[i]/exp)%10]--;
		}

		for(i=0;i<n;i++)
			A[i] = op[i];
	}

	public static void print(int A[], int n) 
    { 
        for (int i=0; i<n; i++) 
            System.out.print(A[i]+" ");
        System.out.println();
    } 

	public static void sort(int[] A,int n)
	{
		int m = largest(A, A.length);
		for(int exp = 1; m/exp>0;exp*=10)
			dSort(A,A.length,exp);
	}
	public static void main(String[] args)
	{
		int[] A = {1, 19, 23, 14, 777, 55, 96, 57, 8, 99, 101, 521, 856, 999};
		sort(A,A.length);
		print(A,A.length);
	}
}