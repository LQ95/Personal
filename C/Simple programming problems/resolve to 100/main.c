/*
Write a program that outputs all possibilities to put + or - or nothing between the numbers 1,2,…,9
 (in this order) such that the result is 100. For example 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100.
*/
/*notes: checking for every possible operation with three operands on every number from 1 to 9 would need 3^9-1 cycles. 
however we can cut that down,excluding every cicle without a Fuse operation in it witch subracts 2^9-1 from the previously mentioned 3^9-1

*/
#include "lib.h"
int main(){
	int OpList[8];
	int numbers[9];
	int last=pow(3,9)-1;
	int iteration=0;
	srand(time(NULL));
	int i,Operator,sum,size,OpIndex;
	while(iteration<last){
	size=1;
	sum=0;
	OpIndex=0;
	MakeOpList(OpList,iteration);
	for (i=1;i<9;i++)  //The array of numbers is first properly transformed,and then the calculation is made
		{
			Operator=OpList[OpIndex];
			OpIndex++;
			//different operations modify the array of operands differently
			if(Operator==2)//if Fuse is selected,the result is added to the number array directly
				{
					if(i>1) 
						numbers[size-1]=Fuse(numbers[size-1],i+1);
					else 
						numbers[size-1]=Fuse(i,i+1);
					size--;
				}
			else if	(Operator==1) 
				{
					if(i>1)
						numbers[size]=-(i+1);
					else 
						{
							numbers[size-1]=i;
							numbers[size]=-(i+1);
						}
				}
			else if	(Operator==0) 
				{
					if(i>1)
						numbers[size]=i+1;
					else
					{
							numbers[size-1]=i;
							numbers[size]=i+1;					
					}
				}
			size++;
		}
		//the calculation is made after the array is transformed
	for (i=0;i<size;i++)
		{
			sum+=numbers[i];
		}
	if(sum==100) 
		PrintOperation(numbers,size);
	iteration++;
	}
return 0;
}