#include "lib.h"
int main()
{
	StringList L;
	L=add(L,"ciao");
	L=add(L,"Questo");
	L=add(L,"è");
	L=add(L,"un test");
	L=add(L,"della funzione FramePrinter");
	printf("arriva qui?");
	Print(L);
	printf("arriva qui?2");
	FramePrinter(L);
	exit(0);
}