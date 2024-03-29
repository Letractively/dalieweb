<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head> 
<!-- Frame: Anzeige Adressen -->
<%@ page language="java"
	import="selinas.table.Selinas020H"
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
<link href="<%= request.getContextPath()%>/build/fonts/fonts-min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/container/assets/skins/sam/container.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/fonts/fonts-min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/button/assets/skins/sam/button.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/container/assets/skins/sam/container.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/calendar/assets/skins/sam/calendar.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas020.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<title>dalieweb</title>
</head>
<body>
<%	
	String language = (String)session.getAttribute("Speech");
%> 
<div id="navigationDetails">  
	<dalie:selinas020FATag header="N" farbe1="#FFFFFF" farbe2="#DEDEDE" columnHeader='<%= Selinas020H.valueOf("20",language) %>'></dalie:selinas020FATag>
</div><!-- /navigationsDetails -->
</body>
</html>
