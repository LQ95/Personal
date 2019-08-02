#ifndef SortsH
#define SortsH
#include "intarray.h"
IntArray SelectionSort(IntArray i);
IntArray  InsertionSort(IntArray i);
IntArray MergeSort(IntArray i,int start,int end);
IntArray  QuickSort(IntArray a,int start,int end);
void StoogeSort();
void HeapSort();
#endif