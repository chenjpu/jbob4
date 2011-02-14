function doQuery(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="query";
	queryForm.target = "_viewer";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
}

function doCrossQurey(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="crossQurey";
	queryForm.target = "_viewer";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
}

function doReset(){
	window.location.reload();
}

function doExport(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="export";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
}

function doExportTable(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="exportTable";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
}

function doExportCrossTable(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="exportCrossTable";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
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
}

function doExport2(){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="export2";
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
}

function doExportOthers(kreports){
	var queryForm = document.getElementById("_query");
	queryForm._method.value="exportOthers";
	queryForm._parameter.value=kreports;
	queryForm.target = "";
	if(_submitValid(queryForm)){
		queryForm.submit();
	}
}

function _submitValid(){
	return true;
}
