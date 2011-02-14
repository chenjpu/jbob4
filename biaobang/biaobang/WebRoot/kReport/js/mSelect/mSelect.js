	function _mselect_doSelect(mname){
		var selectDiv = document.getElementById("_mselect_div_"+mname);
		if(selectDiv.className=="mselect_showDiv"){
			_mselect_hideSelect(mname);
		}else{
			_mselect_showSelect(mname);
		}
	}
	function _mselect_showSelect(mname){
		var selectDiv = document.getElementById("_mselect_div_"+mname);
		var t = document.getElementById("_mselect_text_"+mname);
		selectDiv.className="mselect_showDiv";
		var theight=t.style.height;
		var height=selectDiv.offsetHeight;
		var sheight=window.screen.availHeight-30;
		if(theight==0)theight=24;
		var ttop=_mselect_getTop(t);
		var tleft=_mselect_getLeft(t);
		selectDiv.style.left=tleft
		if(sheight-ttop-theight-height>0){
			selectDiv.style.top=ttop+theight;
		}else{
			selectDiv.style.top=ttop-height;
		}
		if(selectDiv.style.width==0){
			selectDiv.style.width=selectDiv.offsetWidth;
			if(selectDiv.offsetWidth<t.offsetWidth){
				selectDiv.style.width=t.offsetWidth;
			}
		}
	}
	function _mselect_hideSelect(mname){
		var selectDiv = document.getElementById('_mselect_div_'+mname);
		selectDiv.className="mselect_hideDiv";
		var selects = document.getElementsByName(mname);
		var showtext = "";
		for(i=0;i<selects.length;i++){
			if(selects[i].checked){
				showtext+=","+selects[i].parentNode.parentNode.cells[1].innerHTML
			}
		}
		if(showtext.length>1)showtext=showtext.substr(1);
		document.getElementById('_mselect_text_'+mname).value=showtext;
	}
	function _mselect_getTop(e){
		var offset=e.offsetTop;
		if(e.offsetParent!=null) offset+=_mselect_getTop(e.offsetParent);
		return offset;
	}
	function _mselect_getLeft(e){
		var offset=e.offsetLeft;
		if(e.offsetParent!=null) offset+=_mselect_getLeft(e.offsetParent);
		return offset;
	}