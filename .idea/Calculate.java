package software;

import java.util.*;

//计算器运算逻辑部分 
public class Calculate {

	private static String symbol = "+/*-";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入算式，且以等号结尾！！！");
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
			
			System.out.println("你可以得到你想要的运算结果！！！\n运算结果为："+result);
			
		}
		else
		{
			System.out.println("请重新输入！！");
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
