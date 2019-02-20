#include <stdlib.h>
#include <stdio.h>
#include <math.h>
int main()
{
	int test= 4901;
	int bit;
	int *vec;
	int i,size;
	size=ceil(log2(test));
	printf("in binario questo numero occupa:%d e dovrebbe essere uguale a :",size);
	vec=malloc(size*sizeof(int));
	for(i=size;i>-1;i--)
	{
		bit=1<<i;
		//select every bit as the cycle goes on
		bit=bit&test;
		if(bit) bit=1;
		vec[i]=bit;
		printf("%d",bit);
	}
	return 0;
}