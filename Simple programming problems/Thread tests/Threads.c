#include "lib.h"
int main()
{
	list L;
	pthread_t tid1;
	int err;
	L=CreateList(0);
	err=pthread_create(&tid1,NULL,thread_func,L);
	if(err!=0)
	{
		printf("problema creazione thread:%s",strerror(err));
		exit(1);
	}
	ListManipulation(L);
	pthread_join(tid1,NULL);
	print(L);
	return 0;
}

void *thread_func(void *arg)
{
	list l=(list)arg;
	l=insert(4,l);
	l=insert(6,l);
	l=insert(45,l);
	return((void*)0);
}

void ListManipulation(list L)
{
	while(search(45,L)<0)
	{

	}
	printf("il thread ha fatto il suo dovere");
	
}