package software;

import java.util.*;

//�����������߼����� 
public class Calculate {

	private static String symbol = "+/*-";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��������ʽ�����ԵȺŽ�β������");
		String str = sc.nextLine();
		if(str.endsWith("=")) {
			String newstr = str.substring(0, str.length()-1);
			char r = ifSymbol(newstr);
			System.out.println(r);
			int index = str.indexOf(r);
			System.out.println(index);
			String str1 = str.substring(0, index);
			int num1 = Integer.parseInt(str1);
			String str2 = str.substring(index+1, newstr.length());
			int num2 = Integer.parseInt(str2);
			System.out.println(num1+"   "+num2);
			double result=calculate(num1,num2,r);
			
			System.out.println("����Եõ�����Ҫ��������������\n������Ϊ��"+result);
			
		}
		else
		{
			System.out.println("���������룡��");
		}
	}
	public static char ifSymbol(String str) {
		char w='\0';
		if(str.contains("+")) {
			w='+';
		}
		else if(str.contains("-")) {
			w='-';
		}
		else if(str.contains("*")) {
			w='*';
		}
		else if(str.contains("/")) {
			w='/';
		}
		return w;
	}
	public static double calculate(int num1,int num2 ,char w) {
		double result=0;
		switch(w) {
		case '+': result = num1+num2;
		break;
		case '-':result = num1-num2;
		break;
		case '*':result = num1*num2;
		break;
		case '/':result = num1/num2;
		break;
		}
	return result;
	}
}
