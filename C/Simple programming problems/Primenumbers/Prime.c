#include "lib.h"

void prime()
{
	int notprime;
	unsigned long long prime=0;
	LongList primevector,tmp;
	primevector=malloc(sizeof(ListNode));
	prime=2;
	primevector->info=2;
	primevector->next=NULL;
	notprime=0;
	printf("%llu\n",prime);
	while(prime<UINT_MAX)
	{
		prime++;
		tmp=primevector;
		while(tmp!=NULL && notprime == 0 &&((tmp->info)<(prime/2+1)))
			{
			if(prime%tmp->info == 0)
			notprime=1;
			tmp=tmp->next;
			}
		if(notprime==0)
			{
				printf("%llu\n",prime);
				primevector=add(primevector,prime);
			}
		else notprime =0;
	}
}

void Program()
{
    prime();
}