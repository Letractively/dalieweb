<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	import="selinas.table.Immo001H"
	import="selinas.SelinasUser"
	import="selinas.bean.ImmobilienSession"
	import="database.dateien.StaLanImo" 
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
<link href="<%= request.getContextPath()%>/build/base/base-min.css" rel="stylesheet" type="text/css"/>
<link href="<%= request.getContextPath()%>/build/reset-fonts-grids/reset-fonts-grids.css" rel="stylesheet" type="text/css"/>
<link href="<%= request.getContextPath()%>/build/fonts/fonts-min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/container/assets/skins/sam/container.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/fonts/fonts-min.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/button/assets/skins/sam/button.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/container/assets/skins/sam/container.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/build/calendar/assets/skins/sam/calendar.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/immo001.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb.xml"/>
<!-- Script's  -->
<script type="text/javascript" src="<%= request.getContextPath()%>/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/container/container-min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/dragdrop/dragdrop-min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/element/element-min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/button/button-min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath()%>/build/calendar/calendar-min.js"></script>
<script src="<%= request.getContextPath()%>/script/dalieLogo2.js" type="text/javascript"></script>
<script src="<%= request.getContextPath()%>/script/dalieTooltip.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body class="yui-skin-sam" onload="if(document.images) nextimg()">
<%	
	ImmobilienSession show = new ImmobilienSession((StaLanImo)session.getAttribute("StaLanImo")); 
	SelinasUser user = (SelinasUser) session.getAttribute("User");
	String language = (String)session.getAttribute("Speech"); 
	String immobilienOrderByTyp = (String)session.getAttribute("ImmobilienOrderByTyp");//SessionAttribut:sort by Dokument
%>
	<div id="hd">
		<span class="strapline">dalieweb.de</span>
		<a href="<%= request.getContextPath()%>/dalieweb.jsp" target="_top">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
	</div><!-- /hd header -->
	<div id="doc3" class="yui-t7">
	<div id="bd">
		<div class="yui-ge"> 
	    	<div class="yui-u first"> 
	    		<!-- YOUR DATA GOES HERE --> 
        	</div><!-- /yui-u first --> 
	    	<div class="yui-u">
				<dalie:SelinasNavTag></dalie:SelinasNavTag>
	        </div><!-- /yui-u --> 
		</div><!-- /yui-g --> 
		<div class="yui-g">
		<!-- 2.Zeile gesamte Breite  -->
			2
		</div><!-- /yui-g 1.Zeile gesamte Breite --> 
		<div class="yui-g">
		<!-- 3.Zeile gesamte Breite --> 
	    	<div class="yui-u first">
			<!-- 2.Zeile linke hälfte --> 
					<table border="0" cellpadding="0" cellspacing="0" class="TableTyp1" style="margin-bottom: 4px;">
					<tbody>
						<tr>
							<td><%= show.session.getImmobilientyp()  %></td><td><dalie:Selectbox name="TypDerImmobilie" argument="H" ccsStyle="selectbox" tabindex="1"></dalie:Selectbox></td>
							<td><dalie:ButtonOption name="searchImmobilie" accesskey="s" permitId="1" tabindex="2"><%= show.session.getButton1() %></dalie:ButtonOption>
								<dalie:ButtonOption name="newImmobilie" accesskey="a" permitId="3" tabindex="3"><%= show.session.getButton2() %></dalie:ButtonOption>
							</td>
						</tr>
					</tbody>
				</table>
	       	</div> <!-- yui-u first -->
	    	<div class="yui-u">
			<!-- 3.Zeile rechte hälfte --> 
	    			3.2
	       	</div><!-- yui-u --> 
		</div><!-- yui-g 2.Zeile gesamte Breite  -->
		<div class="yui-g">
		<!-- 4.Zeile gesamte Breite  -->  
			<dalie:Immo001FITag data="N" columnHeader='<%= new Immo001H().valueOf("1",language,immobilienOrderByTyp)%>' tableTagClass="iFrameTableTyp1"></dalie:Immo001FITag>
			<iframe src="<%= request.getContextPath()%>/selinas/immo/immo001F.jsp" width="100%" name="selinas" frameborder="0" height="99%" class="iFrame"></iframe>
		</div><!-- /yui-g 1.Zeile gesamte Breite --> 
	</div><!-- /bd body -->
	</div><!-- /doc3 = 100%, -->
   	<div id="ft">
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
					<a class="url fn" href="http://www.dalieonline.de">Contact Us.</a> | <a class="email" href="mailto:dalie@dalieweb.de">Schreiben</a>&nbsp;Sie mir!
				</div><!-- /vcard -->
			</div><!-- /meta-wrap -->
	</div><!-- /ft footer -->
</body>
</html>
