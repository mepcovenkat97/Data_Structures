import java.io.*;
public class QuickSortImp
{
	QuickSortImp(){}
	public static int partition(int[] a,int start,int stop)
	{
		int x = a[stop];
		int i = start-1;
		for(int j=start;j<stop;j++)
		{
			if(a[j]<= x)
			{
				i++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int tt = a[i+1];
		a[i+1] = a[stop];
		a[stop] = tt;
		return i+1;
	}
	public static void qckSort(int[] a, int start, int stop)
	{
		if(start < stop)
		{
			int g = partition(a,start,stop);
			qckSort(a,start,g-1);
			qckSort(a,g+1,stop);
			//printArray(a);
		}
	}
	public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
	public static void main(String[] args)
	{
		int[] A = {1, 19, 23, 14, 777, 55, 96, 57, 8, 99, 101, 521, 856, 999};
		System.out.println(A.length);
		QuickSortImp qb = new QuickSortImp();
		qb.qckSort(A,0,A.length-1);
		printArray(A);
	}
}