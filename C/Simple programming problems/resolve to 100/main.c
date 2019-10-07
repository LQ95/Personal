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
	int OpList[8];
	Operator CurrentFunc;
	int numbers[9];
	int last=pow(3,9)-1;
	int iteration=0;
	srand(time(NULL));
	int i,sum,size,OpIndex;
	while(iteration<last){
	size=1;
	sum=0;
	MakeOpList(OpList,iteration);
	for (i=1;i<8;i++)  //TODO this cycle needs to use an int array to store previous values in order to correctly compute the sums and to pass it to the printing function
		{
			OpIndex=OpList[size-1];
			CurrentFunc=OpArray[OpIndex];
			//after selecting the operation,we use the last index on the numbers array to make the calculation
			if(size>1) 
				sum+=CurrentFunc(numbers[size-1],i+1,false);
			else 
				sum+=CurrentFunc(i,i+1,false);
			if(i>1) 
				sum-=i;
			//different operations modify the array of operands differently
			if(OpIndex==2)//if addDigit is selected,the result is added to the number array directly
				{
					if(size>1) 
						numbers[size-1]=CurrentFunc(numbers[size-1],i+1,false);
					else 
						numbers[size-1]=CurrentFunc(i,i+1,false);
					i++;
				}
			else if	(OpIndex==1) 
				numbers[size]=-(i+1);
			else if	(OpIndex==0) 
				numbers[size]=i;
			size++;
		}
	if(sum==100) 
		PrintOperation(numbers,size);
	iteration++;
	}
return 0;
}