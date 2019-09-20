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
	int half=I.size/2;
	int end=I.size-1;
	while()
	{
		if(arr.array[half]==elem)
			return half;
		else if (arr.array[half]>elem)
			{
				end=half;
				half=end/2;
				
			}
		else 
			{
				start=half;
				half=half+((end-start)/2)
			}
	}
	return -1;
}