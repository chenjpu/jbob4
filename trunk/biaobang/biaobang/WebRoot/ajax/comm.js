/**
 * 公共方法的JS
 */
 
//去掉左右空格
//function String.prototype.trim(){
//	return this.replace(/(^\s*)|(\s*$)/g,"");
//}
 
//获取操作和操作对象
function send(url){
	if(window.ActiveXObject){//微软浏览器
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHTTPRequest){ //其它浏览器
		xmlHttp=new XMLHTTPRequest();
	}
	xmlHttp.open("get",url,false);
	xmlHttp.onreadystatechange = callback;
	xmlHttp.send(null);
}

//readyState表示XMLHttpRequest对象的处理状态：
//0:XMLHttpRequest对象还没有完成初始化。
//1:XMLHttpRequest对象开始发送请求。
//2:XMLHttpRequest对象的请求发送完成。
//3:XMLHttpRequest对象开始读取服务器的响应。
//4:XMLHttpRequest对象读取服务器响应结束。
function callback(){
	if(xmlHttp.readyState ==4){
		if(xmlHttp.status == 200){
			strText=xmlHttp.responseText;
		}
	}
}
	