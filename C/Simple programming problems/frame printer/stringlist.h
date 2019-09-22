#ifndef lib_string_list
#define lib_string_list
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct Node{
	struct Node *next;
	char *info;
} ListNode;
typedef ListNode *StringList;
StringList add(StringList L,const char *el);
StringList addHead(StringList L,const char *el);
void Print(StringList L);
#endif