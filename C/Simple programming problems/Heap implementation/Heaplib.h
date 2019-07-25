#include <stdio.h>
#include <stdlib.h>
typedef struct N
{
	struct N *next;
	void *info;
}Node;

typedef Node *heap;

typedef struct H{
	heap top;
	int (*Comparator)(void *,void *);
} heapStruct;

heap heapify(heap h);
heapStruct Init(int (*Comp)(void *,void *));