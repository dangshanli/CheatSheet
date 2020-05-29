#include <stdio.h>
/* 判定年份的润 平 */

void judge_year(int);
int main(){/*测试 */
	judge_year(2008);
	
	judge_year(3000);
}

/* 判定方法 */
void judge_year(int year){
	
	if( (year %4 == 0 &&  year%100 != 0) || year % 400 == 0){
		printf("%d 年是闰年\n",year);
	}else
		printf("%d 年是平年\n",year);
}