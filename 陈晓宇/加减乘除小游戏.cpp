#include<stdio.h>

#include<stdlib.h>

int main()

{

	float a;

	float b;	

	float c;

	float d;

	float e;

	float f;

	float g;

	float h;

	float i;

	float j;

	float k;

	float l;

	printf("加减乘除运算游戏开始\n") ;

	printf("加法运算\n"); 

    printf("请输入第一个数字：");

    scanf("%f",&a);

    printf("请输入第二个数字：");

    scanf("%f",&b);

    c=a+b;

    printf("两个数字之和:%f\n",c);

    printf("减法运算\n");

    printf("请输入第一个数字：");

    scanf("%f",&g) ;

    printf("请输入第二个数字：") ;

    scanf("%f",&h) ;

    i=g-h;

    printf("两个数字相减的结果是：%f\n",i); 

	printf("乘法运算\n");

    printf("请输入第一个数字：");

    scanf("%f",&d);

    printf("请输入第二个数字：");

    scanf("%f",&e);

    f=d*e;

    printf("两个数字相乘的结果是：%f\n",f);

    printf("除法运算\n");

	printf("请输入第一个数字：");

	scanf("%f",&j);

	printf("请输入第二个数字：");

	scanf("%f",&k);

	l=j/k; 

	printf("两个数字相除的结果为：%f\n",l);

	printf("游戏结束，咱去学习!\n") ;

	return 0;	

}
