#include<stdio.h>
/*统计换行符，制表符，空格的出现个数 练习1-8*/
int main(){
	int c,n1,n2,n3;
	n1 = 0;/*换行*/
	n2 = 0;/*制表符*/
	n3 = 0;/*空格*/
	
	while((c = getchar()) != EOF){
		if(c == '\n')//换行符
			++n1;
		if(c == '\t')//制表符
			++n2;
		if(c == 32)//空格，没找到相应的转义字符，用ascii码表示：32
			++n3;
	}
	
	printf("n1 = %d,n2 = %d,n3 = %d",n1,n2,n3);
	
}