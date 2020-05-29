#include<stdio.h>
/* 统计字数 */
/* [ctrl + d]是结束输入的，不是[enter]*/
int main(){
	long nc;
	nc = 0;
	while(getchar() != EOF){/* getchar不断从stdin里面获取单字符，知道字符流结束 */
		++nc;
		//printf("%ld\n",nc);
	}
	
	printf("%ld\n",nc);
}