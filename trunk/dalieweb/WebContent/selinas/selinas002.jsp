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
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body onload="if(document.images) nextimg()">
<%	
	SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
    SelinasUser user = (SelinasUser) session.getAttribute("User");
	String language = (String)session.getAttribute("Speech"); 
%>
<div id="page">
	<div id="pageHeader">
		<a href="http://www.dalieweb.de/" target="_self">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
		<span class="strapline">dalieweb.de</span>
	</div><!-- /pageHeader -->
	<div id="pageWrapper">
		<div id="navigation">
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td valign="middle" align="left"><dalie:StartNavTag></dalie:StartNavTag></td>
			<td valign="middle" align="right" class="strapline"><%= user.user.getName() %>, <%= user.user.getVorname() %>&nbsp; <a href="<%= request.getContextPath()%>/LogOffSelina" target="_self" class="link">Log off</a></td>
		</tr>
		</table>
	</div>
		<div id="dokumentHeader">
		 <br />
			<form name="dokument" method="post" action="<%= request.getContextPath()%>/DokumentToInitializeServlet" class="formular">
<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td><label><%= show.session.getDokumentTyp()  %></label>
	<dalie:Selectbox name="dokumentTyp" argument="KA" ccsStyle="selectbox"></dalie:Selectbox></td>
			<td><label>&nbsp;<%= show.session.getDokumentNr() %></label>
<dalie:InputOption name="dokumentNr" tabindex="2" value="1" size="5"></dalie:InputOption></td>
			<td><dalie:ButtonOption name="insert" accesskey="a" tabindex="1">
	<b>Dokument <span style="text-decoration:underline">a</span>nlegen</b>
</dalie:ButtonOption></td>
		</tr>
	</tbody>
</table>
</form>	 	
<!-- CLASS:HinweisOption -->
<dalie:HinweisOption message='${requestScope.Message}'></dalie:HinweisOption>
		</div><!-- /dokumentHeader -->
		<div id="wrapper">
			<dalie:DokumentDataTag data="N" columnHeader='<%= ColumHeader.valueOf("3",language) %>'></dalie:DokumentDataTag>
			<iframe src="<%= request.getContextPath()%>/selinas/selinas002F.jsp" width="100%" name="selinas" frameborder="0" height="460"></iframe>
		</div><!-- wrapper -->
		<div id="footer">
	
	</div><!-- /footer -->
	</div><!-- /pageWrapper -->
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
