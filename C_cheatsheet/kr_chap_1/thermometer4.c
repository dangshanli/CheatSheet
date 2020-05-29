#include<stdio.h>

#define LOWER 0 /* 下限 */
#define UPPER 300 /* 上限 */
#define STEP 20 /* 步长 */
/* 使用宏来定义常数，便于理解 */
void main(){
	float fahr;
	printf("宏定义编写方法的表单\n");
	printf("%3s\t%6s\n","fahr","celsius");/* 打印表头 */
	for(fahr = LOWER;fahr <= UPPER;fahr += STEP){
		printf("%3.0f\t%6.1f\n",fahr,(fahr-32.0)*(5.0/9.0));
	}
}