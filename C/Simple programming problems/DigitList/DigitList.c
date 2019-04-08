#include "lib.h"
intList Digits()
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
	return list;
}
void Program()
{
	IntList list;
	list=Digits();
	Print(list);
}