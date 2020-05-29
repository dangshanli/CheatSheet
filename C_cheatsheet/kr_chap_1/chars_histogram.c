#include <stdio.h>
/* 打印输入中各个字符出现频度的直方图 */
/*  不理解频度怎么表示，就按文本中的占比来算了，占比越高线条越长*/

void print_histogram(int);
int main(){
	
int c , nwhite ,nother ;
float nc =nwhite=nother=0.0;//总字符、空白符、其他字符

int  ndigit[10];
for(int i = 0;i<10;i++){
	ndigit[i] = 0;
}

/* 计算数字 、空格('\n' '\t' ' ') 、其他*/
/* 其他本可以更加细分为 字母a、b、c...等，但原理和数字一样，数组装，使用 c-'a'做下标，就不在麻烦了*/
while((c = getchar()) != EOF){
	++nc;
	if(c >= '0' && c <= '9')
		++ndigit[c-'0'];
	else if(c == ' '||c == '\n' || c=='\t')
		++nwhite;
	else
		++nother;
}

	/* 打印直方图,占比为长度，低于1%占比将不再显示*/
	for(int i = 0;i<10;i++){
		printf("%6d ",i);
		ndigit[i] = (ndigit[i]*100.0)/ nc;
		print_histogram(ndigit[i]);
	}
	
	printf("%6s ","space");
	nwhite = (nwhite*100.0)/nc;
	print_histogram(nwhite);
	
	printf("%6s ","other");
	nother = (nother*100.0)/nc;
	print_histogram(nother);
	
}
	

/* 打印直方图使用 IIIIIIIIIIIIIIIII 的样式 */
/* 这是我能想到的最好的样式方案了 */
void print_histogram(int n){
	if(n == 0){
		putchar('\n');
		return;
	}
	
	for(int i = 0;i<n;i++)
		putchar('I');
	putchar('\n');
	
}