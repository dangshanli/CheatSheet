#include <stdio.h>

/* 统计一段文本的各个数字(0-9)，空白符('\n' '\t' ' ')以及其他字符出现的次数 */
int main(){
	int c,nwhite,nother;
	
	int ndigit[10];
	
	/*初始化数组*/
	for(int i=0;i<10;i++){
		ndigit[i] = 0;
	}
	
	while((c = getchar()) != EOF){
		if(c >= '0'&& c <= '9') /* 数字统计，使用数组装0-9的数值*/
			++ndigit[c-'0'];
		else if(c == '\n' || c=='\t' || c==' ') /* 统计空白符 */
			++nwhite;
		else
			++nother; /* 其他 */
	}
	
	printf("digit = ");
	/* 打印统计结果 */
	for(int i=0;i<10;i++){
		printf(" %d",ndigit[i]);
	}
	
	printf(", white space = %d, other = %d\n",nwhite,nother);
}