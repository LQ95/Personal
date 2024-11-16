#include <windows.h>
#include <stdio.h>
#include <gdiplus.h>
using namespace Gdiplus;

void drawTriangle(HDC context) //draws triangle in specific device context
{
Graphics G(context);
Pen 	pen(Color(255,0,255,30));
G.DrawLine(&pen,100,100,200,200);
G.DrawLine(&pen,200,200,200,300);
G.DrawLine(&pen,200,300,100,100);	
}

INT WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance,
    PSTR lpCmdLine, INT nCmdShow)
{
	ULONG_PTR token;  //setup 
	GdiplusStartupInput input;
	GdiplusStartup(&token,&input,NULL);
	HDC deviceContext;
	//setup and register window class
	
	WNDCLASS WindClass;
	WindClass.lpfnWndProc=NULL;
	WindClass.hInstance=hInstance;
	WindClass.lpszClassName=TEXT("Test");
	WindClass.hbrBackground  = (HBRUSH)GetStockObject(WHITE_BRUSH);
	RegisterClass(&WindClass);
	
	//create and show window
	HWND Handle=CreateWindow(
	TEXT("Test"),
	TEXT("Does this work?"),
	WS_OVERLAPPEDWINDOW,
	CW_USEDEFAULT, 
	CW_USEDEFAULT, 
	CW_USEDEFAULT, 
	CW_USEDEFAULT,
	NULL,
	NULL,
	hInstance,
	NULL); 
	PAINTSTRUCT Pstruct;
	
	ShowWindow(Handle, nCmdShow);
	UpdateWindow(Handle);
   
	deviceContext=BeginPaint(Handle,&Pstruct);
	drawTriangle(deviceContext);
	UpdateWindow(Handle);
	getchar();
	GdiplusShutdown(token);
	
}