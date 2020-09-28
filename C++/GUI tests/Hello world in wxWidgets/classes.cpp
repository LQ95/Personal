#include "includes.h"


bool TestApp::OnInit(){
	TestFrame *frame= new TestFrame();
}
enum
{
	ID_Hello=1
};
//calls constructor of base class wxFrame 
TestFrame::TestFrame():wxFrame(NULL, wxID_ANY, "Test"){
	//define menus,a status bar and put them in the bar
	wxMenu file;
	file.Append(ID_Hello,"&Hi  \tCtrl-H","Test help string");
	file.AppendSeparator();
	file.Append(wxID_EXIT);
	
	wxMenu helpMenu;
	helpMenu.Append(wxID_ABOUT);
	
	wxMenuBar bar;
	bar.Append(&file,"&File");
	bar.Append(&helpMenu,"&Help");
	
	SetMenuBar(&bar);
	
	CreateStatusBar();
	SetStatusText("Does this even work?");
	//Connect event handlers to events
	
	Bind(wxEVT_MENU,&TestFrame::OnHello,this,ID_Hello);
	Bind(wxEVT_MENU,&TestFrame::OnAbout,this,wxID_ABOUT);
	Bind(wxEVT_MENU,&TestFrame::OnExit,this,wxID_EXIT);
}

void TestFrame::OnExit(wxCommandEvent& event){
	Close(true);
}

void TestFrame::OnHello(wxCommandEvent& event){
	wxMessageBox("this is something I copied from the wxWidgets website","Trying to get a hang of GUI",wxOK| wxICON_INFORMATION);
	
}

void TestFrame::OnAbout(wxCommandEvent& event){
	wxLogMessage("We are God's Children and he left us in a hot car");
}

