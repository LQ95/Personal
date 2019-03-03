#include <pthread.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <time.h>
#include <sys/types.h>
#include <limits.h>
#include <stdio.h>
#define lock pthread_mutex_lock
#define unlock pthread_mutex_unlock
void *thread_func(void *arg);

typedef struct N
{
	struct N *next;
	int info;
}node;
typedef node *list;
typedef struct S
{
	list l;
	pthread_mutex_t semaforo;
}shared;

list CreateList(int el);
list insert(int el,list L);
list eliminate(int el,list L);
int search(int el,list L);
void print(list L);
void freeList(list L);


void ListManipulation(shared S);