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
<link href="<%= request.getContextPath()%>/theme/selinas003.css" rel="stylesheet" type="text/css" media="screen"/>
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
%>
<div id="page">
	<div id="pageHeader">
		<a href="http://www.dalieweb.de/" target="_self">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
		<span class="strapline">dalieweb.de</span>
	</div><!-- /pageHeader -->
	<div id="pageWrapper">
		<div class="logOf">
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td valign="middle" align="left">&nbsp;</td>
			<td valign="middle" align="right" class="strapline"><%= user.user.getName() %>, <%= user.user.getVorname() %>&nbsp; <a href="<%= request.getContextPath()%>/LogOffSelina" target="_self">Log off</a></td>
		</tr>
		</table>
	</div>
		<div id="dokumentHeader">
			<br />
			<table width='100%' border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td align="left" valign="top" width="2%" rowspan="2">&nbsp;<img src="<%= request.getContextPath()%>/bilder/spacer.gif" class="requests" width="21" height="22" hspace="8" vspace="8" alt="requests"/></td>
				<td align="left" valign="middle"> <span class='fontMediumBold'><%= dokument.getTitel() %> </span></td>
			</tr>
			<tr>
				<td><span class='fontNormal'><em>Dokumenten-Nr. : </em><%= dokument.getNummer() %>.<%= dokument.getId() %></span></td>
			</tr>
		</table>
			<br />
		</div><!-- /dokumentHeader -->
		<div id="wrapper">
			 <table width="100%" border="0" cellspacing="0" cellpadding="0"  class="requestBox">
                <tr>
                  <td id="topbg"><span class="fontBlack"> Requested by </span><span class="fontBlackBold">Uwe Dalies</span></td>
              </tr>
              <tr>
        	<td height="0" valign="top">
                <table width="100%" border="0" cellpadding="4" cellspacing="0">
                     <tr>
                      	<td class="subheading"><strong>Betreff:</strong></td>
                     </tr>
					<tr>
                	    <td colspan="3" valign="middle" class="fontBlack"><p><%= dokument.getDescripten() %></p></td>
                    </tr>
                    <tr>
            	        <td class="subheading"><strong>Inhalt:</strong></td>
      				</tr>
        			<tr>
        				<td colspan="3" valign="middle" class="fontBlack"> <p><%= dokument.getContent() %></p></td>
       				</tr>
					<tr>
        				<td colspan="3" valign="top" id="bottombg">Hallo</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
		<br />
			<div id="content">	
				<dalie:DokumentLinkTag data="N" columnHeader='<%= ColumHeader.valueOf("2") %>' tableTagClass="linkTable"></dalie:DokumentLinkTag>
					<iframe src="<%= request.getContextPath()%>/selinas/selinas003FL.jsp" width="100%" name="selinas2" frameborder="0"></iframe>
				<form action="<%= request.getContextPath()%>/DokumentUploadServlet" enctype="multipart/form-data" method="post">
					<table>
						<tr>
							<th><input type="file" name="myFile" tabindex='7' maxlength="255"/></th>
						<th>
							<dalie:ButtonOption name="submit" accesskey="s" tabindex="8">Upload <span style="text-decoration:underline">s</span>tarten</dalie:ButtonOption>		
						</th>
					</tr>
				</table>
				<dalie:HinweisOption message='${requestScope.upload}'></dalie:HinweisOption><!-- CLASS:HinweisOption -->
				</form>
			</div><!-- /content -->
			<div id="contentRight">	
				<p>contentRight</p>
			</div><!-- /contentRight -->
		</div><!-- wrapper -->
		<div id="footer">
			<dalie:DokumentTypTag data="N" columnHeader='<%= dokument.getDokumentTyp() %>' tableTagClass="linkTable"></dalie:DokumentTypTag>
			<iframe src="<%= request.getContextPath()%>/selinas/selinas003FD.jsp" width="100%" name="selinas1" frameborder="0"></iframe>
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
