#include "lib.h"

void prime()
{
	int notprime;
	unsigned long long prime=0;
	LongList primevector,tmp;
	primevector=malloc(sizeof(ListNode));
	prime=2;
	primevector->info=2;
	notprime=0;
	printf("%llu\n",prime);
	while(prime<LONG_MAX)
	{
		prime++;
		tmp=primevector;
		while(tmp->next==NULL && notprime == 0)
			{
			if(prime%primevector->info == 0)
			notprime=1;
			tmp=tmp->next;
			}
		if(notprime==0)
			{
				printf("%llu\n",prime);
				add(primevector,prime);
			}
		else notprime =0;
	}
}

void Program()
{
    prime();
}