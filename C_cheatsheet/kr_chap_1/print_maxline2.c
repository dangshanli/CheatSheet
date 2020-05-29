#include <stdio.h>
#define MAXLINE 1000

int max;
char line[MAXLINE];
char longest[MAXLINE];

int getlines(void);
void copy(void);
/* 使用外部变量重写方法,外部变量使用，就不必通过传参取值了 */
int main(){
	int len;
	extern int max; /* 显示声明 */
	extern char longest[];
	max = 0;/* 外部变量默认为0，这里显示初始化 */
	
	while((len = getlines()) >0)
		if(len > max){
			max = len;
			copy();
		}
	if(max > 0)
	printf("\n最长字符串:\n%s\n",longest);
	
	return 0;
}

/* return 字符串长度，保存最长行进字符数组 */
int getlines(){
	int c,i;
	extern char line[];
	
	/* condition:  <最大值-1(还保留一位给'\n')    文本未结束(EOF)  未换行('\n')*/
	for(i = 0; i < MAXLINE-1 && (c = getchar()) != EOF && c != '\n'; ++i) 
		line[i] = c;
	
	if( c == '\n'){
		line[i] = c;
		++i;
	}
	
	line[i] = '\0'; /* 字符数组最后加上'\0'结束符 */
	return i;
}

/* 暂存字符数组line向最大字符数组longest复制元素 */
void copy(){
	int i = 0;
	extern char line[],longest[]; 
	
	while((longest[i] = line[i]) != '\0') /* 一直复制到'\0'结束符 */
		++i;
}