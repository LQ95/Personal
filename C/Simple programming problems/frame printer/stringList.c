#include "stringlist.h"
StringList create(const char *el)
{
	StringList L;
	L=malloc(sizeof(ListNode));
	L->info=malloc(sizeof(char)*strlen(el));
	strcpy(L->info,el);
	L->next=NULL;
	return L;
}

StringList add(StringList L,const char *el)
{
	if(L!=NULL)
	{
		StringList tmp;
		tmp=L;
		while(tmp->next!=NULL)
			{
				tmp=tmp->next;
			}
	
		tmp->next=malloc(sizeof(ListNode));
		tmp->next->info=malloc(sizeof(char)*strlen(el));
		strcpy(tmp->next->info,el);
		tmp->next->next=NULL;
	}
	else L=create(el);
	return L;
}

StringList addHead(StringList L,const char *el)
{
	if(L!=NULL)
	{
		StringList H;
		H=malloc(sizeof(ListNode));
		H->info=malloc(sizeof(char)*strlen(el));
		strcpy(H->info,el);
		H->next=L;
		return H;
	}
	else return create(el);
}

void Print(StringList L)
{
	StringList tmp;
	tmp=L;
	while(tmp!=NULL)
		{
			printf("%s ",tmp->info);
			tmp=tmp->next;
		}
}
