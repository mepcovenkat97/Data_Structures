public class InsertionSort
{
	public static void sort(int[] a)
	{
		int key,i;
		for(int j=1;j<a.length;j++)
		{
			key = a[j];
			i=j-1;
			while(i>0 && a[i]>key)
			{
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = key;
		}
		for(i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		int[] a = {1, 19, 23, 14, 777, 55, 96, 57, 8, 99, 101, 521, 856, 999};
		sort(a);
	}
}