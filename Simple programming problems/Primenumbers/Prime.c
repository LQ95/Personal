#include "lib.h"

void Program()
{
    prime();
}

void prime()
{
	size_t vectorsize;
	int i=0;
	int notprime;
	unsigned long long prime=0;
	unsigned long long *primevector;
	primevector=malloc(sizeof(unsigned long long))
	prime=2;
	primevector[0]=2;
	notprime=0;
	vectorsize=sizeof(unsigned long long);
	printf("%llu\n",prime);
	while(prime<LONG_MAX)
	{
		prime++;
		i=0;
		while(primevector[i]!=NULL && notprime == 0)
			{
			if(prime%primevector[i] == 0)
			notprime=1;
			i++;
			}
		if(notprime==0)
			{
				printf("%llu\n",prime);
				vectorsize= vectorsize + sizeof(unsigned long long);
				realloc(primevector,vectorsize);
				i++;
				primevector[i] =prime;
			}
		else notprime =0;
	}
}