<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<!-- Anzeige: Administation erstellen/beschriften oder anlegen von Dokumenttypen -->
<%@ page language="java"
	import="database.dateien.Selinas"
	import="selinas.bean.SelinasSession"
	import="selinas.table.Selinas025H"
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
<link href="<%= request.getContextPath()%>/build/fonts/fonts-min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/container/assets/skins/sam/container.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/fonts/fonts-min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/button/assets/skins/sam/button.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/container/assets/skins/sam/container.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/calendar/assets/skins/sam/calendar.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas025.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/> 
<!-- Script's  -->
<script type="text/javascript" src="<%= request.getContextPath()%>/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/container/container-min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/dragdrop/dragdrop-min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/element/element-min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/button/button-min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/calendar/calendar-min.js"></script>
<script src="<%= request.getContextPath()%>/script/dalieTooltip.js" type="text/javascript"></script>
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>

<title>dalieweb</title>
</head>
<body class="yui-skin-sam" onload="if(document.images) nextimg()">
<%	
	SelinasSession show = new SelinasSession((Selinas) session.getAttribute("Selinas")); 
    SelinasUser user = (SelinasUser) session.getAttribute("User");
	Typ typ = (Typ)session.getAttribute("Typ");
	Adresse adresse = (Adresse)session.getAttribute("Adresse");
	String language = (String)session.getAttribute("Speech");
	String typOrderByTyp = (String)session.getAttribute("TypOrderByTyp");//SessionAttribut:sort by Typ
%>
<div id="page">
	<div id="pageHeader">
		<a href="<%= request.getContextPath()%>/dalieweb.jsp" target="_top">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
		<span class="strapline">dalieweb.de</span>
	</div><!-- /pageHeader -->
	<div id="pageWrapper">
		<dalie:SelinasNavTag></dalie:SelinasNavTag>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td>
					<table border="0" cellspacing="3" cellpadding="0">
					 <tr>
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin10" alt='<%= show.session.getImage2() %>' title='<%= show.session.getImage2() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/GoToStartServlet?selectTyp=UB" title="<%= show.session.getLink1t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink1()%></span></a></td>
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin11" alt='<%= show.session.getImage4() %>' title='<%= show.session.getImage4() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/GoToSelinas025Servlet" title="<%= show.session.getLink5t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink5() %></span></a></td>
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin12" alt='<%= show.session.getImage5() %>' title='<%= show.session.getImage5() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/GoToSelinas030Servlet" title="<%= show.session.getLink6t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink6() %></span></a></td>
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin13" alt='<%= show.session.getImage3() %>' title='<%= show.session.getImage3() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/GoToSelinas020Servlet" title="<%= show.session.getLink4t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink4() %></span></a></td>
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
			<dalie:selinas025FTTag data="N" columnHeader='<%= new Selinas025H().valueOf("25",language,typOrderByTyp) %>' tableTagClass="anforderungsdetails"></dalie:selinas025FTTag>
				<iframe src="<%= request.getContextPath()%>/selinas/selinas025FT.jsp" width="100%" name="selinas2" frameborder="0" height="160"></iframe>
		</div><!-- /navigationDetail -->
		<br />
<form action="/dalieweb/TypToProcessServlet" method="post">
			<table style="border-style: solid; border-top-width: 1px; border-right-width: 1px; border-left-width: 1px; border-bottom-width: 1px; border-color: #557AA6;" width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
				<tr>
					<td>
						<table width="99%" border="0" cellpadding="0" cellspacing="0" class="details">
							<caption style="text-align: left; font: bold 10px Helvetica, sans-serif; margin-left: 8px; margin-top: 5px; margin-bottom: 3px;"><!-- Benutzerangaben: --><%= show.session.getCaption8() %></caption>
							<tr>
								<td style="border-style: solid; border-top-width: 1px; border-right-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-color: #557AA6; padding-left: 5px; padding-top: 5px;"
									align="left">Typ</td>
								<td style="border-style: solid; border-top-width: 1px; border-right-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-color: #557AA6; padding-left: 5px; padding-top: 5px;"
									align="left"><dalie:InputOption name='<%= show.session.getDokumentTyp() %>' value='<%= typ.getTyp() %>' tabindex="0" size="5" permitId="9"></dalie:InputOption><dalie:InputOption name='<%= show.session.getDescripten() %>' value='<%= typ.getDescription() %>' tabindex="1" size="20" maxlength="30"></dalie:InputOption></td>
							</tr>
						</table>					
					</td>
				</tr>
				<tr>
					<td style="border-style: solid; border-top-width: 1px; border-right-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-color: #557AA6; padding-left: 5px; padding-top: 5px;"
						align="left"><dalie:ButtonOption name="submit" accesskey="s" permitId="3" tabindex="14"><!-- Button:Verarbeitung starten --><%= show.session.getButton1() %></dalie:ButtonOption>
					<dalie:ButtonOption name="delete" accesskey="l" permitId="4" tabindex="15"><!-- Button:Dokumenttyp löschen --><%= show.session.getButton12() %></dalie:ButtonOption>
					<dalie:ButtonOption name="new" accesskey="n" permitId="3" tabindex="16"><!-- Button:Dokumenttyp anlegen --><%= show.session.getButton13() %></dalie:ButtonOption>
					<dalie:ButtonOption name="beenden" accesskey="e" tabindex="17" permitId="2"><!-- Button:beenden --><%= show.session.getButton2() %></dalie:ButtonOption></td>
				</tr>
				<tr>
					<td align="left"><!-- CLASS:HinweisOption --><dalie:HinweisOption message='${requestScope.Message}'></dalie:HinweisOption></td>
				</tr>
			</table>
			<div id="contentLeft">	
				<span>&nbsp;</span>			
			</div><!-- /contentLeft -->
			<div id="contentRight">	
				<span>&nbsp;</span>	
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

