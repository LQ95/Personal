//Three functions I wrote,that only work when logged into Nonciclopedia(italian Uncyclopedia)

//le funzioni commentate sono state già inserite nel Common.js generale ed effettivamente funzionano
( function(mw, $){
'use strict';
/*function AbilitaUSERNAME()
{

var spanList = document.getElementsByClassName("insertusername");
var i;
var wgUserName=mw.config.get("wgUserName");
if(!spanList.length)
	{
		return;
	}
	for(i=0;i<spanList.length;i=i+1)
	{
		if(wgUserName)
		spanList[i].textContent=wgUserName;
		else spanList[i].textContent="Anonimo non loggato";
	}

}
$(AbilitaUSERNAME);
function AbilitaAlert()
{
var spanList = document.getElementsByClassName("alert-load");
var alertLinkList = document.getElementsByClassName("alert-link");
var i;
if(window.disableNonciAlert)
{
	return;
}
if(spanList.length)
	{
	for(i=0;i<spanList.length;i=i+1)
	{
		alert(spanList[i].textContent);
	}
}
if(!alertLinkList.length)
	{
		return;
	}
	for(i=0;i<alertLinkList.length;i=i+1)
	{
		alertLinkList[i].setAttribute('onclick',"alert(\"" +alertLinkList[i].title+ "\")");
	}
}
$(AbilitaAlert);*/
/*function AbilitaSottotitolo()
{
	var $FakeText=$("#SubTitleText");
	var $Target=$("#siteSub");
	if($FakeText.length && $Target.length)
	{
		$Target.html($FakeText.html());
	}
}
$(AbilitaSottotitolo);*/
//vediamo se riesco a far funzionare di nuovo il template titolo con tutti i parametri
//Usa un misto di JQuery e JS vanilla,JQuery serve per includere l'HTML nel titolo
/*function AbilitaTitolo()
{
	
	var Target;
	var Color;
	var borderBottom;
	var FontFamily;
	//disabilita se chiesto dall'utente
	if( window.disableCheckRealTitleBanner ) {
			return;
		}
	
	//individua il testo generato dal template e il titolo vero
	var $FakeText=$("#TitleText");
	Target=document.getElementById("firstHeading");
	var $TitleHeading=$('h1:first');
	
	//individua i parametri
	if(document.getElementById("TitleColor"))
		{
			Color=document.getElementById("TitleColor").textContent;
		}
	if(document.getElementById("TitleBorderBottom"))
		{
			borderBottom=document.getElementById("TitleBorderBottom").textContent;
		}
	if(document.getElementById("TitleFontFamily"))
		{
			FontFamily=document.getElementById("TitleFontFamily").textContent;
		}
	
	//Applica con parametri
	if( $FakeText.length &&  $TitleHeading.length )
	{
		$TitleHeading.html($FakeText.html());
	}
	if(Color)
		{
			Target.style.color=Color;
		}
	if(FontFamily)
		{
			Target.style.fontFamily=FontFamily;
		}
	if(borderBottom)
		{
			Target.style.borderBottom=borderBottom;
		}
}
$(AbilitaTitolo);*/
function LibroUpdate(libro,num){
	var currPag=document.getElementById(''+libro.id + libro.currPage);
	var newPag;
	libro.currPage+=num;
	newPag=document.getElementById(''+libro.id + libro.currPage);
	if(newPag){
		currPag.style.display="none";
		newPag.style.display="inherit";
	}
	else libro.currPage-=num;
}

function attivaFrecce(libro){
	var frecciaP=document.getElementById(libro.id +"Prev");
	var frecciaN=document.getElementById(libro.id +"Next");
	libro.currPage=1;
	frecciaP.addEventListener('click',function(e){LibroUpdate(libro,-1)});
	frecciaN.addEventListener('click',function(e){LibroUpdate(libro,1);});
}

function AttivaLibro(){
	var bookList=document.getElementsByClassName("libroFlag");
	if(bookList.length){
		for(var i=0;i<bookList.length;i++){
			attivaFrecce(bookList[i]);
		}
	}
}
$(AttivaLibro);

}(mediaWiki, jQuery) );
