#include "binsearch.h"
IntArray generateSortedArray(int size){
	IntArray I=init();
	srand(time(NULL));
	I.array[0]=rand()%10;
	I.size++;
	for(int i=1;i<size;i++){
		I.array[i]=I.array[i-1]+rand()%13;
		I.size++;
	}
	return I;
}
//returns the element's index
int BinarySearch(int elem,IntArray arr){
	int start=0;
	int half=indexHalfing(arr.size);
	int end=arr.size-1;
	while(end!=start+1)
	{
		if(arr.array[half]==elem)
			return half;
		else if (arr.array[half]>elem)
			{
				end=half;
				half=indexHalfing(end);
				
			}
		else 
			{
				start=half;
				half=half+(indexHalfing(end-start));
			}
	}
	return -1;
}