#include <stdio.h>
#include <stdlib.h>
typedef struct e{
	struct e *next;
	int node;
	int info;
}edge;
//Edge list operations here

typedef struct g{
	edge **edges;
	int nodes;
}graph;

//Graph operations here