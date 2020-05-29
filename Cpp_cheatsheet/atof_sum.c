#include <ctype.h>
#include <stdio.h>

double atof(char s[]);

int main() {
    char s[] = "111.2";
    printf("atof(123.155) = %d",atof(s));
}

double atof(char s[]){
    char a[] = "111.2";
    if (a[3] == '.')
    {
        printf("2333333333");
    }

    if (s[3] == '.')
    {
        printf("2555555555555");
    }
    double val,power;
    int i ,sign;
    for ( i = 0;isspace(s[i]); i++)
    {
        ;
    }
    sign = (s[i] == '-')? -1 : 1;
    if (s[i] == '+' || s[i] == '-')
    {
        i++;
    }
    printf("sign=%d,i=%d\n",sign,i);
    for ( val = 0.0; isdigit(s[i]); i++)
    {  
        val = val * 10.0 + (s[i]-'0');
         printf("s[%d] = %d,i=%d,val=%d\n",i,(s[i]-'0'),i,val);

    }
    printf("s[%d] = %c,i=%d\n",i,(s[i]),i);
    if (((char)s[i]) == '.')
    {
        printf("%c",s[i]);
        i++;    
    }
    printf("val=%d,i=%d\n",val,i);

    for (power = 1.0; isdigit(s[i]); i++)
    {
        val = 10.0 * val + (s[i] - '0');
        power *= 10;
    }
    return sign * val / power;
}

