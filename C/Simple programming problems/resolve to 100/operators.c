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
void PrintOperation(Operator *OpList){
	int i;
	Operator CurrentFunc;
	printf("\n");
	for (i=1;i<9;i++)
	{
		CurrentFunc=OpList[i-1];
		CurrentFunc(i,i+1,true);
	}
	printf(" =100\n");
}

Operator *MakeOpList(Operator *OpList,int iteration)
{
	if(OpList==NULL)
		OpList=malloc(sizeof(Operator)*8);
	int base3vector[8];
	int i;
	//base 3 conversion,which is then converted into a list of operators
	for(i=0;i<8;i++){
		if(iteration>0)
		{
			base3vector[i]=iteration%3;
			iteration=iteration/3;
		}
		else base3vector[i]=0;
	}
	
	for(i=0;i<8;i++){
		if(base3vector[i]==0)
			OpList[i]=sum;
		else if (base3vector[i]==1)
			OpList[i]=subtract;
		else OpList[i]=addDigit;
	}
	return OpList;
}

int IterationOptimizer(int iteration){
	//TODO make an optimizer than folows the notes I wrote on the main program
	return iteration;
}