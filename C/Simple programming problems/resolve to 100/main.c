/*
Write a program that outputs all possibilities to put + or - or nothing between the numbers 1,2,…,9
 (in this order) such that the result is 100. For example 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100.
*/
#include "lib.h"
int main(){
	Operator OpArray[3]={sum,subtract,addDigit};
	Operator OpList[10];
	Operator CurrentFunc;
	srand(time(NULL));
	int i;
	int sum=0;
	for (i=0;i<8;i++) 
	{
		CurrentFunc=OpArray[rand()%3];
		sum+=CurrentFunc(i,i+1,false);
		printf("somma:%d",sum);
	}
	if(sum==100) PrintOperation(OpList);
return 0;
}