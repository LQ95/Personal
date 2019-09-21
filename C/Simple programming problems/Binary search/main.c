#include <stdio.h>
#include <stdlib.h>
#include "binsearch.h"
int main()
{
	IntArray I1=generateSortedArray(20);
	printf("%d\n",BinarySearch(I1.array[7],I1));
	printf("%d\n",BinarySearch(I1.array[13],I1));
	printf("%d\n",BinarySearch(45,I1));
	printf("%d\n",BinarySearch(21,I1));
	exit(0);
}