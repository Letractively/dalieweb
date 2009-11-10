<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head> 
<%@ page language="java"
	import="database.dateien.Dokument"
	import="selinas.ColumHeader"
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
<link href="<%= request.getContextPath()%>/theme/selinas003.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<title>dalieweb</title>
</head>
<body>
<%	
	Dokument dokument = (Dokument)session.getAttribute("Dokument");	
	String language = (String)session.getAttribute("Speech");
%>
	<div id="footers">
	<dalie:DokumentTypTag header="N" farbe1="#EEEEEE" farbe2="#DEDEDE" columnHeader='<%= ColumHeader.valueOf("1",language) %>' typ='<%= dokument.getDokumentTyp() %>' tableTagClass="linkTable"></dalie:DokumentTypTag>
	</div><!-- /footer -->
</body>
</html>