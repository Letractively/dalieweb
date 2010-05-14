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
<link href="<%= request.getContextPath()%>/theme/selinas001.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/> 
<!-- Script's  -->
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body onload="if(document.images) nextimg()">
<div id="page">
	<div id="pageHeader"><a href="<%= request.getContextPath()%>/dalieweb.jsp" target="_top"><img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60"
	alt="dalieweb" name="ani" title="dalieweb" class="logo"/></a><span class="strapline">dalieweb.de</span></div><!-- /pageHeader -->
<div id="wrapper">
	<div id="header">
	</div><!-- header -->
	<div id="wrapperContent">
	<div id="content">		
		<h2>Selinas - Onlineverwaltung ihrer Dokumente</h2>
		<p><img src="<%= request.getContextPath()%>/bilder/arrow.gif" alt="" /> Erstellung von verschieden Dokumenttypen z.B. Arbeitsanweisungen, Konzepten oder Formularen.</p>
		<p><img src="<%= request.getContextPath()%>/bilder/arrow.gif" alt="" /> Metadaten zu einem Dokument können bis zu einen gewissen Grad am Dokument frei definiert werden.</p>
		<p><img src="<%= request.getContextPath()%>/bilder/arrow.gif" alt="" /> Upload und download Funktion von Office-Dateien, die den Dokumenten zu geteilt werden.</p>
		<p><img src="<%= request.getContextPath()%>/bilder/arrow.gif" alt="" /> Volle Berechtigungssteuerung anlegen, verändern, löschen, kopieren.</p>
		<p><img src="<%= request.getContextPath()%>/bilder/arrow.gif" alt="" /> Selinas kann in allen Sprachen der Welt betrieben werden</p>
		<p><img src="<%= request.getContextPath()%>/bilder/arrow.gif" alt="" /> Dokumente könnten mit einer Struktur über mehrere Standorte eines Mandanten <br />&nbsp;&nbsp;organisiert und verwaltet werden.</p>
		<p><img src="<%= request.getContextPath()%>/bilder/arrow.gif" alt="" /> Zugriff nur für freigeschaltete User.</p>
		<p><img src="<%= request.getContextPath()%>/bilder/arrow.gif" alt="" /> Diverse Reportings werden als PDF zur Laufzeit generiert.</p>
		<br />
	</div><!-- content -->
	<div id="contentRight">	
		<div class="titleTabTop">
			<div>
				<h4>Quick Start</h4>
			</div>
		</div><!-- /titleTag -->
<div class="box afterH4 quickStart">
<ul class="circle">
<li>Für mehr Information:</li>
<li>
<a href="mailto:dalie@dalieweb.de">Email dalieweb</a>
</li>
<li>
<a href="<%= request.getContextPath()%>/selinas doku/Selinas.doc" target="_blank">Online Demo</a>
</li>
<li>&nbsp;
</li>
</ul>
</div><!-- /box afterH4 quickStart -->
		<div class="ws-notizen">
	<h3>Login</h3> 
	<form name="dokument" id="dokument" method="post" action="/dalieweb/LogOnSelina">
	<table>
	<tfoot>
		<tr>
			<th scope="row"></th>
			<td colspan="2"><button id="login" type="submit" name="login" tabindex="3" value="login">login</button></td>
		</tr>
	</tfoot>
		<tr>
			<td><label for="userId">Benutzer:</label></td>
			<td><input type="text" maxlength="6" name="userId" id="userId" tabindex="1"/></td>
		</tr>
		<tr>
			<td><label for="password">Passwort:</label></td>
			<td><input type="password" maxlength="40" name="password" id="password" tabindex="2" /></td>
		</tr>
		<tr>
			<td><label>&nbsp;&nbsp;Sprache</label></td>
			<td><dalie:LanguageOption name="speech" permitId="2" tabindex="3"></dalie:LanguageOption></td>
			</tr>
	</table>
		<dalie:HinweisOption message='${requestScope.Message}' typ="E"></dalie:HinweisOption>
	</form>
	</div><!-- div ws-notizen -->
	<div class="ws-notizen">
	<h3>Kontakt</h3>
	<p><a href="mailto:dalie@dalieweb.de" tabindex="4">Schreiben</a>&nbsp;Sie mir!</p>
	</div><!-- div ws-notizen -->
	<div class="ws-notizen">
	<h3>Links</h3>
	<p><a href="http://www.netvibes.com/dalie#General" target="_blank"></a></p>
	<p><a href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml" target="_blank"></a></p>
	<p><a href="http://code.google.com/p/dalieweb/source/browse/#svn/trunk/dalieweb" target="_blank">
			<img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="googleCode" alt='Projekthosting' title='Projekthosting'/>	
		</a></p>
	</div><!-- div ws-notizen -->
	</div><!-- contentRight -->
	</div><!-- wrapperContent -->	
	<div id="footer">
	</div><!-- footer -->	
</div><!-- wrapper -->
<div id="pageFooter"><!-- CLASS:FooterLebenslauf --><dalie:FooterLebenslauf></dalie:FooterLebenslauf>
<div id="meta-wrap">
<div class="vcard">
 <a class="url" href="http://www.dalieonline.de/"></a>
 <div class="org fn">dalieweb.de<br /></div>
 <div class="adr">
  <div class="street-address">Vogelsangstraße 9</div>
  <span class="locality">Stuttgart</span> 
  <span class="region">DE</span>
  <span class="postal-code">70176</span>
 </div>
 <div class="tel"></div>
	<a href="http://www.dalieonline.de">Contact Us.</a> | <a href="mailto:dalie@dalieweb.de">Schreiben</a>&nbsp;Sie mir!
</div><!-- vcard -->
</div><!-- meta-wrap -->
</div><!-- pageFooter -->	
</div><!-- page -->
</body>
</html>
