function Test(var1){
 var myHeading = document.querySelector('h1');
 if(var1==1){
	 myHeading.textContent = 'Lorenzo prova a imparare a fare siti web ';
	 }
     else {myHeading.textContent = 'Svela il titolo!';}
	 }
	
function Display(){
 if (document.getElementById("nascosto").style.display=="none")
   		{
   		document.getElementById("nascosto").style.display="block";
														  }
 else document.getElementById("nascosto").style.display="none";
	 }
function Display2(){
  if(document.getElementById("nascosto2").style.display=="block"){
																document.getElementById("nascosto2").style.display="none";
																}
																else document.getElementById("nascosto2").style.display="block";
																}
function Musica(){
var snd= document.getElementsByClassName("suono");
var.play();


}