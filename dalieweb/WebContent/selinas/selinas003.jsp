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
		Dokument dokument = (Dokument) session.getAttribute("Dokument");
		String language = (String) session.getAttribute("Speech");
		String upload = (String) session.getAttribute("UpLoadOn");
%>
<div id="page"> 
	<div id="pageHeader">
		<a href="<%= request.getContextPath()%>/dalieweb.jsp" target="_self">
		<img src="<%= request.getContextPath()%>/bilder/pfeilmit01.gif" width="60" height="60" alt="" name="ani" title="dalieweb" class="logo"/></a>
		<span class="strapline">dalieweb.de</span>
	</div><!-- /pageHeader -->
	<div id="pageWrapper">
		<table border="0" cellspacing="0" cellpadding="0" width="99%">
		<tr>
			<td valign="middle" align="left"></td>
			<td valign="middle" align="right" class="strapline"><%= user.user.getName()%>, <%= user.user.getVorname()%>&nbsp; <a href="<%= request.getContextPath()%>/LogOffSelina" target="_self" class="link">Log off</a></td>
		</tr>
		</table>
		<div id="navigation">
			<dalie:DokumentNavTag current="<%= dokument.getDokumentTyp() %>"></dalie:DokumentNavTag>
		</div><!-- /navigation -->
		<div id="header">
			<table width='100%' border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="right" valign="middle" width="3%" rowspan="3">&nbsp;<img src="<%= request.getContextPath()%>/bilder/spacer.gif" class="requests" width="21" height="22" hspace="8" vspace="8" alt="dokument"/></td>
				<td align="left" valign="top"> <span class='fontMediumBold'><%= dokument.getTitel()%> </span></td>
			</tr>
			<tr>
				<td><span class='fontNormal'><em>Dokumenten-Nr. : </em><%= dokument.getNummer()%>.<%= dokument.getId()%></span></td>
			</tr>
		</table>
		</div><!-- /header -->
		<div id="wrapper">
			<div id="contentLeft">	
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
            	<tr>
					<th><span class="fontBlack"> Requested by </span><span class="fontBlackBold">Uwe Dalies</span></th>
            	</tr>
              	<tr>
        			<td height="0" valign="top">
                		<table width="100%" border="0" cellpadding="0" cellspacing="0">
                     		<tr>
                      			<td class="subheading1"><strong>Beschreibung:</strong></td>
								<td class="subheading1"><strong>Gliederung:</strong></td>
                     		</tr>
							<tr>
                	    		<td valign="middle" class="fontBlack"><%= dokument.getDescripten()%></td>
								<td valign="middle" class="fontBlack"><%= dokument.getGliederung() %></td>
                    		</tr>
                    		<tr>
            	        		<td class="subheading1"><strong>Inhalt:</strong></td>
								<td class="subheading1">&nbsp;</td>
      						</tr>
						</table>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
        					<tr>
        						<td><textarea name="text" class="requestText" readonly="readonly" ><%= dokument.getContent()%></textarea></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td class="subheading2">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<form action="<%= request.getContextPath()%>/DokumentToWorkServlet" method="post">
									<input type="hidden" name="kundenId" value="<%= dokument.getKundenId() %>" />
									<input type="hidden" name="standortId" value="<%= dokument.getStandortId() %>" />
									<input type="hidden" name="dokumentTyp" value="<%= dokument.getDokumentTyp() %>" /> 
									<input type="hidden" name="dokumentNr" value="<%= dokument.getNummer() %>" /> 
									<input type="hidden" name="dokumentId" value="<%= dokument.getId() %>" /> 
									<dalie:ButtonOption name="submit" accesskey="b" tabindex="1">Dokument <span style="text-decoration:underline">b</span>earbeiten</dalie:ButtonOption>
									</form>
								</td>
								<td>
									<form action="/dalieweb/DokumentToReportServlet" method="post">
									<dalie:ButtonOption name="print" accesskey="d" tabindex="1">Dokument <span style="text-decoration:underline">d</span>rucken</dalie:ButtonOption>
									</form>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</div><!-- /contentLeft -->
			<div id="contentRight">	
				<dalie:DokumentLinkTag data="N" columnHeader='<%= ColumHeader.valueOf("2",language) %>' tableTagClass="linkTable"></dalie:DokumentLinkTag>
				<iframe src="<%= request.getContextPath()%>/selinas/selinas003FL.jsp" width="100%" name="selinas2" frameborder="0" height="221"></iframe>						
					<table border="0" cellpadding="0" cellspacing="0" width="100%">	
						<tr>
							<td class="subheading3">
								<form action="<%= request.getContextPath()%>/GoToSelinas003Servlet" method="post">
									<input type="hidden" name="upLoadOn" value="1" />
									<% if(upload.equalsIgnoreCase("0")){ %> 
										<dalie:ButtonOption name="upload" accesskey="s" tabindex="3">Upload <span style="text-decoration:underline">s</span>tarten</dalie:ButtonOption>
									<% }else{%>
										<dalie:ButtonOption name="upload" accesskey="e" tabindex="3">Be<span style="text-decoration:underline">e</span>nden</dalie:ButtonOption>
									<% }/*endif*/ %>
								</form>		
							</td>
						</tr>
					</table>		
			</div><!-- /contentRight -->
		</div><!-- wrapper -->
		<div id="footer">
			<% if(upload.equalsIgnoreCase("1")){ %> 
			<table border="0" cellpadding="0" cellspacing="0" width="99%">	
				<tr>
					<td>
								<form action="<%= request.getContextPath()%>/DokumentUploadServlet" enctype="multipart/form-data" method="post">
								<input type="file" name="myFile" tabindex='2' maxlength="255" class="file"/>
								<dalie:ButtonOption name="submit" accesskey="s" tabindex="3">Upload <span style="text-decoration:underline">s</span>tarten</dalie:ButtonOption>
								</form>		
					</td>
				</tr>
				<tr>
					<td><dalie:HinweisOption message='${requestScope.upload}'></dalie:HinweisOption><!-- CLASS:HinweisOption --></td>
				</tr>
			</table>
			<% }/*endif*/ %>	
		</div><!-- /footer -->	
		<div id="navigationDetail">
			<dalie:DokumentTypTag data="N" columnHeader='<%= ColumHeader.valueOf("1",language) %>' typ='<%= dokument.getDokumentTyp() %>' tableTagClass="linkTable"></dalie:DokumentTypTag>
			<iframe src="<%= request.getContextPath()%>/selinas/selinas003FD.jsp" width="100%" name="selinas1" frameborder="0" height="100"></iframe>
		</div><!-- /navigationDetail -->
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
