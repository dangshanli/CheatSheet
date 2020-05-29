#include <stdio.h>

int main(){
	
	
}

/* x:[][][][]111111[][][][] */
/* y:11111111[][][]11111111 */
unsigned setbits(unsigned x,int p,int n,int y){
	/* 先处理y */
	unsigned a = (y | (~0<<p)) | ~(~0<<(p-n+1)) ;
	
	
	
	
	
	
}