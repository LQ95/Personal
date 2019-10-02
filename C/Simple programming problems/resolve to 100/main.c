/*
Write a program that outputs all possibilities to put + or - or nothing between the numbers 1,2,…,9
 (in this order) such that the result is 100. For example 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100.
*/
/*notes: checking for every possible operation with three operands on every number from 1 to 9 would need 3^8 cycles. 
however we can cut that down,excluding every cicle without an AddDigit operation in it witch subracts 2^8 from the previously mentioned 3^8

*/
#include "lib.h"
int main(){
	Operator OpArray[3]={sum,subtract,addDigit};
	Operator OpList[8];
	Operator CurrentFunc;
	srand(time(NULL));
	int i;
	int sum=0;
	for (i=1;i<8;i++) 
	{
		CurrentFunc=OpArray[rand()%3];
		sum+=CurrentFunc(i,i+1,false);
		if(i>1) sum-=i;
		OpList[i-1]=CurrentFunc;
		printf("somma:%d",sum);
	}
	if(sum==100) PrintOperation(OpList);
return 0;
}