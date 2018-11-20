#include "lib.h"
void Digits()
{
	int num,tmp;
	IntList list;
	list=NULL;
	printf("input a random number pls\n");
	scanf("%d",&num);
	tmp=num;
	while(tmp>10)
	{
		list=addHead(list,tmp%10);
		tmp=tmp/10;
	}
	list=addHead(list,tmp);
	Print(list);
}
void Program()
{
	Digits();
}