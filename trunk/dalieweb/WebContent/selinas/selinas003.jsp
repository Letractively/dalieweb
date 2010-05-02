<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	import="database.dateien.Selinas"
	import="selinas.bean.SelinasSession"
	import="selinas.table.Selinas003H"
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
<link href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/> 
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
		String dokumentOrderByTyp = (String)session.getAttribute("DokumentOrderByTyp");//SessionAttribut:sort by Dokument
		String linkOrderByTyp = (String)session.getAttribute("LinkOrderByTyp");//SessionAttribut:sort by Link
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
		<div id="navigationWrapper">
		<div id="navigationLeft">
			<div id="navigation">
				<dalie:DokumentNavTag current="<%= dokument %>"></dalie:DokumentNavTag>
			</div><!-- /navigation -->
		</div><!-- /navigationLeft -->
		<div id="navigationRight">
			<table width='100%' border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="right" valign="top" width="3%" rowspan="2">&nbsp;<img src="<%= request.getContextPath()%>/bilder/spacer.gif" class="requests" width="21" height="22" hspace="8" vspace="8" alt="dokument"/></td>
				<td align="left" valign="bottom"> <span class='fontMediumBold'><%= dokument.getTitel()%> </span></td>
			</tr>
			<tr>
				<td><span class='fontNormal'><em>Dokumenten-Nr. : </em><%= dokument.getNummer()%>.<%= dokument.getId()%></span></td>
			</tr>
		</table>
		</div><!-- /navigationRight -->
		<div id="navigationFooter">
			
		</div><!-- navigationFooter -->
		</div><!-- /navigationWrapper -->
		<div id="header">
		</div><!-- /header -->
		<div id="wrapper">
			<div id="contentLeft">	
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
            	<tr>
					<th>&nbsp;<img src='/dalieweb/bilder/arrow.gif'alt="Ihre Angaben zum Dokument" title="Ihre Angaben zum Dokument"/><span class="fontBlack">Details</span></th>
            	</tr>
              	<tr>
        			<td height="0" valign="top">
                		<table width="100%" border="0" cellpadding="0" cellspacing="0">
                     		<tr>
                      			<td class="subheading1"><strong><%= show.session.getDescripten() %>:</strong></td>
								<td class="subheading1"><strong><%= show.session.getGliederung() %>:</strong></td>
                     		</tr>
							<tr>
                	    		<td valign="middle" class="fontBlack"><%= dokument.getDescripten()%></td>
								<td valign="middle" class="fontBlack"><%= dokument.getGliederung() %></td>
                    		</tr>
                    		<tr>
            	        		<td class="subheading1"><strong><%= show.session.getContent() %>:</strong></td>
								<td class="subheading1">&nbsp;</td>
      						</tr>
						</table>
					</td>
				</tr>
              	<tr>
					<td style="padding-top: 5px;">	
						<iframe src="<%= request.getContextPath()%>/selinas/selinas003FC.jsp" width="100%" name="xxx" frameborder="0" height="150" align="left" marginwidth="2" marginheight="0"></iframe>						
					</td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td class="subheading2">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<form action="<%= request.getContextPath()%>/GoToSelinas003Servlet" method="post">
									<input type="hidden" name="kundenId" value="<%= dokument.getKundenId() %>" />
									<input type="hidden" name="standortId" value="<%= dokument.getStandortId() %>" />
									<input type="hidden" name="dokumentTyp" value="<%= dokument.getTyp() %>" /> 
									<input type="hidden" name="dokumentNr" value="<%= dokument.getNummer() %>" /> 
									<input type="hidden" name="dokumentId" value="<%= dokument.getId() %>" /> 
									<dalie:ButtonOption name="back" accesskey="r" permitId="1" tabindex="1"><!-- Button:backward --><%= show.session.getButton3() %></dalie:ButtonOption>
									</form>		
								</td>
								<td>
									<form action="<%= request.getContextPath()%>/DokumentToWorkServlet" method="post">
									<input type="hidden" name="kundenId" value="<%= dokument.getKundenId() %>" />
									<input type="hidden" name="standortId" value="<%= dokument.getStandortId() %>" />
									<input type="hidden" name="dokumentTyp" value="<%= dokument.getTyp() %>" /> 
									<input type="hidden" name="dokumentNr" value="<%= dokument.getNummer() %>" /> 
									<input type="hidden" name="dokumentId" value="<%= dokument.getId() %>" /> 
									<dalie:ButtonOption name="submit" accesskey="b" permitId="3" tabindex="2"><!-- Button:bearbeiten --><%= show.session.getButton4() %></dalie:ButtonOption>
									</form>
								</td>
								<td>
									<form action="<%= request.getContextPath()%>/GoToSelinas003Servlet" method="post">
									<input type="hidden" name="kundenId" value="<%= dokument.getKundenId() %>" />
									<input type="hidden" name="standortId" value="<%= dokument.getStandortId() %>" />
									<input type="hidden" name="dokumentTyp" value="<%= dokument.getTyp() %>" /> 
									<input type="hidden" name="dokumentNr" value="<%= dokument.getNummer() %>" /> 
									<input type="hidden" name="dokumentId" value="<%= dokument.getId() %>" /> 
									<dalie:ButtonOption name="next" accesskey="n" permitId="1" tabindex="3"><!-- Button:forward --><%= show.session.getButton5() %></dalie:ButtonOption>
									</form>		
								</td>
								<td>
									<form action="<%= request.getContextPath()%>/DokumentToReportServlet" method="post">
									<dalie:ButtonOption name="print" accesskey="d" permitId="2" tabindex="4"><!-- Button:drucken --><%= show.session.getButton6() %></dalie:ButtonOption>
									</form>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</div><!-- /contentLeft -->
			<div id="contentRight">	
				<dalie:DokumentLinkTag data="N" columnHeader='<%= new Selinas003H().valueOf("3",language,linkOrderByTyp) %>' tableTagClass="linkTable"></dalie:DokumentLinkTag>
				<iframe src="<%= request.getContextPath()%>/selinas/selinas003FL.jsp" width="100%" name="selinas2" frameborder="0" height="221"></iframe>						
					<table border="0" cellpadding="0" cellspacing="0" width="100%">	
						<tr>
							<td class="subheading3">
								<form action="<%= request.getContextPath()%>/GoToSelinas003Servlet" method="post">
									<input type="hidden" name="upLoadOn" value="1" />
									<% if(upload.equalsIgnoreCase("0")){ %> 
										<dalie:ButtonOption name="upload" accesskey="s" permitId="3" tabindex="3"><!-- Button:Upload starten --><%= show.session.getButton7() %></dalie:ButtonOption>
									<% }else{%>
										<dalie:ButtonOption name="upload" accesskey="e" permitId="3" tabindex="3"><!-- Button:beenden --><%= show.session.getButton2() %></dalie:ButtonOption>
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
								<form action="<%= request.getContextPath()%>/Selinas003Upload" enctype="multipart/form-data" method="post">
								<input type="file" name="myFile" tabindex='2' maxlength="255" class="file"/>
								<dalie:ButtonOption name="submit" accesskey="s" tabindex="3"><%= show.session.getButton7() %></dalie:ButtonOption>
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
			<dalie:DokumentTypTag data="N" columnHeader='<%= new Selinas003H().valueOf("1",language,dokumentOrderByTyp) %>' tableTagClass="linkTable"></dalie:DokumentTypTag>
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
