# include<stdio.h>
#define MAXLINE 1000
/* 编写reverse翻转一行字符序列 ,main方法做测试*/

int getlines(char[],int);
int reverse(char[]);

int main(){ /* 测试 */
	int c ,len;
	char line[MAXLINE];
	//char new[MAXLINE];
	while((len = getlines(line,MAXLINE)) > 0){
		if(reverse(line) > 0)
			printf("%s",line);
	}
	
	return 0;
}

/* 翻转字符数组方法 */
int reverse(char s[]){
	int i = 0,j = 0;
	char temp[MAXLINE];/* 临时数组 */
	
	while(s[i] != '\n') /* 求数组长度 */
		++i;
	--i;
	
	while(i>=0){ /* 反向赋值 */ 
		temp[j] = s[i];
		--i;
		++j;
	}
		
	if(j >= 0){/* 终结符'\0' */
		temp[j] = '\n';
		++j;
		temp[j] = '\0';
	}
	
	i = 0;
	while(i <= j){ /* 临时数组回赋值 */
		s[i] = temp[i];
		++i;
	}
	
	return j;
}

/* 获取输入，得到最大行并保存，返回行的长度 */
int getlines(char s[],int lim){
	int c,i;
	
	for(i = 0;i<lim-1 && (c = getchar()) != EOF && c != '\n';++i)
		s[i] = c;
	
	if(c == '\n'){
		s[i] = c;
		++i;
	}
	
	s[i] = '\0';
	return i;
}