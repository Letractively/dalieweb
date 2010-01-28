<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head> 
<%@ page language="java"
	import="database.dateien.Dokument"
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
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<title>dalieweb</title>
<style type="text/css">
body {
	padding: 0px 0px 0px 5px; 
	font-family: Verdana, Tahoma, Arial, sans-serif;
	line-height: normal;
	font-size: 12px;
}
p{
	margin-top: 0px;
	margin-bottom: 0px;
}
ul
{
	margin-top: 0px;
	margin-bottom: 0px;
}
a:link, a:visited {
	text-decoration: none;
	color: #2A4F6F;
	background-color: transparent;
	border-bottom: 1px dotted #B2BCC6
}

a:hover {
	color: #778899;
}
</style>
</head>
<body> 
<%	
	Dokument dokument = (Dokument) session.getAttribute("Dokument");
%>
	<%= dokument.getContent()%>
</body>
</html>
