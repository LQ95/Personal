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

int main()
{
	List L=randomList();
	on_all(perfsquare,L);
	return 0;
}