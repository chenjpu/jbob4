//关联多选项
function _RselectValue(parent,value,text){
	this.parent=parent; //父项值
	this.value=value;	//项值
	this.text=text;		//项显示文本
}

//添加事件
function _rSelectAddEvent(obj,e,func,params){
	var param = "";
	if(params){
		for(var i=0;i<params.length;i++){
			param += ",'"+params[i]+"'";
		}
		if(param.length>1)param=param.substr(1);
	}
	eval("var oldfunc=obj."+e+";");
	if(typeof oldfunc!='function'){
		eval("obj."+e+"=function(){func("+param+");}");
	}else{
		eval("obj."+e+"=function(){	oldfunc();func("+param+");}");
	}
}

//change事件
function _rSelectChange(l1_name,l2_name){	
	var l1=document.getElementsByName(l1_name)[0];
	var l2=document.getElementsByName(l2_name)[0];
	for(i=l2.length-1;i>0;i--){
		l2.options[i]=null;
	}
	if(l1.value!=""){
		var j=0;
		eval("for(i=0;i<"+l2_name+"_rValues.length;i++)if("+l2_name+"_rValues[i].parent==l1.value)l2.options[++j]=new Option("+l2_name+"_rValues[i].text,"+l2_name+"_rValues[i].value);");			
	}
	l2.options[0].selected=true;
	if(typeof l2.onchange=='function'){
		l2.onchange();
	}
}
