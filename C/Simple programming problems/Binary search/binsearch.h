#include "intarray.h"
#define indexHalfing(x) ((x)%2==0 ? ((x)/2) : ((x)/2+1))
IntArray generateSortedArray(int size);
int BinarySearch(int elem,IntArray arr);