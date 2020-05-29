#include <stdio.h>
#define MAXLINE 1000
void squeeze(char[],char[]);
int isinstr(char[],int);
int getlines(char[],int);
int main(){ //测试
	int len,c;
	char line[MAXLINE];
	char matched[MAXLINE];
	
	while((len = getlines(line,MAXLINE)) >0){
		printf("\n主字符串:%s\n",line);
		if(getlines(matched,MAXLINE) > 0){
			squeeze(line,matched);			
			printf("待匹配字符串:%s\n",matched);
			printf("匹配后字符串:%s\n",line);
		}
		
	}
	
}

/* 删除s1中任何与s2中字符匹配的字符 */
void squeeze(char s1[],char s2[]){
	int i, j;
	
	for(i = j = 0;s1[i] != '\0';++i){
		if(!isinstr(s2,s1[i]))
			s1[j++] = s1[i]; 
	}
	s1[j] = '\0';
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
	
	


