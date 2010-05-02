<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	import="selinas.SelinasUser"
	import="selinas.bean.SelinasSession" 
	import="selinas.table.Selinas002H"
	import="database.dateien.Dokument"
	import="database.dateien.Selinas"
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
<link href="http://yui.yahooapis.com/2.8.0r4/build/fonts/fonts-min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="http://yui.yahooapis.com/2.8.0r4/build/container/assets/skins/sam/container.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="http://yui.yahooapis.com/2.8.0r4/build/fonts/fonts-min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="http://yui.yahooapis.com/2.8.0r4/build/button/assets/skins/sam/button.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="http://yui.yahooapis.com/2.8.0r4/build/container/assets/skins/sam/container.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="http://yui.yahooapis.com/2.8.0r4/build/calendar/assets/skins/sam/calendar.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas002.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/> 
<!-- Script's  -->
<script type="text/javascript" src="http://yui.yahooapis.com/2.8.0r4/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.8.0r4/build/container/container-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.8.0r4/build/dragdrop/dragdrop-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.8.0r4/build/element/element-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.8.0r4/build/button/button-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.8.0r4/build/calendar/calendar-min.js"></script>
<script src="<%= request.getContextPath()%>/script/dalieTooltip.js" type="text/javascript"></script>
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body class="yui-skin-sam" onload="if(document.images) nextimg()">
<%	
	SelinasSession show = new SelinasSession((Selinas)session.getAttribute("Selinas")); 
    SelinasUser user = (SelinasUser) session.getAttribute("User");
	String language = (String)session.getAttribute("Speech"); 
	String dokumentOrderByTyp = (String)session.getAttribute("DokumentOrderByTyp");//SessionAttribut:sort by Dokument
	
%>
<div id="page">
	<div id="pageHeader">
		<a href="<%= request.getContextPath()%>/dalieweb.jsp" target="_top">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
		<span class="strapline">dalieweb.de</span>
	</div><!-- /pageHeader -->
	<div id="pageWrapper">
		<dalie:SelinasNavTag></dalie:SelinasNavTag>
		<div id="navigation">
			<dalie:StartNavTag></dalie:StartNavTag>
		</div><!-- /navigation -->
		<div id="header">
			<br />
			<form name="dokument" method="post" action="<%= request.getContextPath()%>/DokumentToInitializeServlet" class="formular">
				<input type="hidden" name="kundenId" value="<%= user.user.getKundenId() %>" />
				<input type="hidden" name="standortId" value="<%= user.user.getStandortId() %>" />
				<table border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td><label><%= show.session.getDokumentTyp()  %></label>
								<dalie:Selectbox name="dokumentTyp" argument="KA" ccsStyle="selectbox"></dalie:Selectbox></td>
							<td><label>&nbsp;<%= show.session.getDokumentNr() %></label>
								<dalie:InputOption name="dokumentNr" tabindex="2" value="1" size="5"></dalie:InputOption></td> 
							<td><dalie:ButtonOption name="insert" accesskey="a" permitId="3" tabindex="1"><%= show.session.getButton11() %></dalie:ButtonOption></td>
						</tr>
					</tbody>
				</table>
			</form>	 	
			<!-- CLASS:HinweisOption -->
			<dalie:HinweisOption message='${requestScope.Message}'></dalie:HinweisOption>
		</div><!-- /header -->
		<div id="wrapper"> 
			<dalie:DokumentDataTag data="N" columnHeader='<%= new Selinas002H().valueOf("2",language,dokumentOrderByTyp) %>'></dalie:DokumentDataTag>
			<iframe src="<%= request.getContextPath()%>/selinas/selinas002F.jsp" width="100%" name="selinas" frameborder="0" height="100%"></iframe>
		</div><!-- /wrapper -->
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
</div><!-- /page -->
</body>
</html>
