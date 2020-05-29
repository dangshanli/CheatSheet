#include <stdio.h>
unsigned long int next = 1;

int main(){
	
}
/* 随机unsigned int数,上限为32768 */
int rand(void){
	next = next * 1103515245 + 12345;
	return (unsigned int)(next/65536) % 32768;
}

/* 修改种子参数，一个种子对应一个随机数，因此也就是伪随机数*/
/* 要做到更高的灵活性可以取更高的 */
void srand(unsigned int seed){
	next = seed;
}

/* 删除s[]中与字符c相同的字符 */
void squeeze(char s[],int c){
	int i,j;
	
	for(i = j = 0;s[0] != '\0';i++)
		if(s[i] != c)
			s[j++] = s[i];
		
	s[j] = '\0';
}

/* 将字符串t接到字符串s的尾部 */
/* ++i 与 i++的辨析：对于赋值而言，++i先+1，在赋值；i++先赋值，再+1； */
void strcat(char s[],char t[]){
	int i,j;
	
	i = j = 0;
	while(s[i] != '\0')
		++i;
	
	while((s[i++] = t[j++]) != '\0') /* 在条件语句中就赋值，更简洁的写法 */
		;
}


/* 返回二进制形式的整数x 向右数第p位开始，向右的n位 */
unsigned getbits(unsigned x,int p,int n){
	return (x>>(p-n+1))& ~(~0<<n);
}



