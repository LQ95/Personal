#ifndef IntArrH
#define IntArrH
#define MAX 1000 
#include <stdlib.h>
#include <stdio.h>
typedef struct Arr{
	int array[MAX];
	int size;
} IntArray;
IntArray init();
IntArray elim(int el,IntArray i);
IntArray insert(IntArray i,int el);
void swap(IntArray i,int from,int to);
int min(IntArray i,int subindex);
int search(IntArray i,int el);
#endif