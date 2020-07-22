#include <stdio.h>
void swap(int,int);
void swap2(int *,int *);
/**
 * 交换主例程的两个变量的数值
 * 
 * */
int main(int argc, char const *argv[])
{
    int x = 1,y = 2;
    swap(x,y);
    printf("swap : x=%d,y=%d\n",x,y);//输出可见外部的x和y的值并未交换
    swap2(&x,&y);
    printf("swap2 : x=%d,y=%d\n",x,y);
    return 0;
}

// 交换x 和 y的值
//只是交换了副本
void swap(int x,int y){
    int temp;
    temp = x;
    x = y;
    y = temp;
}

//使用指针方式修改主例程的值
void swap2(int *p1,int *p2){
    int temp;
    temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

