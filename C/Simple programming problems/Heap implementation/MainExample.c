#include "Heaplib.h"
int IntComparator(void *arg1,void *arg2){
	int *num1,*num2;
	num1=arg1;
	num2=arg2;
	return num1[0]-num2[0];
}

int main()
{
	heapStruct H1=Init(IntComparator);
	
	return 0;
}