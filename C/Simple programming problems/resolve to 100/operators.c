#include "lib.h"
int sum(int n1,int n2,bool print){
	if(print) printf("%d + %d",n1,n2);
	return n1+n2;
}

int subtract(int n1,int n2,bool print){
	if(print) printf("%d - %d",n1,n2);
	return n1-n2;
}

int addDigit(int n1,int n2,bool print){
	if(print) printf("%d%d",n1,n2);
	return (n1*10)+n2;
}

void PrintOperation(Operator *OpList){
	int i;
	Operator CurrentFunc;
	for (i=1;i<10;i++)
	{
		CurrentFunc=OpList[i];
		CurrentFunc(i,i+1,true);
	}
}