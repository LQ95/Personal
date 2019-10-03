/*
Write a program that outputs all possibilities to put + or - or nothing between the numbers 1,2,…,9
 (in this order) such that the result is 100. For example 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100.
*/
/*notes: checking for every possible operation with three operands on every number from 1 to 9 would need 3^9-1 cycles. 
however we can cut that down,excluding every cicle without an AddDigit operation in it witch subracts 2^9-1 from the previously mentioned 3^9-1

*/
#include "lib.h"
int main(){
	Operator OpArray[3]={sum,subtract,addDigit};
	Operator *OpList;
	Operator CurrentFunc;
	int numbers[9];
	int last=pow(3,9)-1;
	int iteration=0;
	srand(time(NULL));
	int i,sum,size,index;
	while(iteration<last){
	size=1;
	sum=0;
	OpList=MakeOpList(OpList,iteration);
	for (i=1;i<8;i++)  //TODO this cycle needs to use an int array to store previous values in order to correctly compute the sums and to pass it to the printing function
	{
		OpIndex=rand()%3;
		CurrentFunc=OpArray[OpIndex];
		/*
		if(OpIndex==2)
			{
				numbers[size]=CurrentFunc(i,i+1,false);
				i++;
			}
		else if	(OpIndex==1)
			numbers[size]=-(i+1)
		else numbers[size]=i;
			*/
		sum+=CurrentFunc(i,i+1,false);
		/*
		if(size>1) sum+=CurrentFunc(numbers[size-1],i+1,false);
		else sum+=CurrentFunc(i,i+1,false);
			*/
		if(i>1) sum-=i;
		OpList[i-1]=CurrentFunc;
		size++;
	}
	if(sum==100) PrintOperation(OpList);
	iteration++;
	}
return 0;
}