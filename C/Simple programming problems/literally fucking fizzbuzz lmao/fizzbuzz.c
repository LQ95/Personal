#include <stdio.h>

int main()
{
	int start,end;
	start=1;
	end=100;
	
	for (int i=start;i<=end;i++){
		if(i%3==0)
			{
				if(i%5==0)
					printf(" FizzBuzz ");
				else printf(" Fizz ");
			}
		else if(i%5==0)
			{
				printf(" Buzz ");
			}
		else printf(" %d ",i);
	}
	return 0;
}