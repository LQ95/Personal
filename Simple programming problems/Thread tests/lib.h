#include <pthread.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <time.h>
#include <sys/types.h>
#include <limits.h>
#include <stdio.h>

*void thread_func(*void arg);
void ListManipulation(list L);

typedef struct N
{
	struct N *next;
	int info;
}node;

typedef node *list;

list CreateList(int el);
list insert(int el,list L);
list eliminate(int el,list L);
int search(int el,list L);
void print(list L);
list free(list L);