#ifndef lib_int_list
#define lib_int_list
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef char *string;
typedef struct Node{
	struct Node *next;
	void *info;
} ListNode;
typedef ListNode *List;
typedef struct GenericL{
	List first;
	int (*Comparator)(void *el1,void *el2);
	string (*toString)(ListNode *N);
} GenericList;
GenericList init(void *el,int (*Comparator)(void *el1,void *el2),string (*toString)(ListNode *N));
List create(void *el);
List add(List L,void *el);
List addHead(List L,void *el);
List search(GenericList L,void *el);
void Print(GenericList L);
#endif