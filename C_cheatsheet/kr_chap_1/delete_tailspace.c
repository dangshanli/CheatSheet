# include<stdio.h>
#define MAXLINE 1000

/* 将文本的最后的空格 和 制表符去掉，如果全部是空格则删掉该行 */

int getlines(char[],int);
int processline(char[]);

int main(){
	int c,len;
	char line[MAXLINE];
	while((len = getlines(line,MAXLINE)) > 0){
		if(processline(line) > 0) /* 处理后仍然有字符则打印 */
			printf("%s",line);
	}
	return 0;
}

/* 将输入保存到字符数组，返回字符串长度 */
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

/* 处理字符数组，删除行尾空格制表符，返回数组长度 */
int processline(char s[]){
	int c ,i;
	i = 0;
	while(s[i] != '\n' ) /* 计算数组长度 */
		++i;
	--i; /* 回退一格，到'\n'之前的字符 */
	
	while(i >= 0 ){ /* 前移游标i，删除空格等 */
		if( (c = s[i]) == ' '|| c == '\t')
			--i;
		else 
			break;
	}
	
	if(i >=0){  /* 尾部添加换行符和'0'终止符，做成新的字符串 */
			++i;
			s[i] = '#'; /* 由于是否删掉空格看不见，添加#便于测试是否真删掉了空格 */
			++i;
			s[i] = '\n';
			++i;
			s[i] = '\0';
	}
	
	return i;
}

