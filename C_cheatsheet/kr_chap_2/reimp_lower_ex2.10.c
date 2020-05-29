#include <stdio.h>
# define MAXLINE 1000

void transfer_str(char[]);
int lower_reimp(int);
int getlines(char[],int);

int main(){//测试，转小写函数
int len;
char line[MAXLINE];

while((len = getlines(line,MAXLINE)) > 0 ){
		transfer_str(line);
		printf("%s",line);
}

return 0;
}

void transfer_str(char s[]){
	int i;
	while(s[i] != '\0'){
		s[i] = lower_reimp(s[i]);
		++i;
	}
}

/* 比较a，b大小*/
int max(int a, int b){
	return (a>b) ? a : b;
}

/*打印数组*/
void print_arr(int a[],int n){
	int i;

	for(i = 0;i< n;i++)
		printf("%6d%c",a[i],(i%9 == 0 || i == n-1) ? '\n' : ' ');
}

/* 大写转小写,使用c条件表达式去打if-else 语句，重新实现 */
int lower_reimp(int c){
	return (c >= 'A' && c <= 'Z') ? (c + 'a' - 'A') : c;
}

/* 获取输入，得到最大行并保存，返回行的长度 */
int getlines(char s[],int lim){
	int c,i;
	
	for(i = 0; (i <(lim - 1) && c = getchar()) != EOF && c != '\n';++i)
			s[i] = c;

	if(c == '\n'){
		s[i] = c;
		++i;
	}
	
	s[i] = '\0';
	return i;
}