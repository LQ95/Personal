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
	
	return 0;
}