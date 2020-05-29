#include <stdio.h>
#include<locale.h>
/* 当farh = 0,20,40...时候，Celsius的值 */
main(){
	setlocale(LC_CTYPE,"chs");
	char str[] = "温度转换表";
	float fahr,celsius;
	int lower,upper,step; 
	
	lower = 0; /* 温度下限 */
	upper = 300; /* 温度上限 */
	step = 20; /* 步长 */
	
	printf("%s\n",str);/* 练习1-3，打印标题 */
	fahr = lower;
	while(fahr <= upper){ /* 循环条件：下限未超越上限 */
		celsius = (5.0/9.0)*(fahr-32.0); 
		printf("%3.0f %6.2f\n",fahr,celsius);
		fahr += step;
	}
}