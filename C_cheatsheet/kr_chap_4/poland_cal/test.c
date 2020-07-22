#include <stdio.h>
int main(int argc, char const *argv[])
{
    int c=2,m = 1;
    m = c = 3;
    // m = c;
    // c = 3;
    printf("m=%d,c = %d\n",m,c);
    return 0;
}
