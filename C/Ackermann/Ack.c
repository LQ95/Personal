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
	if(x > 0 && y>0 && z==0)
		return x+y;
	else if(y ==0 && z==1 && x>0)
		return 0;
	else if(x >0 && y==0 && z==2)
		return 1;
	else if(x>0 && z>2 && y==0)
		return x;
	else if(x>0 && z>0 && y>0)
	{
		Ackermann(x,Ackermann(x,y-1,z),z);
	}
	else return -1;
}