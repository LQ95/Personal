#include "longlist.h"
LongList add(LongList L,unsigned long long el)
{
	LongList tmp;
	tmp=L;
	while(tmp->next!=NULL)
		{
			tmp=tmp->next;
		}
	
	tmp->next=malloc(sizeof(ListNode));
	tmp->next->info=el;
	tmp->next->next=NULL;
	return L;
}