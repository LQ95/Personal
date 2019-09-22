#include "lib.h"
int main()
{
	StringList L=NULL;
	L=add(L,"Ciao");
	L=add(L,"Questo");
	L=add(L,"è");
	L=add(L,"un test");
	L=add(L,"della funzione FramePrinter");
	FramePrinter(L);
	exit(0);
}