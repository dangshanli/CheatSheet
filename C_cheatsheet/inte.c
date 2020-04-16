#include <stdio.h>

int main() {
    //char=1 short=2 int=4 long=4 (long long)=8
    printf("%d < %d < %d < %d < %d",sizeof(char),sizeof(short),sizeof(int),sizeof(long),sizeof(long long));
}