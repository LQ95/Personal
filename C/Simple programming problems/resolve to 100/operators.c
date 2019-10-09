#include "lib.h"

int Fuse(int n1,int n2){
	return (n1*10)+n2;
}

void PrintOperation(int *NumList,int size){
	int i;
	printf("\n");
	printf("%d ",NumList[0]);
	for (i=1;i<size;i++)
	{
		if(NumList[i] >0 )printf("+ %d ",NumList[i]);
		else printf("- %d ",-(NumList[i]));
	}
	printf(" = 100\n");
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