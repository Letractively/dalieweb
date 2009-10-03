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
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb.xml"/> 
<!-- Script's  -->
<script src="/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body onload="if(document.images) nextimg()">
<div id="page">
	<div id="pageHeader"><a href="http://www.dalieweb.de/" target="_self"><img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60"
	alt="" name="ani" title="dalieweb" class="logo"/></a><span class="strapline">dalieweb.de</span></div><!-- pageHeader -->
<div id="wrapper">
	<div id="header">
		<h1>Selinas - Onlineverwaltung von Dokumenten</h1>
	</div><!-- header -->
	<div id="wrapperContent">
	<div id="content">		
		<h2>Beschreibung von Selinas</h2>
		<p>- Erstellung von verschieden Dokumenttypen z.B. Arbeitsanweisungen, Konzepten oder Formularen.<br /><br />
			- Metadaten zu einem Dokument können bis zu einen gewissen Grad am Dokument frei definiert werden.<br /><br />
			- Upload und download Funktion von Office-Dateien, die den Dokumenten zu geteilt werden.<br /><br />
			- Volle Berechtigungssteuerung anlegen, verändern, löschen, kopieren.<br /><br />
			- Selinas kann in allen Sprachen der Welt betrieben werden<br /><br />
			- Dokumente könnten mit einer Struktur über mehrere Standorte eines Mandanten <br />&nbsp;&nbsp;organisiert und verwaltet werden.<br /><br />
			- Zugriff nur für freigeschaltete User.<br /><br />
			- Diverse Reportings werden als PDF zur Laufzeit generiert.<br /><br />
		</p>
		
		<p>Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus.</p>
		<h3>Et harum quidem rerum</h3>
		<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
	</div><!-- content -->
	<div id="contentRight">	
		<div class="ws-notizen">
	<h3>Login</h3> 
	<form name="dokument" id="dokument" method="post" action="/dalieweb/LogOnSelina">
	<table>
	<tfoot>
		<tr>
			<th scope="row"></th>
			<td colspan="2"><button id="login" name="login" tabindex="3">login</button></td>
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
	<p><a href="http://www.dalieweb.de/dalieweb.xml" target="_blank"></a></p>
	<p><a href="http://code.google.com/p/calculators/source/browse/#svn/trunk/daliecalculator" target="_blank"></a></p>
	</div><!-- div ws-notizen -->
	</div><!-- contentRight -->
	</div><!-- wrapperContent -->	
	<div id="footer">
	<p>&nbsp;</p>
	</div><!-- footer -->	
</div><!-- wrapper -->
<div id="pageFooter"><!-- CLASS:FooterLebenslauf --><dalie:FooterLebenslauf></dalie:FooterLebenslauf></div><!-- pageFooter -->	
</div><!-- page -->
</body>
</html>
