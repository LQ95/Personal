#include <windows.h>
#include <stdio.h>
#include <stdlib.h>
HANDLE T1,T2;
DWORD ThreadID;

DWORD WINAPI TestFunction(LPVOID arg)
{
	printf("Thread 1\n");
}

DWORD WINAPI TestFunction2(LPVOID arg)
{
	printf("Thread 2\n");
}

int main()
{
	T1=CreateThread(NULL,0,(LPTHREAD_START_ROUTINE)TestFunction,0,0,&ThreadID);
	T2=CreateThread(NULL,0,(LPTHREAD_START_ROUTINE)TestFunction2,0,0,&ThreadID);
	system("pause");
	return 0;
}