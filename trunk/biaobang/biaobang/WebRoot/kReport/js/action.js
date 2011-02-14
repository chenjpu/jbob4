function doQuery(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="query";
	queryForm.target = "_viewer";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
	//return false;
}

function doCrossQuery(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="crossQuery";
	queryForm.target = "_viewer";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
	//return false;
}

function doReset(){
	window.location.reload();
	return false;
}

function doExport(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="export";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
	return false;
}

function doExportOther(other){
	var queryForm = document.getElementById("_query");
	var action = queryForm.action;
	queryForm.action = queryForm._base.value+other+".kReport";
	queryForm._method.value="export";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
	queryForm.action = action;
	return false;
}

function doExportTable(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="exportTable";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
	return false;
}

function doExportCrossTable(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="exportCrossTable";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
	return false;
}

function doExport2(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="export2";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
	return false;
}

function doExportOthers(kreports){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="exportOthers";
	queryForm._parameter.value=kreports;
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
	return false;
}

function _submitValid(){
	return true;
}

function doDataMethod(what){
	eval("_viewer.window."+what);
	return false;
}

