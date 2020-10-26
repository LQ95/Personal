//Two functions I wrote,that only work when logged into Nonciclopedia(italian Uncyclopedia) and only exectued in the console
//lol

function AbilitaUSERNAME()
{

var spanList = document.getElementsByClassName("insertusername");
if(!spanList.length)
	{
		return;
	}
for(i=0;i<spanList.length;i=i+1)
	{
		spanList[i].textContent=wgUserName;
	}
}

function AbilitaAlert()
{
var spanList = document.getElementsByClassName("alert-load");
if(!spanList.length)
	{
		return;
	}
	for(i=0;i<spanList.length;i=i+1)
	{
		alert(spanList[i].textContent);
	}
}
