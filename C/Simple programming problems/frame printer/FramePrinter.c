#include "lib.h"
//a function that takes a list of strings an prints them, one per line, in a rectangular frame.
void DrawHorizontalBorder(int size,char border)
{
  for (int j=0;j<size;j++)
		{
			printf("%c",border);
		}
}
int longest(/*list name*/){
	int max=strlen(/*list name*/[0]);
	for (int i=0;i</*list size*/;i++){
		if(strlen(/*list name*/[i])>max)
			max=strlen(/*list name*/[i]);
	}
}
void FramePrinter(/*list name*/){
	char border='*';
	int framelength=longest(/*list name*/);
	int difference;
	DrawHorizontalBorder(framelength+2,border);//draw horizontal border before ad after
	for (int i=0;i</*list size*/;i++){
		printf("%c",border);
		difference=framelength-strlen();
		printf("%s",/*list name*/[i]);
		for (int j=0;j<difference;j++){
			printf(" ");
		}
		printf("%c",border);
	}
	DrawHorizontalBorder(framelength+2,border);
	return;
}