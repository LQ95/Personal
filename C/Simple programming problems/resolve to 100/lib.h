#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
int Fuse(int n1,int n2);
int *MakeOpList(int *OpList,int iteration);
int IterationOptimizer(int iteration);
void PrintOperation(int *NumList,int size);
void PrintOpList(int iteration);