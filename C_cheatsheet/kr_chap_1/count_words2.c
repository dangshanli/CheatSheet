#include<stdio.h>
/*使用for形式*/
int main(){
	double nc;
	for(nc = 0;getchar() != EOF;++nc)
		;
	printf("%.0f\n",nc);
}