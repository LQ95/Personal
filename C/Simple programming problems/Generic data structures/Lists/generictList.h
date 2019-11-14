#ifndef lib_int_list
#define lib_int_list
#include <stdio.h>
#include <stdlib.h>
typedef struct Node{
	struct Node *next;
	*void info;
} ListNode;
typedef ListNode *List;
typedef struct GenericL{
	List first;
	int (*Comparator)(*void,*void);
	*char (*toString)(*ListNode);
} GenericList;
GenericList init(*void el,int (*Comprator)(*void,*void),*char (*toString)(ListNode));
List add(List L,*void el);
List addHead(List L,*void el);
List search(List L,*void el);
void Print(GenericList L);
#endif