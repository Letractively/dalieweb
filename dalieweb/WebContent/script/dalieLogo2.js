// dalieLogo2.js

// Variablen
var nextpic = 0
var warten = 5000

if (document.images){
	var pic = new Array("../bilder/pfeilmit01.gif","../bilder/pfeilmit02.gif","../bilder/pfeilmit03.gif","../bilder/pfeilmit04.gif")
}//endif
	
function nextimg(){
	document.ani.src = pic[nextpic]
	nextpic++
		if(nextpic==pic.length){
			nextpic = 0
		}//endif
	setTimeout("nextimg()", warten)
}//nextimg