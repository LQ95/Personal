#include "Sortlib.h"
#include "lib.h"
//Insert your static array structure here if you don't like this one
IntArray SelectionSort(IntArray i)
{
	int index,index2;
	index=0;
	while(index<i.size)
		{
			index2=min(i,index); //the min function returns the index of the smallest element in the[index...end] section of the array
			i=swap(i,index2,index);
			index++;
		}
	return i;
}

IntArray InsertionSort(IntArray i)
{
	int index,tmp,index2;
	index=0;
	while(index<i.size)//starting from the beginning and proceeding towards the end of the array
	{
		tmp=index;
		index2=index-1;
		while(index2>-1 && i.array[index2]>i.array[tmp])//we try to insert the element at [index] to it's place in the array
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
	do{//both indexes move through the array untile one finds an element that is bigger than the pivot,and the other finds one that is smaller
		do{ 
				right--;
			}while(a[right]>pivot);
		
		do{
				left++;
			}while(a[left]<pivot);
			
		if(left<right) //if these elments have been found they are swapped
		{
			tmp=a[left];
			a[left]=a[right];
			a[right]=tmp;
		}
	}while(left<right);//this while exits when the middle index has been reached
	return right;
}
//recursive algorithm
//sorts while partitioning and calls intself on partitions
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

//recursive algorithm,unefficient on purpose
IntArray StoogeSort(IntArray a,int start,int end)
{
	int third=(end-start+1)/3;
	if(a.array[start]>a.array[end])
	{
		a=swap(a,start,end);
	}
	if(end-start>1)
	{
		a=StoogeSort(a,start,end-third);
		a=StoogeSort(a,start+third,end);
		a=StoogeSort(a,start,end-third);
	}
	return a;
}

void Heapify(intArray i,int node)
{
	
}

void MakeHeap(intArray A,int size)
{
 for(int j=size/2;j>0;j--)
		Heapify(i,)
}

void HeapSort(intArray i)
{
	int size=i.size; 
	MakeHeap(i,size);
	for(size=i.size;size>1;size--)
		{
		swap(a,0,size);
		Heapify(i,1,size);
		}
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