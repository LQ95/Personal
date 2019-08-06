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

//Mergesort
IntArray Merge(IntArray i,int start,int center,int end)
{
	int j=start;
	int z=center+1;
	int index=0;
	int index2;
    IntArray temp;
	temp=init();
	temp.size=(end-start);
	while(j<=center && z<=end)//while neither of the arrays are finished,sort
	{
		if(i.array[j]<=i.array[z])
		{
			temp.array[index]=i.array[j];
			j++;
		}
		else{
			temp.array[index]=i.array[z];
			z++;
			
			}
		index++;
	}
	//copy the elements in the longer array
	while(j<=center)
		{
			temp.array[index]=i.array[j];
			j++;
			index++;
		}
	while(z<=end)
		{
			temp.array[index]=i.array[z];
			z++;
			index++;		
		}
	for(index2=0;index2<index;index2++)
		{
			i.array[start+index2]=temp.array[index2];
		}
	return i;
}

IntArray MergeSort(IntArray i,int start,int end)
{
	if(start<end)
	{
	i=MergeSort(i,start,(start+end)/2);
	i=MergeSort(i,((start+end)/2)+1,end);
	i=Merge(i,start,(start+end)/2,end);
	}
	return i;
}
//Quicksort
int Partition(int *a,int start,int end)
{
	int pivot=a[start]; //assign pivot
	int left= start-1;
	int right= end+1;
	int tmp;
	do{
		do{
				right--;
			}while(a[right]>pivot);
		
		do{
				left++;
			}while(a[left]<pivot);
			
		if(left<right)
		{
			tmp=a[left];
			a[left]=a[right];
			a[right]=tmp;
		}
	}while(left<right);//this while exits when the middle index has been reached
	return right;
}

IntArray QuickSort(IntArray a,int start,int end)
{
	int middle;
	if(start<end){
	middle=Partition(a.array,start,end); //apparently it likes this direct pointer to the array better.
	a=QuickSort(a,start,middle);
	a=QuickSort(a,middle+1,end);
	}
	return a;
}


IntArray StoogeSort(IntArray a,int start,int end)
{
	int third=(end-start+1)/3;
	if(a.array[start]>a.array[end])
	{
		a=swap(a,start,end);
	}
	if(end-start>1)
	{
		StoogeSort(a,start,end-third);
		StoogeSort(a,start+third,end);
		StoogeSort(a,start,end-third);
	}
	return a;
}

void HeapSort()
{
	
}
void Program()
{
	IntArray i,l;
	i=randomArray(-1);
	printf("\nSelection Sort:\n");
	ArrayPrint(i);
	i=SelectionSort(i);
	ArrayPrint(i);
	sleep(1);
	l=randomArray(-1);
	printf("\n\nInsertion Sort:\n");
	ArrayPrint(l);
	l=InsertionSort(l);
	ArrayPrint(l);
	sleep(1);
	l=randomArray(-1);
	printf("\n\nMerge Sort:\n");
	ArrayPrint(l);
	l=MergeSort(l,0,l.size-1);
	ArrayPrint(l);
	sleep(1);
	l=randomArray(-1);
	printf("\n\nQuick Sort:\n");
	ArrayPrint(l);
	l=QuickSort(l,0,l.size-1);
	ArrayPrint(l);
	l=randomArray(-1);
	printf("\n\nStooge Sort:\n");
	ArrayPrint(l);
	l=StoogeSort(l,0,l.size-1);
	ArrayPrint(l);
}