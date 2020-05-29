#include <stdio.h>
#define OUT 0
#define IN 1

/* 打印单词长度直方图 */
/* 我的理解是每个长度的单词出现的次数条形图，分为1-25各一个，25以上一个 */
/* 大致找了一篇英文文章测试了一下，基本没看出毛病。以后再说吧 */
void static print_histogram(int);
int main(){
	int c, state , n ,nother;
	state = OUT;
	nother = 0;
	
	
	int lengths[25];
	for(int i = 0;i<25;i++){
		lengths[i] = 0; 
	}
	
	while((c = getchar()) != EOF){  /* 通过运用state状态的转换，识别单词的开始于结束 */
			if(c  == ' '||c == '\n'||c == '\t'){
				if(n>0 && n <=25 &&state == IN)
				++lengths[n-1];
				else if(n>25 && state == IN )
					++nother;
				state = OUT;
			}
			else if(state == OUT){
				n = 0;
				state = IN;
				++n;
			}
			else if(state == IN){
				++n;
			}
		
	}
	
	for(int i= 0;i<25;i++){
		printf("%2d: ",i+1);
		print_histogram(lengths[i]);
	}
	
	printf("25以上:");
	print_histogram(nother);
		
}


/*  打印直方图，全是IIIIII，就酱*/
void static print_histogram(int n){
	if(n == 0){
		putchar('\n');
		return;
	}
	
	for(int i = 0;i<n;i++)
		putchar('I');
	putchar('\n');
	
}