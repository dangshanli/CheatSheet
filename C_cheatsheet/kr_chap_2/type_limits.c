#include <stdio.h>
#include <limits.h>

/*  signed  unsigned :char short int long    min--max*/

void print_limits(void);
int main(){
	print_limits();
}

/* 打印预定义宏，显示最值 */
void print_limits(){
	/*signed char short int long*/
	printf("char_max:%d\tchar_min:%d\n",CHAR_MAX,CHAR_MIN);
	printf("short_max:%d\tshort_min:%d\n",SHRT_MAX,SHRT_MIN);
	printf("int_max:%d\tint_min:%d\n",INT_MAX,INT_MIN);	
	printf("long_max:%ld\tlong_min:%ld\n\n",LONG_MAX,LONG_MIN);
	
	/* unsigned char short int long */
	
	printf("uchar:%d\n",UCHAR_MAX);
	printf("uint:%ld\n",UINT_MAX);
	printf("ulong:%lu\n",ULONG_MAX);
	printf("ushort:%d\n",USHRT_MAX);
}

/* 计算方式显示大小 */
void  cal_limits(){
	/* signed   types*/
	//printf("signed char min = %d\n",);
	
}