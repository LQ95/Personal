#ifndef lib_list
#define lib_list
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
typedef struct Node{
	struct Node *next;
	unsigned long long info;
} ListNode;
typedef ListNode *LongList;
LongList add(LongList L,unsigned long long el);
#endif