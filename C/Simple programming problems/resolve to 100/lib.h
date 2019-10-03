#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <math.h>
typedef int (*Operator)(int,int,bool);
int sum(int n1,int n2,bool print);
int subtract(int n1,int n2,bool print);
int addDigit(int n1,int n2,bool print);
Operator *MakeOpList(Operator *OpList,int iteration);
int IterationOptimizer(int iteration);
void PrintOperation(Operator *OpList);
//void PrintOperation(int *NumList,int size);