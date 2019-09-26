#include <stdio.h>
#include <stdlib.h>
typedef int (*Operator)(int,int);
int sum(int n1,int n2);
int subtract(int n1,int n2);
int addDigit(int n1,int n2);