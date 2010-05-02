<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	import="database.dateien.Selinas"
	import="selinas.bean.SelinasSession"
	import="selinas.SelinasUser"
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
<link href="<%= request.getContextPath()%>/theme/selinas003.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/> 
<!-- Script's  -->
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body onload="if(document.images) nextimg()">
<%	
	SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
    SelinasUser user = (SelinasUser) session.getAttribute("User");
	Dokument dokument = (Dokument)session.getAttribute("Dokument");
%>
<div id="page">
	<div id="pageHeader"><a href="http://www.dalieweb.de/" target="_self"><img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60"
	alt="" name="ani" title="dalieweb" class="logo"/></a><span class="strapline">dalieweb.de</span></div><!-- pageHeader -->
	<div id="pageContentWrapper">
		<div id="pageContent"><p>pageContentLeft</p></div><!-- pageContent -->
		<div id="pageContentRight">
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
	<div id="contentLeft">		
		<table>
			<tr>
				<td><%= show.session.getGliederung() %></td><td><dalie:InputOption name='<%= show.session.getGliederung() %>' value='<%= dokument.getGliederung() %>' tabindex="1"></dalie:InputOption></td>
			</tr>
			<tr>	
				<td><%= show.session.getArchiv() %></td><td><dalie:InputOption name='<%= show.session.getArchiv() %>' value='<%= dokument.getArchiv() %>' tabindex="2"></dalie:InputOption></td>
			</tr>
			<tr>	
				<td><%= show.session.getVorgabe() %></td><td><dalie:InputOption name='<%= show.session.getVorgabe() %>' value='<%= dokument.getVorgabe() %>' tabindex="3"></dalie:InputOption></td>
			</tr>
			<tr>	
				<td><%= show.session.getStatus() %></td><td><dalie:Selectbox name="Status" argument='<%= dokument.getStatus() %>' ccsStyle="selectbox" tabindex="4"></dalie:Selectbox></td>
			</tr>
		</table>
		</div><!-- contentLeft -->
	<div id="wrapperContent">
	<div id="content">		
		<table>
			<tr>
			 <td><%= show.session.getTitel() %></td><td><dalie:InputOption name='<%= show.session.getTitel() %>' value='<%= dokument.getTitel() %>' size="26" tabindex="5"></dalie:InputOption></td>
			</tr>
			<tr>
			 <td><%= show.session.getDescripten() %></td><td><dalie:InputOption name='<%= show.session.getDescripten() %>' value='<%= dokument.getDescripten() %>' size="26" tabindex="6"></dalie:InputOption></td>
			</tr>
			<tr>
			<td colspan="2"><textarea name='<%= show.session.getContent() %>' rows="30" cols="30"><%= dokument.getContent()%></textarea></td>	
			</tr>
		</table>
	</div><!-- content -->
	<div id="contentRight">	
		<h2>Content Right</h2>
		<ul>
					<li><a href="selinas-SiteTyp1.jsp">SiteTyp 1</a></li>
					<li><a href="selinas-SiteTyp2.jsp">SiteTyp 2</a></li>
					<li><a href="selinas-SiteTyp3.jsp">SiteTyp 3</a></li>
					<li><a href="selinas-SiteTyp4.jsp">SiteTyp 4</a></li>
					<li><a href="selinas-SiteTyp5.jsp">SiteTyp 5</a></li>
					<li><a href="selinas-SiteTyp6.jsp">SiteTyp 6</a></li>
					<li><a href="selinas-SiteTyp7.jsp">SiteTyp 7</a></li>
					<li><a href="selinas-SiteTyp8.jsp">SiteTyp 8</a></li>
				</ul>
		<h3>Technologien</h3>
		<p>Java<br />JavaServer Pages/Servlet<br />Benutzerdefinierte Aktion TagSupport<br />JavaScript<br />MySql<br />XML/XSL<br />FOP<br />HTML<br />CSS - Cascading Style Sheets<br /></p>
	</div><!-- contentRight -->
	</div><!-- wrapperContent -->	
	<div id="footer">
	<p>footer</p>
	</div><!-- footer -->	
</div><!-- wrapper -->
	</div><!-- pageContentRight -->
	</div><!-- pageContentWrapper -->
	<div id="pageFooter"><!-- CLASS:FooterLebenslauf --><dalie:FooterLebenslauf></dalie:FooterLebenslauf></div><!-- pageFooter -->	
</div><!-- page -->
</body>
</html>
