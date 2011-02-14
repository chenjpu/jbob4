function openList(report,value,params){
	if(value!='0'){
		var _kreportParam = document.getElementById("_kreportParam");
		var _kreportParamInnerHtml = _kreportParam.innerHTML;

		var openTarget =  'openList'+ new Date().getTime();

		var queryForm = document.getElementById("_query");

		var paramString = params.split('&');
		for(i=0;i<paramString.length;i++){
			param = paramString[i].split('=');
			if(param.length==2){
				insertHtml('beforeEnd',queryForm,'<input type="hidden" name="'+param[0]+'" value="'+param[1]+'">');
			}
		}
		var action = queryForm.action;
		queryForm.action = queryForm._base.value+report+".kReport?";
		queryForm._method.value="openList";
		queryForm.target = "";
		var w = window.open('about:blank',openTarget,'height=600, width=800,top='+(window.screen.availHeight-630)/2+', left='+(window.screen.availWidth-810)/2+',toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no');
		var wdoc = "<table name='waitimg' id='waitimg' width='100%'  height='100%' ><tr><td align='center' valign='middle'><div><img src='/kReport/image/wait.gif'/></div></td></tr></table>";		
		wdoc+=_kreportParam.innerHTML;
		wdoc+="<"+"script>";
		wdoc+="setTimeout(function(){document.getElementById('_query').submit()},100);"
		wdoc+="</"+"script>";
		w.document.write(wdoc);
		
		_kreportParam.innerHTML=_kreportParamInnerHtml;
		queryForm.target = "";
		queryForm.action = action;
	}
}

function openWindow(url){
	var openTarget = 'open'+ new Date().getTime();
	window.open(url,openTarget,'height=600, width=800,top='+(window.screen.availHeight-630)/2+', left='+(window.screen.availWidth-810)/2+',toolbar=no,scrollbars=yes,resizable=yes,location=no,status=no');
}

function insertHtml(where, el, html){      
     
    where = where.toLowerCase();      
    if(el.insertAdjacentHTML){      
     
        switch(where){      
            case "beforebegin":      
                el.insertAdjacentHTML('BeforeBegin', html);      
                return el.previousSibling;      
            case "afterbegin":      
                el.insertAdjacentHTML('AfterBegin', html);      
                return el.firstChild;      
            case "beforeend":      
                el.insertAdjacentHTML('BeforeEnd', html);      
                return el.lastChild;      
            case "afterend":      
                el.insertAdjacentHTML('AfterEnd', html);      
                return el.nextSibling;      
        }      
        throw 'Illegal insertion point -> "' + where + '"';      
    }      
                    
    var range = el.ownerDocument.createRange();      
    var frag;      
    switch(where){      
         case "beforebegin":      
            range.setStartBefore(el);      
            frag = range.createContextualFragment(html);      
            el.parentNode.insertBefore(frag, el);      
            return el.previousSibling;      
         case "afterbegin":      
            if(el.firstChild){      
                range.setStartBefore(el.firstChild);      
                frag = range.createContextualFragment(html);      
                el.insertBefore(frag, el.firstChild);      
                return el.firstChild;      
             }else{      
                el.innerHTML = html;      
                return el.firstChild;      
             }      
        case "beforeend":      
            if(el.lastChild){      
                range.setStartAfter(el.lastChild);      
                frag = range.createContextualFragment(html);      
                el.appendChild(frag);      
                return el.lastChild;      
            }else{      
                el.innerHTML = html;      
                return el.lastChild;      
            }      
        case "afterend":      
            range.setStartAfter(el);      
            frag = range.createContextualFragment(html);      
            el.parentNode.insertBefore(frag, el.nextSibling);      
            return el.nextSibling;      
    }      
    throw 'Illegal insertion point -> "' + where + '"';      
}     