<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	contentType="text/html;charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!-- onwn TagLib-Direktive -->
<!-- MetaData -->
<meta http-equiv="Content-Type" content="application/xhtml+xml;charset=ISO-8859-1"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta name="keywords" content="dalieweb"/>
<meta name="author" content="u.dalies"/>
<meta name="DC.title" content="Online Verwaltung - Verwaltung von Dokumenten, Mietverträge, Wohnungsveraltung, Nebenabrechungen | DALIEWEB.DE" />
<meta name="description" content="Auf DALIEWEB.DE finden Sie die Möglichkeit eigene Dokumente online zu Verwalten. Ziel soll es sein Mietverträge komplett über dieses Portal abzuwickeln." />
<meta name="keywords" content="DALIEWEB.de, Mietverträge, Konzepte, Formulare, PDF verwaltung, online" />
<!-- CSS und Icons -->
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<title>dalieweb</title>
</head>
<body>
<div id="wrapper">
	<h2>online verwaltung von Mietverträge und online dokumente</h2>
	<% 
		try{
			response.sendRedirect("http://www.dalieonline.de/dalieweb");
		}catch(Exception e){
			System.out.println("Hello World");
		}//try
	%>
</div><!-- wrapper -->
</body>
</html>
