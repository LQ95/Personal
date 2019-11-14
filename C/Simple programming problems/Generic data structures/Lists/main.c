#include "genericList.h"
int intComparator(void *arg1,void *arg2){
	int *num1,*num2;
	num1=arg1;
	num2=arg2;
	return *num1-*num2;
	};

char *intToString(ListNode *el)
	{
		char *out=malloc(64);
		sprintf(out,"%d",*((int*)el->info) );
		return out;
	};

int main(){
	GenericList L;
	int elem=23,elem2,elem3;
	L=init(&elem,intComparator,intToString);
	elem2=34;
	elem3=elem2+67;
	L=add(L,&elem2);
	L=add(L,&elem3);
	print(L);
	printf("%s",L.toString(search(L,&elem2)));
	return 0;
}