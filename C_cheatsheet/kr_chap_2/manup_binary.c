#include <stdio.h>

int main(){
	
	
}

/* x:[][][][]111111[][][][] */
/* y:11111111[][][]11111111 */
unsigned setbits(unsigned x,int p,int n,int y){
	/* 先处理y */
	unsigned a = (y | (~0<<p)) | ~(~0<<(p-n+1)) ;//11111[][][][]11111
	
	/* 处理x */
	unsigned c = ~((~0<<p) | ~(~0<<(p-n+1)));//00000111111100000模式
	
	unsigned b = x | c;//[][][]111111[]][][]
	
	return a&b;//bbbbbbbbaaaaaabbbbbbbb模式，a插b
}


/* 从p位开始的n位取反，x:[][][]------[][][][]  -->  [][][]++++++[][][] */
unsigned invert(unsigned x,int p,int n){
	unsigned a = (x>>(p-n+1) & ~(~0<<n))<<(p-n+1);//x --> 00000[][][][]00000
	unsigned b = ~a;//11111(   取反   )111111
	
	unsigned c = (x | (~0<<p)) | ~(~0<<(p-n+1)) ;//x --> [][][][]111111[][][]
	unsigned d = x | c;
	
	return b & d;
}

/* 操作数x循环右移n位（最右端移出的位到了最左端） */
unsigned rightrot(unsigned x, int n){
	int i;
	unsigned y;
	unsigned a = ~(~0<<n) & x;//截出最右边n位
	
	i = 0;
	y = x;
	while(y != 0){
		y>>1;
		++i;
	}
	
	return((x>>n) | (~0<<(i-n))) & ( (a<<(i-n)) | ~(~0<<(i-n)) );//1111[ 左边的i-n位] & [ 最右边的n位 ]1111111
}



