#ifndef IntArrH
#define IntArrH
#define MAX 1000 
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
typedef struct Arr{
	int array[MAX];
	int size;
} IntArray;
IntArray init();
IntArray randomArray(int size);
IntArray elim(int el,IntArray i,int ind);
IntArray insert(IntArray i,int el);
IntArray swap(IntArray i,int from,int to);
int min(IntArray i,int subindex);
int search(IntArray i,int el);
void ArrayPrint(IntArray i);
#endif