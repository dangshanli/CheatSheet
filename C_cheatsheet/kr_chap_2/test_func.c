#include <stdio.h>

int main(){
	
}

int atoi(char s[]){/* 将字符数组转换成整形数字 */
	int i, n;
	
	n = 0;
	for(i = 0; s[i] >= '0' && s[i] <= '9';++i)
		n = n*10 +s[i] - '0';
	
	return n;
}

int lower(int c){/* 将大写字符转换成小写 ,适用于ASCII字符集，不适用于EBCDIC字符集*/
	if( c >='A' && c <= 'Z')
		return c + 'a' - 'A';
	else
		return c;
}

