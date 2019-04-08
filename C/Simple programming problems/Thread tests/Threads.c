#include "lib.h"
int main()
{
	list L;
	pthread_t tid1;
	int err;
	L=CreateList(0);
	shared *S;
	S=malloc(sizeof(shared));
	S->l=L;
	pthread_mutex_init(&(S->semaforo),NULL);
	err=pthread_create(&tid1,NULL,thread_func,S);
	if(err!=0)
	{
		printf("problema creazione thread:%s",strerror(err));
		exit(1);
	}
	ListManipulation(*S);
	pthread_join(tid1,NULL);
	print(L);
	return 0;
}

void *thread_func(void *arg)
{
	shared *S=arg;
	list L=S->l;
	lock(&(S->semaforo));
	L=insert(4,L);
	L=insert(6,L);
	L=insert(45,L);
	unlock(&(S->semaforo));
	return((void*)0);
}

void ListManipulation(shared S)
{
	list L=S.l;
	
	printf(" ");
	
}