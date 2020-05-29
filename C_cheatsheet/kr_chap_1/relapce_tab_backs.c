#include <stdio.h>
/* 将制表符 回退符 反斜杠都替换成可见的形式 \t \b \\  练习1-10*/
/* 实在无法在显示器上敲出回退符的效果 */
int main(){
	int c;
	
	while((c = getchar()) != EOF){
		if(c == '\t'){
			putchar('\\');
			putchar('\\t');
		}
			
		else if(c == '\b'){
			putchar('\\');
			putchar('\\b');
		}
			
		else 
			putchar(c);
	}
}