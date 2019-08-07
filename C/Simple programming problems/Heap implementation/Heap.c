#include "Heaplib.h"
heapStruct Init(int (*Comp)(void *,void *))
{
	heapStruct h;
	h.top=malloc(sizeof(Node));
	h.Comparator=Comp;
	return h;
}

void heapify(heap h,void *el,int (*Comp)(void *,void *))
{
	heap left,right,largest;
	left=h.left;
	right=h.right;
	if(left!=NULL && Comp(left.info,el)>0)
	{
		
	}
	else
	if(left!=NULL && Comp(left.info,h.info)>0)
	{
		
	}
}
