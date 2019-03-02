#include "lib.h"

int main()
{
	list L;
	int *tid1;
	int err;
	L=CreateList(0);
	err=pthread_create(tid1,NULL,thread_func,L);
	if(err!=0)
	{
		printf("problema creazione thread:%s",strerror(err));
		exit(1);
	}
	ListManipulation(L);
	pthread_join(tid1,NULL);
	return 0;
}

*void thread_func(*void arg)
{
	list l=(list)arg;
	return((void*)0)
}

void ListManipulation(list L)
{
	
}