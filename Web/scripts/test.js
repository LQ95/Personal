//this function gets two functions  and a number passed to it
function animate(timing,draw,duration){
	
	var beginningTimestamp=performance.now();
	requestAnimationFrame(function frame(time)
			{
				var timeFraction=(time - beginningTimestamp)/ duration;
				if (timeFraction>1) timeFraction=1;
			
				var progress=timing(timeFraction);
		
				draw(progress);
		
				if (timeFraction < 1) 
					requestAnimationFrame(frame);
			}
		);
}

function leftBoxDraw(animationCompletionState){
	var box=document.getElementById("flyingbox");
	var extraWidth=document.body.clientWidth- box.clientWidth -17;
	if(animationCompletionState > 0.5)
		animationCompletionState-=(animationCompletionState-0.5)*2;
	finalValue=Math.cos(Math.acos(animationCompletionState))*-1000;
	
	box.style.left=finalValue+ extraWidth +'px';
	box.style.top=finalValue +'px';
}

//this funtion returns the animation completion progress for the time fraction
function leftBoxTiming(timeFraction){
	return 1 - Math.sin(Math.acos(timeFraction));
}

function animazione1(){
animate(leftBoxTiming,leftBoxDraw,3000);
}

//Functions unrelated to animation
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
		animazione1();
														  }
 else document.getElementById("nascosto").style.display="none";
}


function Display2(){
  if(document.getElementById("nascosto2").style.display=="block")
  {
	document.getElementById("nascosto2").style.display="none";
  }
  else document.getElementById("nascosto2").style.display="block";
}		
								
function Musica(){
var snd= document.getElementsByClassName("suono")[0];
snd.play();


}