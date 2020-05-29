#include <stdio.h>
/* 摄氏度(fahr = 300,280,260...)转换华氏度，逆序 */
void main(){
	float fahr;
	printf("摄氏度转华氏度逆序表\n");
	printf("%3s\t%6s\n","fahr","celsius");/* 打印表头 */
	for(fahr = 300;fahr >=0;fahr = fahr-20){/* 逆序，初始值300 ，步长20递减 */
		printf("%3.0f\t%6.1f\n",fahr,(fahr-32.0)*(5.0/9.0));
	}
}