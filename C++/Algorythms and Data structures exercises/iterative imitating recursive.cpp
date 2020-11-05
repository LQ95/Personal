#include <stdio.h>
#include <stdlib.h>
#define SIZE 35
#include<bits/stdc++.h>
using namespace std;
//Made from an exam exercise.
int main()
{
	//setup
	srand(time(NULL));
	int array[SIZE];
	int curr_p,curr_r,k,curr_ret,i,curr_q;
	stack<int> StackP,StackR,StackRet,StackQ:
	for(i;i<SIZE;i++)
	{
		array[i]=rand();
	}
	curr_p=rand();
	curr_r=rand();
	k=rand();
	curr_ret=0;
	//actual algorithm
	
	while(!StackP.empty() || !StackR.empty() || !StackRet.empty() ||!StackQ.empty())
	{
		if()
		{//before the first recursive call
			curr_ret=0;
			if(curr_p<=curr_r)
				{	
					curr_q=(curr_p+curr_r)/2;
					if(k==array[curr_q])
						curr_ret=array[curr_q];
					StackRet.push(curr_ret);
					StackQ.push(curr_q);
					StackP.push(curr_p);
					curr_p=curr_q+1;
					printf("prima chiamata : ret:%d p:%d r:%d k:%d q:%d\n",curr_ret,curr_p,curr_r,k,curr_q);
				
		}
		else if(curr_p==StackQ.head()+1)
		{
			printf("rit da prima chiamata : ret:%d p:%d r:%d k:%d q:%d\n",curr_ret,curr_p,curr_r,k,curr_q);
			curr_ret=curr_ret +StackRet.pop(); //returns from first call
			curr_q=StackQ.pop();
			curr_p=StackP.pop();
			if(curr_ret>0)
				{
					StackRet.push(curr_ret);
					curr_r=curr_q-1;
					printf("seconda chiamata : ret:%d p:%d r:%d k:%d q:%d\n",curr_ret,curr_p,curr_r,k,curr_q);
				}
		}
		else{
			curr_ret=curr_ret +StackRet.pop(); //returns from second call
			printf("rit da seconda chiamata : ret:%d p:%d r:%d k:%d q:%d\n",curr_ret,curr_p,curr_r,k,curr_q);
		}
		
	}
	printf("%d",curr_ret);
	return 0;
}