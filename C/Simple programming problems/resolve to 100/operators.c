#include "lib.h"
int sum(int n1,int n2,bool print){
	if(print && n2!=10) printf("%d + ",n1,n2);
	else if(print) printf("%d + %d",n1,n2);
	return n1+n2;
}

int subtract(int n1,int n2,bool print){
	if(print && n2!=10) printf("%d - ",n1,n2);
	else if(print) printf("%d - %d",n1,n2);
	return n1-n2;
}

int addDigit(int n1,int n2,bool print){
	if(print) printf(" %d%d ",n1,n2);
	return (n1*10)+n2;
}
//TODO this function needs to be changed,it needs to have an array of ints passed to it along with it's size,so that it can print the operation directly without errors
/*void PrintOperation(Operator *OpList){
	int i;
	Operator CurrentFunc;
	printf("\n");
	for (i=1;i<9;i++)
	{
		CurrentFunc=OpList[i-1];
		CurrentFunc(i,i+1,true);
	}
	printf(" =100\n");
}*/


void PrintOperation(int *NumList,int size){
	int i;
	printf("\n");
	printf("%d ",NumList[0]);
	for (i=1;i<size;i++)
	{
		if(NumList[i] >0 )printf("+ %d ",NumList[i]);
		else printf(" %d ",NumList[i]);
	}
	printf(" =100\n");
}

int *MakeOpList(int *OpList,int iteration)
{
	int i;
	//base 3 conversion,which is then converted into a list of operators in the main function
	for(i=0;i<8;i++){
		if(iteration>0)
		{
			OpList[i]=iteration%3;
			iteration=iteration/3;
		}
		else OpList[i]=0;
	}
	
	return OpList;
}

int IterationOptimizer(int iteration){
	//TODO make an optimizer than folows the notes I wrote on the main program
	return iteration;
}