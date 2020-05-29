# include<stdio.h>
/* 测试一组二进制为中1的个数 */
int bitcount(unsigned);
int main(){
  int n = 0xa1a3ef;
  printf("0xa1a3ef %d 个1\n",bitcount(n));
	
}

int bitcount(unsigned x){
	int b;
	
	for(b = 0; x != 0;x >>= 1)
		if(x &01) /* 如果x最后一位是1则为true，+1 */
			b++;
	
	return b;
}

