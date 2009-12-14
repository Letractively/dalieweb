<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	import="database.dateien.Selinas"
	import="selinas.bean.SelinasSession"
	import="selinas.ColumHeader"
	import="selinas.SelinasUser"
	import="database.dateien.Dokument"
	import="database.dateien.Typ"
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
<link href="<%= request.getContextPath()%>/theme/selinas005.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb.xml"/> 
<!-- Script's  -->
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body onload="if(document.images) nextimg()">
<%	
	SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
    SelinasUser user = (SelinasUser) session.getAttribute("User");
	Dokument dokument = (Dokument)session.getAttribute("Dokument");
	Typ typ = (Typ)session.getAttribute("Typ");
	String language = (String) session.getAttribute("Speech");
	String modus = (String)session.getAttribute("Modus");
%>
<div id="page">
	<div id="pageHeader">
		<a href="<%= request.getContextPath()%>/dalieweb.jsp" target="_top">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
		<span class="strapline">dalieweb.de</span>
	</div><!-- /pageHeader -->
	<br />
	<div id="pageWrapper">
<form action="<%= request.getContextPath()%>/DokumentToProcessServlet" method="post">
<input type="hidden" name="dokumentTyp" value="<%= dokument.getDokumentTyp() %>" />
<input type="hidden" name="dokumentNr" value="<%= dokument.getNummer() %>" />
<input type="hidden" name="dokumentId" value="<%= dokument.getId() %>" />
		<table border="0" cellspacing="0" cellpadding="0" width="99%">
			<tr>
				<td valign="middle" align="left"></td>
				<td valign="middle" align="right" class="strapline"><%= user.user.getName()%>, <%= user.user.getVorname()%>&nbsp; <a href="<%= request.getContextPath()%>/LogOffSelina" target="_self" class="link">Log off</a></td>
			</tr>
		</table>
		<br /> 
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		<div id="header">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<th width="100%" align="left" valign="middle">Anforderung</th>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="3">
				<tr>
					<td width="15%" align="left"><strong><%= show.session.getDokumentTyp() %></strong></td><td width="35%" align="left"><%= typ.getDescription() %></td>
					<td width="15%" align="left"><strong><%= show.session.getStatus() %></strong></td><td width="35%" align="left"><dalie:Selectbox name="Status" argument='<%=dokument.getStatus()%>' tabindex="7" ccsStyle="BOX"></dalie:Selectbox></td>
				</tr>
				<tr>
					<td width="15%" align="left"><strong><%= show.session.getDokumentNr() %></strong></td><td width="35%" align="left"><%= dokument.getNummer() %>.<%= dokument.getId() %></td>
				</tr>
			</table>
		</div><!-- /header -->
		<div id="wrapper">
			<br />
			<table width="99%" border="0" cellpadding="0" cellspacing="3" class="anforderungsdetails">
				<caption id="caption">Anforderungsdetails</caption>
				<tr>
					<td width="15%" align="left"></td><td width="35%" align="left"></td>
					<td width="15%" align="left"></td><td width="35%" align="left"></td>	
				</tr>
				<tr>
					<td width="15%" align="left"></td><td width="35%" align="left"></td>
				</tr>
			</table> 
			<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
				<tr>
					<td width="15%" align="left"></td><td width="85%" align="left"></td>
				</tr>
				<tr>
					<td width="15%" align="left"></td><td width="85%" align="left"></td>
				</tr>
			</table> 
			<div id="contentLeft">
				<span>&nbsp;</span>
			</div><!-- /contentLeft -->
			<div id="contentRight">	
					<span>&nbsp;</span>
			</div><!-- /contentRight -->
		</div><!-- /wrapper -->
		<div id="footer">
			<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
				<tr>
					<td width="15%" align="left">&nbsp;</td>
					<td width="85%" align="left">
						<dalie:ButtonOption name="submit" accesskey="v" tabindex="8">Dokument <span style="text-decoration:underline">v</span>erarbeiten</dalie:ButtonOption>
						<dalie:ButtonOption name="link" accesskey="A" tabindex="9">Ihre <span style="text-decoration:underline">A</span>nlagen bearbeiten</dalie:ButtonOption>
						<dalie:ButtonOption name="print" accesskey="d" tabindex="10">Dokument <span style="text-decoration:underline">d</span>rucken</dalie:ButtonOption>
		 				<dalie:ButtonOption name="delete" accesskey="l" tabindex="11">Dokument <span style="text-decoration:underline">l</span>öschen</dalie:ButtonOption>
						<dalie:ButtonOption name="beenden" accesskey="e" tabindex="12" permitId="2">B<span style="text-decoration:underline">e</span>enden</dalie:ButtonOption>
				</td> 
				</tr>
				<tr> 
					<td width="15%" align="left">&nbsp;</td>
					<td width="85%" align="left"><!-- CLASS:HinweisOption --><dalie:HinweisOption message='${requestScope.Message}'></dalie:HinweisOption></td>
				</tr>
			</table> 	
		</div><!-- /footer -->	
</form>		
	</div><!-- /pageWrapper -->
		<br />
		<div id="pageFooter">
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
					<a href="http://www.dalieonline.de">Contact Us.</a> | <a href="mailto:dalie@dalieweb.de">Schreiben</a>&nbsp;Sie mir!
				</div><!-- /vcard -->
			</div><!-- /meta-wrap -->
		</div><!-- /pageFooter -->	
</div><!-- page -->
</body>
</html>