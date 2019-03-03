#include "lib.h"

list CreateList(int el)
{
	list L;
	L=malloc(sizeof(node*));
	L->info=el;
	L->next=NULL;
	return L;
}

//a player is inserted into the list right after connection the the server, so all we know and need is his/her socket descriptor
list insert(int el,list L)
{
	if(L!=NULL)
	{	
		list tmp=L;
		
		while(tmp->next!=NULL )
		{
			tmp=tmp->next;
		}
		tmp->next=CreateList(el);
	}
	else L=CreateList(el);
	return L;
}

list eliminate(int el,list L)
{
	if(L!=NULL)
	{
		if(L->next!=NULL)
		{
			list tmp=L;
			if(L->next->info==el)
				{
					tmp=L->next;
					L->next=tmp->next;
					free(tmp);
					return L;
				}
			else return eliminate(el,L->next);
		}
	}
	return L;
}

int search(int el,list L)
{
	list tmp=L;
	int found=0;
	while(tmp!=NULL &&found==0)
	{
		if(tmp->info ==el) found=1;
		tmp=tmp->next;
	}
	if(found) return tmp->info;
	else return -1;
}

void print(list L)
{
	if(L!=NULL)
	{
		list tmp=L;
		while(tmp!=NULL)
			{
			printf("%d",tmp->info);
			tmp=tmp->next;
			}
	}
}

void freeList(list L)
{
	list tmp=L;
	while(tmp->next!=NULL )
	{
		L=tmp;
		tmp=tmp->next;
		free(L);
	}
	free(tmp);
}