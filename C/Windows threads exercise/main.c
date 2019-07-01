#include "lib.h"
//Testing windows GDI,can I make a game out of it?
HANDLE T1,T2;
DWORD ThreadID;
RECT Gamefield;
DWORD WINAPI TestFunction(LPVOID arg)
{
	PAINTSTRUCT ps;
	ThreadData *TD1=arg;
	HDC context=GetDC(TD1->Handle);
	context=BeginPaint(TD1->Handle,&ps);
	GetUpdateRect(TD1->Handle,&Gamefield,FALSE);
	//I'll add something here later on
	EndPaint(TD1->Handle,&ps);
	printf("Thread 1 disegna\n");
}

DWORD WINAPI TestFunction2(LPVOID arg)
{
	printf("Thread 2\n");
}

int main()
{
	HWND MainWindow=GetActiveWindow();
	ThreadData *TD1=malloc(sizeof(ThreadData));
	TD1->Handle=MainWindow;
	T1=CreateThread(NULL,0,(LPTHREAD_START_ROUTINE)TestFunction,TD1,0,&ThreadID);
	T2=CreateThread(NULL,0,(LPTHREAD_START_ROUTINE)TestFunction2,0,0,&ThreadID);
	system("pause");
	return 0;
}