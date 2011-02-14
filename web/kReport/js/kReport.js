	function addEvent(obj,e,func){
		eval("var oldfunc=obj."+e+";");
		if(typeof oldfunc!='function'){
			eval("obj."+e+"=func;");
		}else{
			eval("obj."+e+"=function(){	oldfunc();func();}");
		}
	}
	
	function _init(){
		document.getElementById('_viewer').height=document.body.offsetHeight-document.getElementById('_actionTable').offsetHeight-document.getElementById('_conditionTable').offsetHeight-5;
	}
	
	addEvent(window,'onload',_init);
