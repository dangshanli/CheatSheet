#include <stdio.h>
#define MAXVAL 100 //栈最大容量

int pos = 0;
double val[MAXVAL]; //栈容器
/**
 * 栈操作，推进和弹出
 * */

//向操作数栈推进数值
void push(double f)
{
    if (pos < MAXVAL)
    {
        val[pos++] = f;
    }
    else
    {
        printf("error,full of stack,can't push %g\n",f);
    }
}

//弹出数值
double pop(void)
{
    if (pos>0)
    {
        return val[--pos];
    }else
    {
        printf("error,empty stack\n");
        return 0.0;
    }
}