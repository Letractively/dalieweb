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
	import="database.dateien.Adresse"
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
<link href="<%= request.getContextPath()%>/theme/selinas025.css" rel="stylesheet" type="text/css" media="screen"/>
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
	Typ typ = (Typ)session.getAttribute("Typ");
	Adresse adresse = (Adresse)session.getAttribute("Adresse");
	String language = (String)session.getAttribute("Speech");
	String TypOrderByTyp = (String)session.getAttribute("TypOrderByTyp");//SessionAttribut:sort by Typ
%>
<div id="page">
	<div id="pageHeader">
		<a href="<%= request.getContextPath()%>/dalieweb.jsp" target="_top">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
		<span class="strapline">dalieweb.de</span>
	</div><!-- /pageHeader -->
	<div id="pageWrapper">
		<table border="0" cellspacing="0" cellpadding="0" width="99%">
			<tr>
				<td valign="middle" align="left"></td>
				<td valign="middle" align="right" class="strapline"><%= user.user.getName() %>, <%= user.user.getVorname() %>&nbsp; <a href="<%= request.getContextPath()%>/LogOffSelina" target="_self" class="link">Log off</a></td>
			</tr>
		</table>	
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="3" cellpadding="0">
					 <tr>
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin1" alt='<%= show.session.getImage2() %>' title='<%= show.session.getImage2() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/GoToStartServlet?selectTyp=UB" title="<%= show.session.getLink1t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink1()%></span></a></td>
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin3" alt='<%= show.session.getImage3() %>' title='<%= show.session.getImage3() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/AdminOfSelina" title="<%= show.session.getLink4t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink4() %></span></a></td>
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin2" alt='<%= show.session.getImage4() %>' title='<%= show.session.getImage4() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/GoToSelinas025Servlet" title="<%= show.session.getLink5t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink5() %></span></a></td>
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin4" alt='<%= show.session.getImage5() %>' title='<%= show.session.getImage5() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/GoToSelinas025Servlet" title="<%= show.session.getLink6t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink6() %></span></a></td>
						</tr>
					</table>	
				</td>
			</tr>
		</table>
		<div id="header">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<th width="100%" align="left" valign="middle"><!-- Verwaltung Dokumenttypen --><%= show.session.getCaption3() %></th>
				</tr>
			</table>
		</div><!-- /header -->
		<div id="wrapper">
			<br />
			<div id="navigationDetail"> 
			<dalie:selinas025FTTag data="N" columnHeader='<%= ColumHeader.valueOf("7",language,TypOrderByTyp) %>' tableTagClass="anforderungsdetails"></dalie:selinas025FTTag>
				<iframe src="<%= request.getContextPath()%>/selinas/selinas025FT.jsp" width="100%" name="selinas2" frameborder="0" height="100"></iframe>
		</div><!-- /navigationDetail -->
<form action="/dalieweb/TypToProcessServlet" method="post">
			<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
				<tr>
					<td width="15%" align="left">Typ</td><td width="85%" align="left">
					<dalie:InputOption name='<%= show.session.getDokumentTyp() %>' value='<%= typ.getTyp() %>' tabindex="0" size="5" permitId="9"></dalie:InputOption>
					<dalie:InputOption name='<%= show.session.getDescripten() %>' value='<%= typ.getDescription() %>' tabindex="1" size="20"></dalie:InputOption>
					</td>
				</tr>
			</table> 
			<div id="contentLeft">	
				<span>&nbsp;</span>			
			</div><!-- /contentLeft -->
			<div id="contentRight">	
			<table width="99%" border="0" cellpadding="0" cellspacing="3">
				<tr>
					<td align="left"><dalie:ButtonOption name="submit" accesskey="s" tabindex="2"><!-- Button:Verarbeitung starten --><%= show.session.getButton1() %></dalie:ButtonOption>
					<dalie:ButtonOption name="delete" accesskey="l" tabindex="3"><!-- Button:Dokumenttyp löschen --><%= show.session.getButton12() %></dalie:ButtonOption>
					<dalie:ButtonOption name="new" accesskey="n" tabindex="4"><!-- Button:Dokumenttyp anlegen --><%= show.session.getButton13() %></dalie:ButtonOption>
					<dalie:ButtonOption name="beenden" accesskey="e" tabindex="3" permitId="2"><!-- Button:beenden --><%= show.session.getButton2() %></dalie:ButtonOption>
					</td> 
				</tr>
				<tr> 
					<td align="left"><!-- CLASS:HinweisOption --><dalie:HinweisOption message='${requestScope.Message}'></dalie:HinweisOption></td>
				</tr>
			</table> 	
			</div><!-- /contentRight -->
</form>
		</div><!-- /wrapper -->
		<div id="footer">
			<br /><br /><br />
		</div><!-- /footer -->	
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

