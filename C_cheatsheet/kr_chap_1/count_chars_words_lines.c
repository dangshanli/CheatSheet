#include <stdio.h>
/* 统计文本的字符数 、 单词数、 换行符个数 */
/* 单词界定：不包含空格、制表符、换行符的字符序列 */
#define OUT 0 /* 使用字符常量而不是幻数 */
#define IN 1

int main(){
	int c ,nc,nw,nl,state;/* nc:字符数 nw:单词数 nl:行数 */
	nc = nw = nl = 0;
	state = OUT;
	
	while((c = getchar()) != EOF){
		++nc; /* 所有的，包括换行符等都算字符 */
		if(c == '\n')/* 遇到换行符就是一行 */
			++nl;
		
		if(c == ' '||c == '\n'||c == '\t') /* 统计单词在于：OUT-->IN状态的转换，有OUT转IN一次，一个单词 */
			state = OUT;
		else if(state == OUT){
			state = IN;
			++nw;
		}
	}
	
	printf("nc = %d,nl = %d,nw = %d",nc,nl,nw);
}