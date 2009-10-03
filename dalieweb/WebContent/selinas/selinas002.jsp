<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head> 
<%@ page language="java"
	import="database.dateien.Selinas"
	import="selinas.bean.SelinasSession"
	import="selinas.SelinasUser"
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
<link href="<%= request.getContextPath()%>/theme/selinas002.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb.xml"/> 
<!-- Script's  -->
<script src="/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body onload="if(document.images) nextimg()">
<%	
	SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
    SelinasUser user = (SelinasUser) session.getAttribute("User");
%>
<div id="page">
	<div id="pageHeader"><a href="http://www.dalieweb.de/" target="_self"><img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60"
	alt="" name="ani" title="dalieweb" class="logo"/></a><span class="strapline">dalieweb.de</span></div><!-- pageHeader -->
<div id="wrapper">
	<div id="header">
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
		<td valign="middle" align="left">&nbsp;</td>
		<td valign="middle" 
			align="right" class="strapline"><%= user.user.getName() %>, <%= user.user.getVorname() %>&nbsp;
			<a href="<%= request.getContextPath()%>/LogOffSelina" target="_self">Log off</a></td>
		</tr>
		</table>
	</div><!-- header -->
	<div id="wrapperContent">
	<div id="content">		
		
	</div><!-- content -->
	</div><!-- wrapperContent -->	
	<div id="footer">
	<p>&nbsp;</p>
	</div><!-- footer -->	
</div><!-- wrapper -->
<div id="pageFooter"><!-- CLASS:FooterLebenslauf --><dalie:FooterLebenslauf></dalie:FooterLebenslauf></div><!-- pageFooter -->	
</div><!-- page -->
</body>
</html>
