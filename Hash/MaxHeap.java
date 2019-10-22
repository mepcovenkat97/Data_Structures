public class MaxHeap
{
	// static int[] arr;
	// MaxHeap(int n)
	// {
	// 	arr = new int[n]; 
	// 	//for(int i=0;i<n;i++)
	// 		//arr[i] = 0;
	// }
	// public static void checkParent(int ele)
	// {
	// 	int j = 0;
	// 	for(int i=0;i<arr.length;i++)
	// 	{
	// 		if(arr[i] == ele)
	// 		{
	// 			j=i;
	// 			break;
	// 		}
	// 	}
	// 	while(arr[(j-1)/2] < arr[j] && j!=0)
	// 	{
	// 		int t =arr[(j-1)/2];
	// 		arr[(j-1)/2] = arr[j];
	// 		arr[j] = t;
	// 		j = (j-1)/2;
	// 	}
	// }
	// public static void insert(int ele)
	// {
	// 	for(int i=0;i<arr.length;i++)
	// 	{
	// 		if(arr[i]!=0)
	// 		{
	// 			//arr[i] = ele;
	// 			break;
	// 		}
	// 	}
	// 	arr[arr.length - 1] = ele;
	// 	checkParent(ele);
	// }
	// public static void printHeap()
	// {
	// 	for(int i=0;i<arr.length;i++)
	// 	{
	// 		System.out.print(arr[i]+" ");
	// 	}
	// 	System.out.println();
	// }
	    void generateHeap(int[] arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            int p = (i-1)/2;
            if(arr[i] > arr[p])
            {
                while(arr[i] > arr[p]){
                    int temp = arr[p];
                    arr[p] = arr[i];
                    arr[i] = temp;
                    i = p;
                    p =  (p-1)/2;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    void sort(int[] arr){
        this.generateHeap(arr);
        int length = arr.length-1;
        while(length>0){
            int root = arr[0];
            int tail = arr[length];
            int temp = root;
            arr[0] = tail;
            arr[length] = temp;
            length--;
            System.out.println(Arrays.toString(arr));
                int parent = 0;
                int childOne = 2*parent+1;
                int childTwo = 2*parent+2;
                int counter = 0;
//            System.out.println(length);
                while((childOne<=length && childTwo<=length) && (arr[parent] < arr[childOne] || arr[parent] < arr[childTwo]))
                {
                        if(arr[childOne] > arr[childTwo]){
                            int t = arr[parent];
                            arr[parent] = arr[childOne];
                            arr[childOne] = t;
                            parent = childOne;

                        }
                        else{
                            int t = arr[parent];
                            arr[parent] = arr[childTwo];
                            arr[childTwo] = t;
                            parent = childTwo;
                        }





                    childOne = parent*2+1;
                    childTwo = parent*2+2;
//                    System.out.println(childOne+" "+childTwo+" "+parent);
                }
        }
        System.out.println(Arrays.toString(arr));

    }
}