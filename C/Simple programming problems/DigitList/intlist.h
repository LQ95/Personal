#ifndef lib_int_list
#define lib_int_list
#include <stdio.h>
#include <stdlib.h>
typedef struct Node{
	struct Node *next;
	int info;
} ListNode;
typedef ListNode *IntList;
IntList add(IntList L,int el);
IntList addHead(IntList L,int el);
void Print(IntList L);
#endif