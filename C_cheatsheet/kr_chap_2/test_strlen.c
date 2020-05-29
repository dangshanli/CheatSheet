# include <stdio.h>

int mystrlen(char[]);
int main(){
	char s[100] = "a love will nerver grow old";
	
	printf("%d\n",mystrlen(s));
}

/* 测试字符串大小 */
int mystrlen(char s[]){
	int i;
	i = 0;
	
	while( s[i] != '\0')
		++i;
	
	return i;
}