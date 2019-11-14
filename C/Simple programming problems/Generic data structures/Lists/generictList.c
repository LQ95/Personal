#include "genericList.h"
List create(*void el)
{
	List L;
	L=malloc(sizeof(ListNode));
	L->info=el;
	L->next=NULL;
	return L;
}

List add(List L,*void el)
{
	if(L!=NULL)
	{
		List tmp;
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

List addHead(List L,*void el)
{
	if(L!=NULL)
	{
		List H;
		H=malloc(sizeof(ListNode));
		H->info=el;
		H->next=L;
		return H;
	}
	else return create(el);
}

List search(GenericList L,*void el)
{
	if(L.list!=NULL)
	{
		List tmp=L.list;
			while(tmp->next!=NULL)
			{
				tmp=tmp->next;
				if(L.Comp(tmp->info,el)>0)
					return tmp;
			}
	}
	return NULL;
}
void Print(GenericList L)
{
	List tmp;
	tmp=L.first;
	while(tmp!=NULL)
		{
			L.toString(tmp);
			tmp=tmp->next;
		}
}
