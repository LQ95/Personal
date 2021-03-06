#include "intarray.h"

int full(IntArray i)
{
	return (i.size == MAX-1);
}

int empty(IntArray i)
{
	return (i.size == 0);
}

int search(IntArray i,int el)
{
	int index,found;
	index=found=0;
	while(index<i.size && found==0)
		{
			if(i.array[index]==el)
			found=1;;
			index++;
		}
	if (found=1) return index-1;
	else return -1;
}

IntArray init()
{
	IntArray I;
	I.size=0;
	return I;
}

IntArray randomArray(int size)
{
	IntArray i;
	srand(time(NULL));
	int index=0;
	if(size<1)
		size=rand()%12 +3;
	i.size=size;
	while(index<size)
	{
		i.array[index]=rand()%200;
		index++;
	}
	return i;
}

IntArray insert(IntArray i,int el)
{
	if(!full(i))
		{
			i.array[i.size]=el;
			i.size++;
		}
	return i;
}

IntArray elim(int el,IntArray i,int ind)
{
	int index;
	if(ind<0)index=search(i,el);
	else index=ind;
	if(index>-1)
	{
		while(index<i.size)
			{
				i.array[index]=i.array[index+1];
				index++;
			}
		i.size--;
	}
}

IntArray swap(IntArray i,int from,int to)
{
	int tmp;
	if((from<i.size) && (to<i.size) && (from!=to))
	{
		tmp=i.array[to];
		i.array[to]=i.array[from];
		i.array[from]=tmp;
	}
return i;
}

//returns WHERE the minimum is found
//can search a subsystem of the array
int min(IntArray i,int subindex)
{
	int min,found;
	found=subindex;
	min=i.array[subindex];
	while(subindex<i.size)
		{
			if(i.array[subindex]<min)
			{
				min=i.array[subindex];
				found=subindex;
			}
			subindex++;
		}
	return found;
}

void ArrayPrint(IntArray i)
{
	int index=0;
	printf("\n");
	while(index<i.size)
	{
		printf("%d ",i.array[index]);
		index++;
	}
}
