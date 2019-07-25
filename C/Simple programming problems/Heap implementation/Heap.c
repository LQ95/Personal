#include "Heaplib.h"
heapStruct Init(int (*Comp)(void *,void *))
{
	heapStruct h;
	h.top=malloc(sizeof(Node));
	h.Comparator=Comp;
	return h;
}

heap heapify(heap h)
{
	return h;
}