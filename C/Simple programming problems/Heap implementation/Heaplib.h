#include <stdio.h>
#include <stdlib.h>
typedef struct N
{
	struct N *left;
	struct N *right;
	void *info;
}Node;

typedef Node *heap;

typedef struct H{
	heap top;
	int (*Comparator)(void *,void *);
} heapStruct;

void heapify(heap h,heap el,int (*Comp)(void *,void *));
heapStruct Init(int (*Comp)(void *,void *));