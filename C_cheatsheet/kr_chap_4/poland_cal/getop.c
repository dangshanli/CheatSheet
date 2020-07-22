#include <ctype.h>
#define NUMBER '0'
#include <stdio.h>

int getch(void);
void ungetch(int);

/**
 * 0 从输入中读取一个 数值 或者 运算符
 * 1 getch(void)函数是输入的来源
 * 2 我们一般读取的是计算公式，形如：【5 4 + 12 3 * -】，翻译为中指表达式为：(5+4)-12*3
 * 
 * @param s[],如果是数值则用s[]存放
 * @return 当是获取的是字符（或运算符）时，返回该字符；当获取的是数值的时候，返回'0'，数值存在s[]中
 **/
int getop(char s[])
{
    int i , c;
    while ((s[0] = c = getch()) == ' ' || c == '\t')
        ;
    s[1] = '\0';    
    //如果读取的是字符（比如运算符），则返回
    if (!isdigit(c) && c != '.')
    {
        return c;
    }

    i = 0;
    if (isdigit(c)) //获取整数部分
    {
        while (isdigit(s[++i] = c = getch()))
            ;
    }

    if (c == '.')//获取小数部分，如果有的话
    {
        while (isdigit(s[++i] = c = getch()))
            ;
    }

    s[i] = '\0';//字符串结尾
    if (c != EOF) //输入流未结束，则多读入的字符回吐进缓存，留待下一次读取
    {
        ungetch(c);
    }
    return NUMBER;
}