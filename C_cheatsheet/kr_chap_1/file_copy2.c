#include <stdio.h>
/* 更加紧凑的写法，表达式直接写在循环条件里面 */
int main(){
	int c;
	
	while((c = getchar()) != EOF){  
		putchar(c);
	}
}