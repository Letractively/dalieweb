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
<link href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/>
<!-- Script's  -->
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
function resizeFrame(){
	document.getElementById("selinasFrame").style.height = + (screen.availHeight - 514) + "px";
	document.getElementById("selinasFrame").style.width = + (screen.availWidth - 340) + "px";
	if (screen.height < 800) {
		document.getElementById("selinasFrame").style.width = + (screen.availWidth - 360) + "px";
	}endif
}
</script>
<title>dalieweb</title>
</head>
<body class="yui-skin-sam" onload="if(document.images) nextimg(), resizeFrame()">
	<div id="hd">
		<span class="strapline">dalieweb.de</span>
		<a href="<%= request.getContextPath()%>/dalieweb.jsp" target="_top">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
	</div><!-- /hd header -->
	<div id="doc3" class="yui-t7">
	<div id="bd">
		<div class="yui-gf">
		<!-- 1.Zeile gesamte Breite  -->
			<br /><br /> 
			<p style="margin: 5px 0px 0px 15px;
					font: 1.5em/ 1.8em Verdana, Arial, Tahoma, Verdana, sans-serif;">TicTacToe</p>
		</div><!-- /yui-gf 1.Zeile gesamte Breite --> 
		<div class="yui-gf">
		<!-- 2.Zeile gesamte Breite --> 
	    	<div class="yui-u first">
			<!-- 2.Zeile linke hälfte -->
			<applet codebase="/dalieweb/" code="applet/TicTacToe.class" width="210px" height="210px" 
				style="border-style: solid; 
						border-top-width: 1px; 
						border-right-width: 1px; 
						border-left-width: 1px; 
						border-bottom-width: 1px; 
						border-color: #557AA6;"></applet><br />
			<form style="padding-top: 5px;" name="dokument" id="dokument" method="post" action="./tictactoe.jsp">
			<button id="reset" type="submit" name="reset" tabindex="1" value="reset">reset</button>
			</form>&nbsp;<br />
	       	</div> <!-- yui-u first -->
	    	<div class="yui-u">
			<!-- 2.Zeile rechte hälfte -->
				<iframe style="margin-bottom: 10px;" src="<%= request.getContextPath()%>/tictactoe/tictactoe001F.jsp" id="selinasFrame" name="selinasFrame" height="540px" width="945px" frameborder="0" onload="resizeFrame()"></iframe>
	       	</div><!-- yui-u --> 
		</div><!-- yui-gf 2.Zeile gesamte Breite  -->
	</div><!-- /bd body -->
	</div><!-- /doc3 = 100%, -->
   	<div id="ft">
		<dalie:FooterLebenslauf></dalie:FooterLebenslauf><!-- CLASS:FooterLebenslauf -->
			<div id="meta-wrap">
				<div class="vcard">
 					<a class="url" href="http://www.dalieonline.de/"></a>
 					<div class="org fn">
						dalieweb.de<br />
					</div><!-- /org fn -->
 					<div class="adr">
 						<div class="street-address">
							Vogelsangstraße 9
						</div><!-- street-address -->
  						<span class="locality">Stuttgart</span> 
  						<span class="region">DE</span>
  						<span class="postal-code">70176</span>
				 	</div><!-- /adr -->
 					<div class="tel">
					</div><!-- /tel -->
					<a class="url fn" href="http://www.dalieonline.de">Contact Us.</a> | <a class="email" href="mailto:dalie@dalieweb.de">Schreiben</a>&nbsp;Sie mir!
				</div><!-- /vcard -->
			</div><!-- /meta-wrap -->
	</div><!-- /ft footer -->
</body>
</html>
