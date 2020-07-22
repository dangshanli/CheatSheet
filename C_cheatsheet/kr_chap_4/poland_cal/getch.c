#include <stdio.h>
#define BUFSIZE 100
char buf[BUFSIZE]; //缓冲字符数组
int bufp = 0;      //当前缓冲位置

/**
 * 从键盘输出读取一个字符
 * 如果缓冲区已有字符，则从缓冲区获取
 * @return 字符
 * */
int getch(void)
{
    return (bufp > 0) ? buf[--bufp] : getchar();
}

/**
 * 将一个字符写入缓冲区，在缓冲区未满的情况下
 * @param int c,写入缓冲区字符
 * */
void ungetch(int c)
{
    if (bufp >= BUFSIZE)
    {
        printf("字符缓冲区益处！\n");
    }
    else
    {
        buf[bufp++] = c;
    }
}