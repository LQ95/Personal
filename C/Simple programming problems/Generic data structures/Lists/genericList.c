#include "genericList.h"
GenericList init(void *el,int (*Comparator)(void *el1,void *el2),string (*toString)(ListNode *N))
	{
		GenericList g;
		g.first=create(el);
		g.Comparator=Comparator;
		g.toString=toString;
		return g;
	}
List create(void *el)
{
	List L;
	L=malloc(sizeof(ListNode));
	L->info=el;
	L->next=NULL;
	return L;
}

GenericList add(GenericList L,void *el)
{
	if(L.first!=NULL)
	{
		List tmp;
		tmp=L.first;
		while(tmp->next!=NULL)
			{
				tmp=tmp->next;
			}
	
		tmp->next=malloc(sizeof(ListNode));
		tmp->next->info=el;
		tmp->next->next=NULL;
	}
	else L.first=create(el);
	return L;
}

GenericList addHead(GenericList L,void *el)
{
	if(L.first!=NULL)
	{
		List H;
		H=malloc(sizeof(ListNode));
		H->info=el;
		H->next=L.first;
		L.first=H;
		return L;
	}
	else return add(L,el);
}

List search(GenericList L,void *el)
{
	if(L.first!=NULL && L.Comparator!=NULL)
	{
		List tmp=L.first;
			while(tmp->next!=NULL)
			{
				tmp=tmp->next;
				if(L.Comparator(tmp->info,el)==0)
					return tmp;
			}
	}
	return NULL;
}

void print(GenericList L)
{
	if(L.first!=NULL && L.toString!=NULL)
		{
			List tmp;
			tmp=L.first;
			printf("| ");
			while(tmp!=NULL)
				{
					printf("%s | ",L.toString(tmp));
					tmp=tmp->next;
				
				}
		}
}
