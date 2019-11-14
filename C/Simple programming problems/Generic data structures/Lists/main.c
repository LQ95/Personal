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
		sprintf(out,"%d",el->info);
		return out;
	};

int main(){
	GenericList L;
	int elem=23,elem2,elem3;
	L=init(&elem,intComparator,intToString);
	elem2=34;
	elem3=elem2+67;
	L=add(L,&elem);
	L=add(L,&elem);
	print(L);
	return 0;
}