package z;

import java.util.Scanner;

public class �ж������Ƿ��ǻ��� {
	public static boolean isPalindrome(int n)
	{
		int [] a=new int[10];
		int count=0,x=0,j;
		while(n>0)
		{
			a[x]=n%10;
			x++;
			n/=10;
		}
		for(j=0;j<x;j++)
		{
			if(a[j]==a[x-1-j])
			  count++;
		}
		if(count==x)
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		System.out.println("����һ�������ж��Ƿ�Ϊ����");
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();
		sc.close();
		boolean flag;
		flag=isPalindrome(a);
        System.out.println(flag);
	}

}
