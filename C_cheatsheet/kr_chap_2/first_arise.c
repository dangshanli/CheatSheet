#include <stdio.h>
#define MAXLINE 1000

int any(char[],char[]);
int isinstr(char[],int);
int getlines(char[],int);
int main(){/* 测试 */
	char line[MAXLINE];
	char matched[MAXLINE];
	
	while(getlines(line,MAXLINE) > 0){
		printf("\n主字符串:%s\n",line);
		
		if(getlines(matched,MAXLINE) > 0){ 		
			printf("待匹配字符串:%s\n",matched);
			printf("首个匹配位置:%d\n",any(line,matched));
		}		
	}
	
	return 0;
}

/* 返回s2任意字符出现在s1中的首次出现位置，不包含返回-1 */
/* 这个位置从0开始计数 */
int any(char s1[],char s2 []){
	int i;
	
	for(i = 0;s1[i] != '\0';++i){
		if(isinstr(s2,s1[i]))
			return i;
	}
	
	return -1;
	
}

	/* 判定字符c是否在 字符串s中*/
	int isinstr(char s[],int c){
		int i;
		i = 0;
		while(s[i] != '\0' && s[i] != '\n'){/* '\n'不计入其中 */
			if(s[i] == c)
				return 1;
			else
				++i;
		}
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