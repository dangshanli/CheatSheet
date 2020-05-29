#include<stdio.h>
/* 统计行数 */
int main(){
	int c,n1;
	
	n1 = 0;
	while((c = getchar()) != EOF){
		if(c == '\n') /* 碰到转行符+1 */
			++n1;
	}
	printf("%d\n",n1);
}