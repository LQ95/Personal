#include <stdio.h>
#include <stdlib.h>
#define SIZE 100
#include<bits/stdc++.h>
using namespace std;
void emptyPrint(stack<int> S)
{
    if(S.empty())
        {
            printf("empty stack\n");
        }
    else printf("not yet\n");
    return;
}
//Made from an exam exercise.
int main()
{
	//setup
	srand(time(NULL));
	int array[SIZE];
	int curr_p,curr_r,k,curr_ret,i,curr_q,p,r;
	stack <int> StackP,StackRet,StackQ;

	for(i;i<SIZE;i++)
	{
		array[i]=rand()%SIZE;
	}
	p=rand()%SIZE-20;
	curr_p=p;
	r=rand()%SIZE;
    curr_r=r;
	k=rand()%SIZE;
	curr_ret=0;
	//actual algorithm

	while(!StackP.empty() || !StackRet.empty() ||!StackQ.empty()||(curr_p==p&&curr_r==r))
	{
        //before the first recursive call
        if(curr_p<=curr_r){
				{
				    curr_ret=0;
				    printf("p:%d r:%d\n",curr_p,curr_r);
					curr_q=(curr_p+curr_r)/2;
					if(k==array[curr_q])
						curr_ret=array[curr_q];
					StackRet.push(curr_ret);
					StackQ.push(curr_q);
					StackP.push(curr_p);
					curr_p=curr_q+1;
					printf("prima chiamata : ret:%d p:%d r:%d k:%d q:%d\n",curr_ret,curr_p,curr_r,k,curr_q);
				}
        }
		else if(curr_p==StackQ.top()+1)
		{
			printf("rit da prima chiamata : ret:%d p:%d r:%d k:%d q:%d\n",curr_ret,curr_p,curr_r,k,curr_q);
			curr_ret=curr_ret + StackRet.top(); //returns from first call
			StackRet.pop();
			curr_q=StackQ.top();
			StackQ.pop();
			curr_p=StackP.top();
			StackP.pop();
			if(curr_ret>0)
				{
					StackRet.push(curr_ret);
					curr_r=curr_q-1;
					printf("seconda chiamata : ret:%d p:%d r:%d k:%d q:%d\n",curr_ret,curr_p,curr_r,k,curr_q);
				}
		}
		else if(curr_r==StackQ.top()-1){
			curr_ret=curr_ret +StackRet.top(); //returns from second call
			StackRet.pop();
			printf("rit da seconda chiamata : ret:%d p:%d r:%d k:%d q:%d\n",curr_ret,curr_p,curr_r,k,curr_q);
		}
    printf("ciclo ricomincia \n");
    emptyPrint(StackP);
    emptyPrint(StackQ);
    emptyPrint(StackRet);
	}
	printf("%d",curr_ret);
	return 0;
}
