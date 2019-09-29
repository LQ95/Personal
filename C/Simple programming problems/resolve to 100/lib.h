#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
typedef int (*Operator)(int,int,bool);
int sum(int n1,int n2,bool print);
int subtract(int n1,int n2,bool print);
int addDigit(int n1,int n2,bool print);
void PrintOperation(Operator *OpList);