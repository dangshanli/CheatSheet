#include <stdio.h>
#define MAXLINE 1000 /* 规定极限长度 */
/* 打印任意长度输入行的 长度值(就是那个i) */
/* 读取文本把最长的一行打印出来，限制最大1000 */

int getlines(char line[],int maxline);
void copy(char to[], char from[]);

int main(){
	int len;
	int max;
	
	char line[MAXLINE];
	char longest[MAXLINE];
	
	max = 0;
	
	while((len = getlines(line,MAXLINE)) >0){
		printf("len = %d, line = %s",len,line);
		if(len > max){
			max = len;
			copy(longest,line);
		}
	}
			
	if(max > 0) /* 存在这样的行 */
		printf("\n最长的行是:\n%s\n为%d字符",longest,max);
	return 0;
}

/* 获取输入，得到最大行并保存，返回行的长度 */
int getlines(char s[],int lim){
	int c , i ;
	
	for(i = 0;(c = getchar()) != EOF && c != '\n';++i)
		if(i < lim -2){
			s[i] = c;
		}
	
	if(c == '\n'){
		s[i] = c;
		++i;
	}
	
	s[i] = '\0';
	return i;
}

/* 拷贝字符数组 */
void copy(char to[],char from[]){
	int i = 0;
	
	while((to[i] = from[i]) != '\0')
		++i;
}