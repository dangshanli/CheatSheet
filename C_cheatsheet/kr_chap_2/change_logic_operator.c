#include <stdio.h>
/* 不使用 && 和 ||编写logic_form的for循环 */
#define MAXLINE 1000
int none_logic(char[],int);
int main(){  //测试
	char s[MAXLINE];
	
	while( none_logic(s,MAXLINE) > 0 )
		printf("\n\n%s",s);
}

void logic_form(char line[],int lim){//原版
	int c,i;
	
	for(i = 0;i< i<lim-1 && (c = getchar()) != '\n' && c  != EOF;++i)
		line[i] = c;	
}

int none_logic(char line[],int lim){//修改后，不用逻辑符号
	int c,i;
	
	i = 0;
	while(i<lim - 1){
		c =  getchar();
		if(c !='\n')
			if(c != EOF){
				line[i] = c;
				++i;
			}
			else 
				break;
		else
			break;
	}
	
	if(c == '\n')
		line[i] = '\n';
	
	++i;
	line[i] = '\0';
	return i;
}