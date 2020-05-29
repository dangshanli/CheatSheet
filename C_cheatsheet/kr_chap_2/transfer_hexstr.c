# include<stdio.h>
#define MAXLINE 1000
/* 将字符串16进制字符串 转换成 等价的整形值 */

int htoi(char[]);
int getlines(char[],int);
int main(){  /* 测试 */
	int len , n;
	char line[MAXLINE];
	while((len = getlines(line,MAXLINE)) > 0){
		htoi(line);
	}
	return 0;
	
}

/* 转16进制字符串 */
int htoi(char s[]){
	 int i , c;
	 unsigned long n;
	 
	 if(!(s[0] == '0'&& (s[1] == 'x' || s[1] == 'X'))){
		 printf("pls input corecct hex number\n");
		 return 0;
	 }
	 i = 2;
	 n = 0;
	 while((c = s[i]) != '\n' && c != '\0' ){
		 if(c >= '0' && c <= '9')
			 n = n*16 + (c - '0');
		 else if(c >= 'a' && c <= 'f'){
				n = n*16 + (c - 'a' + 10); 
			 }else{
				 printf("it's not proper hex character");
				 return 0;
			 } 
			 ++i;
	 }
	 printf("hex:%ul\n",n);
	 return n;
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
