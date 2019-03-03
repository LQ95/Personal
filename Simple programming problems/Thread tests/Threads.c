#include "lib.h"
int main()
{
	list L;
	pthread_t tid1;
	int err;
	L=CreateList(0);
	Shared S;
	S.l=L;
	pthread_mutex_init(&(S.semaforo),NULL);
	err=pthread_create(&tid1,NULL,thread_func,S);
	if(err!=0)
	{
		printf("problema creazione thread:%s",strerror(err));
		exit(1);
	}
	ListManipulation(S);
	pthread_join(tid1,NULL);
	print(L);
	return 0;
}

void *thread_func(void *arg)
{
	list L=(list)arg.l;
	L=insert(4,L);
	L=insert(6,L);
	L=insert(45,L);
	return((void*)0);
}

void ListManipulation(Shared S)
{
	List L=S.l;
	
	printf(" ");
	
}