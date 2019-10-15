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
//this function moves a box into a point and then makes it bounce back to its origin
function leftBoxDraw(animationCompletionState){
	var box=document.getElementById("flyingbox");
	var speed=1000;
	var extraWidth=document.body.clientWidth- box.clientWidth -17;
	if(animationCompletionState > 0.5)
		animationCompletionState-=(animationCompletionState-0.5)*2;
	finalValue=Math.cos(Math.acos(animationCompletionState))*-speed;
	
	box.style.left=finalValue+ extraWidth +'px';
	box.style.top=finalValue +'px';
}

//this function returns the animation completion progress for the time fraction
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
	document.getElementById("jumpingbox").style.animationPlayState="running";
	document.getElementById("jumpingbox").style.animationIterationCount="infinite";
	setTimeout(function(){
		document.getElementById("jumpingbox").style.animationPlayState="paused";
		document.getElementById("jumpingbox").style.animationIterationCount="1";
	},1000)
  }
  else document.getElementById("nascosto2").style.display="block";
}		
								
function Musica(){
var snd= document.getElementsByClassName("suono");
var selected= Math.floor(Math.random()* 3);
snd[selected].play();


}