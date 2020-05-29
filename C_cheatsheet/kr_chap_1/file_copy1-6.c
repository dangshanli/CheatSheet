#include <stdio.h>
/* 测试当赋值语句没有括起来的后果。即c得到什么值 */
int main(){
	int c;

	while(c = getchar() != EOF){ 
		//putchar(c);/* putchar()打印不出来 */
		printf("%d",c);
		//printf("%s\n",c); /* 打印不出来，程序跳出 */
	}
	
}