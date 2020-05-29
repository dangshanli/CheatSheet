#include <stdio.h>
/* x & (x-1)可以删除x最右边为1的二进制位 */

int bitcount(unsigned);
int main(){
	unsigned int x = 0xa1a3ef;
	printf("%d个1\n",bitcount(x));
}

/*
解释原因：
11 -> 10  												10
01 -> 00				x & (x-1) -->		00
							    
结论：最右边的1位，经过运算都会成为0，其他位不受影响
*/

int bitcount(unsigned x){
	int b;
	b= 0;
	while( (x &= (x-1)) != 0)
		b++;
	b++;
	return b;
}
