#include <stdio.h>
#define MAXLINE 1000

int getaline(char line[], int max);
int strindex(char source[], char searchfor[]);
int strindex_last(char source[], char searchfor[]);
char pattern[] = "ould";

int main()
{
    char source[MAXLINE];
    int found = 0;
    int index;

    while (getaline(source, MAXLINE) > 0)
    {
        if ((index = strindex_last(source, pattern)) >= 0)
        {
            printf("++++++++++++index = %d,%s ",index,source);
            found++;
        }
    }
    return found;
}

/*从标准输入流读取最多lim个字符进入s数组中 */
int getaline(char s[], int lim)
{   int c;
    int i = 0;
    //读取数超过了lim ，读到了文本末尾 ，读到了换行符
    while (--lim > 0 && (c = getchar()) != EOF && c != '\n')
    {
        s[i++] = c;
    }
    if (c == '\n')
    {
        s[i++] = '\n';
    }
    s[i] = '\0';
    return i;
}

/* 返回字符串t出现在s中的位置，不存在则返回-1*/
int strindex(char s[], char t[])
{
    int i,j,k;
    for (i = 0; s[i] != '\0'; i++)
    {
        for ( j = i,k = 0; t[k] != '\0' && t[k] == s[j]; j++,k++)
            ;
        if (k > 0 && t[k] == '\0')
            return i;
    }
    return -1;
}

/* 最后一个满足的index */
int strindex_last(char s[], char t[])
{
    int i,j,k,index = -1;
    for (i = 0; s[i] != '\0'; i++)
    {
        for ( j = i,k = 0; t[k] != '\0' && t[k] == s[j]; j++,k++)
            ;
        if (k > 0 && t[k] == '\0')
            index = i;
    }
    return index;
}