#include <stdio.h>
/* 建立适用于小型整数求幂的函数 */

int power(int,int);
int main(){
	for(int i = 0;i<10;i++)
		printf("%1d %3d %6d\n",i,power(2,i),power(-3,i));
		
	return 0;
}

/* 只适用于比较小型的幂运算 */
int power(int m,int n){
	int p;
	p = 1;
	
	for(int i = 1;i<=n;i++)
		p = p * m;
	
	return p;
}