package AddBinary;

public class Solution {
	public static void main(String[] args) {
	   System.out.println();
       Solution solution=new Solution();
       String a="1010010101001";
       String b="111111111111111111111111011";
       solution.addBinary(a, b);
	}
	public String addBinary(String a, String b) 
	{

		int length=Math.max(a.length(), b.length());
		
		int inta[]=new int[length];
		int intb[]=new int[length];
		
		int count[]=new int[length+1];
		
		int sum=0;
		for(int i=a.length()-1;i>=0;i--)
		{
			inta[sum]=Integer.parseInt(a.substring(i,i+1));
			sum++;
		}
		System.out.print("  ");
		for(int i=inta.length-1;i>=0;i--)
		{
			System.out.print(inta[i]+" ");
		}
		System.out.println();
		sum=0;
		System.out.print("+ ");
		for(int i=b.length()-1;i>=0;i--)
		{
			intb[sum]=Integer.parseInt(b.substring(i,i+1));
			sum++;
		}
		for(int i=intb.length-1;i>=0;i--)
		{
			System.out.print(intb[i]+" ");
		}
		System.out.println();
		
		
		boolean flags=false;//初始没有进位
		for(int i=0;i<inta.length;i++)
		{
			int aa=inta[i];
			int bb=intb[i];
			if(flags==true)
			{
				int k=aa+bb+1;
				if(k>=2)
				{
					count[i]=k%2;
					flags=true;//有新的进位
				}
				else
				{
					count[i]=k;
					flags=false;//没有进位
				}
			}
			else
			{
				int k=aa+bb;
				if(k>=2)
				{
					count[i]=k%2;
					flags=true;//有新的进位
				}
				else
				{
					count[i]=k;
					flags=false;//没有进位
				}
			}
		}
		
		if(flags==true)
		{
			count[count.length-1]=1;
		}
		else
		{
			count[count.length-1]=0;
		}
		
		String line="";
		for(int i=count.length-1;i>=0;i--)
		{
			if(i==count.length-1)
			{
				if(count[i]!=0)
				{
					line=line+String.valueOf(count[i]);
				}
			}
			else
			{
				line=line+String.valueOf(count[i]);
			}
			System.out.print(count[i]+" ");
		}
		System.out.println();
		System.out.println(line);
		return line;
    }
}
