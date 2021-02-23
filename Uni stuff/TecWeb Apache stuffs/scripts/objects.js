
	var myEntity= new Object();
	var myVictim = new Object();
	myEntity['name']= "Garfield";
	myEntity.power="Lasagna";
	myVictim ={
		name:"Jon",
		health:100,
		weapon:"shotgun"
	};
	
	function Employee(){
		this.name=name||'';
		this.dept=dept||'general';
	};
	
	function Manager(){
		this.reports = [];
	};
	Manager.prototype = new Employee;
	
	function WorkerBee(){
		this.projects = [];
	};
	
	WorkerBee.prototype=new Employee;
	
		
	function SalesPerson(){
		this.dept="sales";
		this.quota = 100;
	};
	
	SalesPerson.prototype = new WorkerBee;
	
	function Engineer(){
		this.dept="engineering";
		this.machine = "";
	};
	
	Engineer.prototype = new WorkerBee;