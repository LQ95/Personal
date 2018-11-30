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
		tmp=index;
		index2=index-1;
		while(index2>-1 && i.array[index2]>i.array[tmp])
			{
			i=swap(i,index2,tmp);
			index2--;
			tmp--;
			}
		index++;
	}
 return i;
}
IntArray Merge(IntArray i,int start,int center,int end)
{
	int j=start;
	int z=center;
	while(j<center && z<end)
	{
		if(i.array[j]>i.array[z])
		{
			i=swap(i,j,z)
		}
		i++;
		j++;
	}
	return i;
}
IntArray MergeSort(IntArray i,int start,int end)
{
	i=MergeSort(i,start,end/2);
	i=MergeSort(i,(end/2)+1,end);
	i=Merge(i,start,end/2,end);
	return i;
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