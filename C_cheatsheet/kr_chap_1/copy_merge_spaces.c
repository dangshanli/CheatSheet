#include <stdio.h>
/* 复制输入到显示器，将多个空格合并成单个空格 练习1-9*/
int main(){
	int c,n;
	n = 0;//空格计数器
	while((c = getchar()) != EOF){
		
		if(c == 32)
			++n;//遇到空格计数
		else{	
			if(n > 0)//空格转非空格，打印空格
				putchar(32);
			n = 0;//重置
		}
			
		if(c != 32)//正常打印
			putchar(c);
		
	}
}