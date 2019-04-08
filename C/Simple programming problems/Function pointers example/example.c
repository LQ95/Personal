void on_all(int *(fun)(int),List L)
{
	List tmp;
	tmp=L;
	while(tmp!=NULL)
	{
		tmp=tmp->next;
		tmp->info=fun(tmp->info);
	}
}

int perfsquare(int num)
{
	return num*num;
}