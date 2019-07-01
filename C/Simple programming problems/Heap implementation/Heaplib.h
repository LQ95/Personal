typedef struct N
{
	struct N *next;
	int info;
}Node;

typedef *Node heap;

heap heapify(heap h);