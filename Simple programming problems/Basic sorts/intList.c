#include "intlist.h"
IntList create(int el)
{
	IntList L;
	L=malloc(sizeof(ListNode));
	L->info=el;
	L->next=NULL;
	return L;
}

IntList add(IntList L,int el)
{
	if(L!=NULL)
	{
		IntList tmp;
		tmp=L;
		while(tmp->next!=NULL)
			{
				tmp=tmp->next;
			}
	
		tmp->next=malloc(sizeof(ListNode));
		tmp->next->info=el;
		tmp->next->next=NULL;
	}
	else L=create(el);
	return L;
}

IntList addHead(IntList L,int el)
{
	if(L!=NULL)
	{
		IntList H;
		H=malloc(sizeof(ListNode));
		H->info=el;
		H->next=L;
		return H;
	}
	else return create(el);
}

void Print(IntList L)
{
	IntList tmp;
	tmp=L;
	while(tmp!=NULL)
		{
			printf("%d ",tmp->info);
			tmp=tmp->next;
		}
}
