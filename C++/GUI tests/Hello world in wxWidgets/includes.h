#include <wx/wxprec.h>
#include <wx/app.h>
#ifndef WX_PRECOMP
	#include <wx/wx.h>
#endif
//class definitions here
class TestApp :public wxApp{
	
public:
	virtual bool OnInit();
};

class TestFrame : public wxFrame{
	
public:
	TestFrame();
	
private:
	void OnHello(wxCommandEvent& event);
	void OnExit(wxCommandEvent& event);
	void OnAbout(wxCommandEvent& event);
};
