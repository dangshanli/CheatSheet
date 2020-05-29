#include <stdio.h>
/* 使用函数实现温度转换计算部分 */

#define LOWER 0
#define UPPER 300
#define STEP 20
float transfer_temper(int);
int main(){
	
	int fahr;/*摄氏度*/
	float celsius;/*华氏度*/
	
	printf("宏定义编写方法的表单\n");
	printf("%3s\t%6s\n","fahr","celsius");/* 打印表头 */
	
	for(fahr = LOWER;fahr <= UPPER;fahr +=STEP){
		celsius = transfer_temper(fahr);
		printf("%3d\t%6.1f\n",fahr,celsius);
	}
	return 0;
}

float transfer_temper(int fahr){
	float celsius;
	celsius = (fahr -32.0)*(5.0/9.0);
	return 	celsius;
}