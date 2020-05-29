#include<stdio.h>
/* 华氏温度celsius=0,20,40...300 转 摄氏温度fahr */
void main(){
	float fahr,celsius;
	
	int lower,upper,step;
	lower = 0; //华氏度下限
	upper = 300; //上限
	step = 20; //步长
	
	celsius = lower;
	printf("摄氏转华氏温度表\n");
	printf("%3s\t%6s\n","fahr","celsius");/* 打印表头 */
	while(celsius <= upper){/* 华氏度小于上限值 */
		fahr = (9.0/5.0)*celsius + 32;
		printf("%3.0f\t%6.2f\n",celsius,fahr); //Celsius 占位3字符，0个小数点; fahr占位6个字符，一个小数点
		celsius += step;
	}
}

