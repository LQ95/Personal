#include <stdio.h>
#include <stdlib.h>
typedef struct e{
	struct e *next;
	int node;
}edge;
//Edge list operations here

typedef struct g{
	edge **edges;
	int nodes;
	int *info;
}graph;

//Graph operations here