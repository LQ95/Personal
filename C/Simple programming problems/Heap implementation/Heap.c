#include "Heaplib.h"
heapStruct Init(int (*Comp)(void *,void *))
{
	heapStruct h;
	h.top=malloc(sizeof(Node));
	h.Comparator=Comp;
	return h;
}
void swap(heap h1,heap h2)
{
	void *tmp;
	tmp=h1->info;
	h1->info=h2->info;
	h2->info=tmp;
}
void heapify(heap h,heap el,int (*Comp)(void *,void *))
{
	heap left,right,largest;
	left=h->left;
	right=h->right;
	if(left!=NULL && Comp(left->info,el->info)>0)
	{
		largest=left;
	}
	else largest=el;
	if(right!=NULL && Comp(right->info,el->info)>0)
	{
		largest=right;
	}
	
	if(largest!=el)
	{
		swap(el,largest);
		heapify(h,largest,Comp);
	}
}
