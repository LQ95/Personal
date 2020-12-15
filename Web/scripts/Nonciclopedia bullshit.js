//Three functions I wrote,that only work when logged into Nonciclopedia(italian Uncyclopedia)

( function(mw, $){
'use strict';
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
$(AbilitaUSERNAME);
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
$(AbilitaAlert);
function AbilitaSottotitolo()
{
	var FakeText;
	var Target;
	FakeText=document.getElementById("SubTitleText").textContent;
	Target=document.getElementById("siteSub");
	Target.textContent=FakeText;
}
$(AbilitaSottotitolo);
}(mediaWiki, jQuery) );
