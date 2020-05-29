#include<stdio.h>

#define OUT 0
#define IN 1
/* 打印文本，以一行一单词的形式输出 */
int main(){
	int c,state;
	
	state = OUT;
	while((c = getchar()) != EOF){
		if(c == ' '||c == '\n'||c == '\t')/* 有个瑕疵就是，首单词就输出了换行，但是只要做个判断该没问题 */
			state = OUT;
		else if(state == OUT){/* 状态转换OUT-->IN,就打印换行符 */
			state = IN;
			putchar('\n');
			putchar(c);
		}else if (state == IN){/* IN 状态持续，则持续输出字符 */
			putchar(c);
		}
	}
	
}

