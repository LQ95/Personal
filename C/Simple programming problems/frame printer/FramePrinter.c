#include "lib.h"

void DrawHorizontalBorder(int size,char border)
{
  for (int j=0;j<size;j++)
		{
			printf("%c",border);
		}
   printf("\n");
}

int longest(StringList L){
	int max=strlen(L->info);
	while(L!=NULL){
		if(strlen(L->info)>max)
			max=strlen(L->info);
		L=L->next;
	}
	return max;
}
//a function that takes a list of strings an prints them, one per line, in a rectangular frame.
void FramePrinter(StringList L){
	char border='*';
	int framelength=longest(L);
	int difference;
	printf("\n");
	DrawHorizontalBorder(framelength+4,border);//draw horizontal border before ad after
	while(L!=NULL)
		{
			printf("%c",border);
			difference=framelength-strlen(L->info);
			printf(" %s",L->info);
			for (int j=0;j<difference;j++)
				{
					printf(" ");
				}
			printf(" %c\n",border);
			L=L->next;
		}
	DrawHorizontalBorder(framelength+4,border);
	return;
}