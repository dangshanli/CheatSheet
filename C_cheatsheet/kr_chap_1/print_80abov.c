#include <stdio.h>
#define MAXLINE 1000
/* 打印长度>80的所有输入行*/

int getlines(char[],int);
int main(){
	int len;
	char line[MAXLINE];
	
	while((len = getlines(line,MAXLINE)) > 0)
		if(len > 80)
		printf("\nlen = %d,line = %s",len,line);
	
	return 0;
}

/* 获取输入，得到最大行并保存，返回行的长度 */
int getlines(char s[],int lim){
	int c,i;
	
	for(i = 0; (c = getchar()) != EOF && c != '\n';++i)
		if(i <lim - 2)
			s[i] = c;

	if(c == '\n'){
		s[i] = c;
		++i;
	}
	
	s[i] = '\0';
	return i;
}
