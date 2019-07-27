#include "intList.h"
void on_all(int (*fun)(int),IntList L)
{
	IntList tmp;
	tmp=L;
	while(tmp!=NULL)
	{
		tmp->info=fun(tmp->info);
		tmp=tmp->next;
	}
}

int perfsquare(int num)
{
	return num*num;
}

int main()
{
	IntList L=randomList(11);
	Print(L);
	on_all(perfsquare,L);
	Print(L);
	return 0;
}