#include <stdio.h>
#include <stdlib.h> //double atof(s)函数，将字符串转成对应的双精度数值

#define MAXOP 100
#define NUMBER '0'

int getop(char[]);
void push(double);
double pop(void);

main()
{

    int type;      //操作符类型，NUMBER + - * / '\n'等等
    char s[MAXOP]; //数值字符串，声明
    double temp;
    while ((type = getop(s)) != EOF)
    {
        switch (type)
        {
        case NUMBER:
            push(atof(s));
            break;

        case '+':
            push(pop() + pop());
            break;

        case '-':
            temp = pop();
            push(pop() - temp);

            break;

        case '*':
            push(pop() * pop());
            break;

        case '/':
            temp = pop();
            if (temp != 0.0)
            {
                push(pop() / temp);
            }
            else
            {
                printf("error,zero divisor");
            }
            break;

        case '\n': //此时算式结束，进行总结算
            printf("\t%.8g\n", pop());
            break;

        default:
            printf("error,unknow command %s\n", s);
            break;
        }
    }
    return 0;
}