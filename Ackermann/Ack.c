#include "ack.h"
unsigned long long Ackermann2(unsigned long long x,unsigned long long y)
{
	count++;
	if(x == 0)
		return y+1;
	else if(y ==0)
		Ackermann2(x-1,1);
	else 
	{
		Ackermann2(x-1,Ackermann2(x,y-1));
	}
}
unsigned long long Ackermann(unsigned long long x,unsigned long long y,unsigned long long z)
{
	if(x == 0 && y==0)
		return z;
	else if(x ==0 && y>0)
		return (Ackermann(0,y,z) +1);
	else if(x ==1 && y==0)
		return 0;
	else 
	{
		Ackermann(x,Ackermann(x,y-1,z-1),z);
	}
}