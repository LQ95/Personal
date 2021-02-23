'use strict';

var elenco= new Array(5); //Variable GLOBALE
function test(){
	document.write("IIIIIIIIIIIIII");
}

function arraytest(){
	elenco[0]="TopoGigio";
	elenco[1]=342342;	
	elenco[2]=true;
	elenco[4]=new Object();
	var i;
	for(i=0;i<elenco.length;i=i+1)
	{
		document.write("<br/>" + elenco[i]);
		//la stringa vince nella concatenazione
	}
}
function booleantest(){
	var b=new Boolean(false);
	if(b)
	{
		document.write("<br/> Questo if è vero perchè b risulta essere un oggetto nonnullo nonostante il suo valore sia falso");
	}
	if(b == true)
	{
		document.write("<br/> Questo non è eseguito");
	}
}

function typetest(){
	var x,y;
	x="eeeeee";
	y= new String("Mosconi");
	document.write("x è di tipo "+ typeof(x) +"<br/>");
	document.write("y è di tipo "+ typeof(y));
}

function TrovaESomma(){
	var op1= parseInt(document.testsomma.Op1.value);
	var op2= parseInt(document.testsomma.Op2.value);
	document.testsomma.out.value=op1+op2;
}

function testFor(){
	let result='';
	elenco.monica="tette";
	for (let i in elenco){ //itera su tutti gli indici allocati!
		result += "elenco["+i+"] = " + elenco[i] +"</br>";
	}
	document.write(result + "<br/>E adesso il For...of<br/>");
	
	for(let elem of elenco){
		document.write("<br/>" + elem);
	}
	
}


function sq(num){
	return num*num;
}

function cube(n){
	return n*n*n;
}

function transformArray(func,arr){
	let result = [];
	for(let i in arr)
	{
		result[i]=func(arr[i]);
	}
	return result;	
}

function CustomConc(separator){ //progettata per avere più argomenti oltre al separatore
	var result= '';
	for(let i=1;i<arguments.length;i++)//inizia a ciclare dopo il primo argomento,dato che il primo argomento è un separatore
	{
		result= result + arguments[i] + separator;
	}
	return result;
}

function CommaOpTest(){
	var i,j;
	for(i=0, j=9;i<=j;i++,j--)
	{
		document.write("i = "+i+" j="+j+"<br/>");
	}
}

