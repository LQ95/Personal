#include <stdio.h>
#include <stdlib.h>
#include "ack.h"
int main()
{
	FILE *oldout,*new;
	oldout=stdout;
	unsigned long long res,x,y;
	count=0;
	printf("please input two numbers for the two argument version of Ackermann's function:\n");
	scanf("%llu",&x);
	while(x>3)
	{
		printf("uh,no.");
		fflush(stdin);
		scanf("%llu",&x);
	}
	scanf("%llu",&y);
	res=Ackermann2(x,y);
	printf("result:%llu the function called itself %llu times",res,count);
	count=0;
	res=Ackermann(1,1,2);
	printf("\ntest result for three arg version:%llu the function called itself %llu times",res,count);
}

