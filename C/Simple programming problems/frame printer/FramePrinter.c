#include "lib.h"
//a function that takes a list of strings an prints them, one per line, in a rectangular frame.
void DrawHorizontalBorder(int size,char border)
{
  for (int j=0;j<size;j++)
		{
			printf("%c",border);
		}
}
void FramePrinter(){
	char border='*';
	int framelength=longest();
	int difference;
	DrawHorizontalBorder(framelength+2,border);
	for (int i=0;i<;i++){
		printf("%c",border);
		difference=framelength-strlen();
		printf("%s",[i]);
		for (int j=0;j<difference;j++){
			printf(" ");
		}
		printf("%c",border);
	}
	DrawHorizontalBorder(framelength+2,border);
	return;
}