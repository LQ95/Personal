#include "Sortlib.h"
#include "lib.h"
//Insert your static array structure here if you don't like this one
IntArray SelectionSort(IntArray i)
{
	int index,index2;
	index=0;
	while(index<i.size)
		{
			index2=min(i,index);
			i=swap(i,index2,index);
			index++;
		}
	return i;
}

IntArray InsertionSort(IntArray i)
{
	int index,tmp,index2;
	index=0;
	while(index<i.size)
	{
		tmp=i.array[index];
		index2=index-1;
		while(index2>-1 && i.array[index2]>i.array[index])
			{
			i=swap(i,index,index2);
			index2--;
			}
		index++;
	}
 return i;
}

void MergeSort()
{
	
}

void QuickSort()
{
	
}

void StoogeSort()
{
	
}
void Program()
{
	IntArray i,l;
	i=randomArray(-1);
	ArrayPrint(i);
	i=SelectionSort(i);
	ArrayPrint(i);
	sleep(1);
	l=randomArray(-1);
	ArrayPrint(l);
	l=InsertionSort(l);
	ArrayPrint(l);
}