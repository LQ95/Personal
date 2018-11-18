#include <stdio.h>
#include <stdlib.h>
#include "ack.h"
int main()
{
	unsigned long long res,x,y;
	count=0;
	printf("please input two numbers for the two argument version of Ackermann's function:\n");
	scanf("%llu",&x);
	while(x>4)
	{
		printf("uh,no.\n");
		fflush(stdin);
		scanf("%llu",&x);
	}
	scanf("%llu",&y);
	res=Ackermann2(x,y);
	printf("result:%llu the function called itself %llu times",res,count);
}

