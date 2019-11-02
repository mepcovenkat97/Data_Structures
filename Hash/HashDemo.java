class Record
{
	int value;
	int key;
	Record()
	{
		this.value = -1;
		this.key = -1;
	}
	Record(int key,int value)
	{
		this.key = key;
		this.value = value;
	}
}
public class HashDemo
{
	static Record[] input;
	HashDemo()
	{
		input = new Record[20];
		for(int i=0;i<20;i++)
			input[i] = new Record(Hash(i),-1);
	}
	public static int Hashm1(int n)
	{
		int hashval = n%96;
		return hashval;
	}
	public static int Hashm2(int n)
	{
		int sq = n*n;
		int hashval = sq%100;
		return hashval;
	}
	public static int Hashm3(int n)
	{
		int ele = n;
		int sum = 0;
		while(n!=0)
		{
			sum += (n%100);
			n = n%100;
		}
		int hashval = sum%100;
		return hashval;
	}
	public static void insertVal(int n)
	{
		int flag =0;
		int k=0;
		int i = Hash(n);
		for(int j=0;j<20;j++)
		{
			if(input[j].key == i)
			{
				if(input[j].value == -1)
				{
					input[j].value = n;
					flag = 1;
					break;
				}
				else
				{
					k = j++;
					flag = 0;
				}
			}
		}
		if(flag == 0)
		{
			while(input[k].value != -1)
				k++;
			input[k].value = n;
		}
	}

	public int searchVal(int n)
	{
		int flag = 0;
		int i = Hash(n);
		for(int j=0;j<20;j++)
		{
			if(input[j].key == i)
			{
				flag = 1;
				if(input[j].value == n)
					return j;
			}
			else
			{
				if(flag == 1)
				{
					if(input[j].value == n)
						return j;
				}
			}
		}
	}
	public void deleteVal(int n)
	{
		int flag = 0;
		int i = Hash(n);
		for(int j=0;j<20;j++)
		{
			if(input[i].key == i)
			{
				flag = 1;
				if(input[j].value == n)
					input[j].value = -1;
			}
			else
			{
				if(flag == 1)
				{
					if(input[j].value == n)
						input[j].value = -1;
				}
			}
		}
	}
	public void printHash()
	{
		for(int i=0;i<20-1;i++)
			System.out.println(input[i].key+" "+input[i].value);
	}
}
