<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!-- onwn TagLib-Direktive -->
<%@ taglib uri="/WEB-INF/TagLibraryDescriptor.tld" prefix="dalie"%>
<!-- MetaData -->
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=ISO-8859-1"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta name="keywords" content="dalieweb"/>
<meta name="author" content="u.dalies"/>
<!-- CSS und Icons --> 
<link href="<%= request.getContextPath()%>/build/base/base-min.css" rel="stylesheet" type="text/css"/>
<link href="<%= request.getContextPath()%>/build/reset-fonts-grids/reset-fonts-grids.css" rel="stylesheet" type="text/css"/>
<link href="<%= request.getContextPath()%>/theme/immo001.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<!-- Script's  -->
<script language="javascript" type="text/javascript">
	function reSize_iFrame001FR(){
	var body_height = document.getElementById("bo").offsetHeight; 
	var doc_height = document.getElementById("doc3").offsetHeight;
	var test = screen.availHeight - (body_height + body_height);
	if ( test < doc_height) {
		document.getElementById("iFrame001FR").style.height = + doc_height + "px";
	}else{
		document.getElementById("iFrame001FR").style.height = + ((doc_height + (doc_height/100 * 35))) + "px";
	}//endif
}
</script>
<title>dalieweb</title>
</head>
<body id="bo" class="yui-skin-sam" onload="reSize_iFrame001FR()">
	<div id="doc3" class="yui-t7">
		<div id="bd">
			<div class="yui-gf">
			<!-- 1.Zeile gesamte Breite  -->
				<br /><br /> 
			</div><!-- /yui-gf 1.Zeile gesamte Breite --> 
			<div class="yui-gf">
			<!-- 2.Zeile gesamte Breite --> 
	    <div class="yui-u first">
			<!-- 2.Zeile linker Frame -->
				<p style="margin: 5px 0px 0px 15px;
					font: 1.5em/ 1.8em Verdana, Arial, Tahoma, Verdana, sans-serif;">TicTacToe</p>
			<applet codebase="/dalieweb/" code="applet/TicTacToe.class" width="210" height="210" 
				style="border-style: solid; 
						border-top-width: 1px; 
						border-right-width: 1px; 
						border-left-width: 1px; 
						border-bottom-width: 1px; 
						border-color: #557AA6;"></applet><br />
	       	<form style="padding-top: 5px;" name="dokument" id="dokument" method="post" action="">
			<button id="reset" type="submit" name="reset" tabindex="1" value="reset">reset</button>
			</form>&nbsp;<br />
			</div> <!-- yui-u first -->
	    	<div class="yui-u">
			<!-- 2.Zeile rechter Frame -->
				<p style="margin: 5px 0px 0px 15px;
					font: 1.5em/ 1.8em Verdana, Arial, Tahoma, Verdana, sans-serif;">Java-Code for Applet</p>
				<iframe style="border-style: solid; 
						border-top-width: 1px; 
						border-right-width: 1px; 
						border-left-width: 1px; 
						border-bottom-width: 1px; 
						border-color: #557AA6;
						padding: 2px 4px;" src="<%= request.getContextPath()%>/tictactoe/tictactoe001FR.jsp" id="iFrame001FR" name="iFrame001FR" height="100" width="100%" frameborder="0"></iframe>
	       	</div><!-- yui-u --> 
		</div><!-- yui-gf 2.Zeile gesamte Breite  -->
	</div><!-- /bd body -->
	</div><!-- /doc3 = 100%, -->
</body>
</html>
