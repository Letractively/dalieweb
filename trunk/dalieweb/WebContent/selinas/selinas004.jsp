<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	import="database.dateien.Selinas"
	import="selinas.bean.SelinasSession"
	import="selinas.table.Selinas004H"
	import="selinas.SelinasUser"
	import="database.dateien.Dokument"
	import="database.dateien.Link"
	import="database.dateien.Typ"
	contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!-- onwn TagLib-Direktive -->
<%@ taglib uri="/WEB-INF/TagLibraryDescriptor.tld" prefix="dalie"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!-- MetaData -->
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=ISO-8859-1"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta name="keywords" content="dalieweb"/>
<meta name="author" content="u.dalies"/>
<!-- CSS und Icons --> 
<link href="<%= request.getContextPath()%>/theme/selinas004.css" rel="stylesheet" type="text/css" media="screen"/>
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
	Typ typ = (Typ)session.getAttribute("Typ");
	String language = (String) session.getAttribute("Speech");
	String languageFCKedtitor = language.toLowerCase();
	String modus = (String)session.getAttribute("Modus");
	String upload = (String) session.getAttribute("UpLoadOn");
	String memoLoad = (String)session.getAttribute("MemoLoad");
	String dokumentOrderByTyp = (String)session.getAttribute("DokumentOrderByTyp");//SessionAttribut:sort by Dokument
	String linkOrderByTyp = (String)session.getAttribute("LinkOrderByTyp");//SessionAttribut:sort by Link
	Link linkOfDokument = new Link();
	if (session.getAttribute("LinkOfDokument")!= null){
		linkOfDokument = (Link) session.getAttribute("LinkOfDokument"); 
	}
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
				<td valign="middle" align="right" class="strapline"><%= user.user.getName()%>, <%= user.user.getVorname()%>&nbsp; <a href="<%= request.getContextPath()%>/LogOffSelina" target="_self" class="link">Log off</a></td>
			</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
<form action="<%= request.getContextPath()%>/DokumentToProcessServlet" method="post">
<input type="hidden" name="dokumentTyp" value="<%= dokument.getTyp() %>" />
<input type="hidden" name="dokumentNr" value="<%= dokument.getNummer() %>" />
<input type="hidden" name="dokumentId" value="<%= dokument.getId() %>" />
		<div id="header">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<th width="100%" align="left" valign="middle">&nbsp;</th>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="3">
				<tr>
					<td width="15%" align="left">&nbsp;&nbsp;<em><%= show.session.getDokumentTyp() %> :</em></td><td width="35%" align="left"><strong><%= typ.getDescription() %></strong></td>
					<td width="15%" align="left"><em><%= show.session.getStatus() %> :</em></td><td width="35%" align="left" valign="middle">
							<dalie:SelectboxDokumentStatus name="Status" argument='<%=dokument.getStatus()%>' tabindex="7" ccsStyle="BOX"></dalie:SelectboxDokumentStatus>
							<a href="/dalieweb/Selinas004PermitInfo" title="<%= show.session.getLink5t() %>" target="_self" tabindex="22">
							<img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin5" alt='<%= show.session.getImage2() %>' title='<%= show.session.getImage2() %>'/></a></td>
				</tr>
				<tr>
					<td width="15%" align="left" valign="top">&nbsp;&nbsp;<em>Dokumenten-Nr. : </em></td><td width="35%" align="left" valign="top"><strong><%= dokument.getNummer() %>.<%= dokument.getId() %></strong></td>
					<td colspan="2" align="center"><!-- CLASS:HinweisOption --><dalie:HinweisOption message='${requestScope.permitInfo}'></dalie:HinweisOption><span innerhtml="test"></span></td>
				</tr>
			</table>
		</div><!-- /header -->
		<div id="wrapper">
			<br />
			<table width="99%" border="0" cellpadding="0" cellspacing="3" class="anforderungsdetails">
				<caption id="caption">Anforderungsdetails</caption>
				<tr>
					<td width="15%" align="left"><%= show.session.getGliederung() %></td><td width="35%" align="left"><dalie:InputOption name='<%= show.session.getGliederung() %>' value='<%=dokument.getGliederung() %>' tabindex="4"></dalie:InputOption></td>
					<td width="15%" align="left"><%= show.session.getArchiv() %></td><td width="35%" align="left"><dalie:InputOption name='<%= show.session.getArchiv() %>' value='<%=dokument.getArchiv() %>' tabindex="5"></dalie:InputOption></td>	
				</tr>
				<tr>
					<td width="15%" align="left"><%= show.session.getVorgabe() %></td><td width="35%" align="left"><dalie:InputOption name='<%= show.session.getVorgabe() %>' value='<%=dokument.getVorgabe() %>' tabindex="6"></dalie:InputOption></td>
				</tr>
			</table> 
			<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
				<tr>
					<td width="15%" align="left"><%= show.session.getTitel() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getTitel() %>' value='<%=dokument.getTitel() %>' tabindex="1" size="35" maxlength="50"></dalie:InputOption></td>
				</tr>
				<tr>
					<td width="15%" align="left"><%= show.session.getDescripten() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getDescripten() %>' value='<%=dokument.getDescripten() %>' tabindex="2" size="35" maxlength="60"></dalie:InputOption></td>
				</tr>
			</table> 
			<div id="contentLeft">
				<span>&nbsp;<%= show.session.getContent() %></span>
			</div><!-- /contentLeft -->
			<div id="contentRight"> 
				<FCK:editor instanceName="<%= show.session.getContent() %>" inputName="<%= show.session.getContent() %>" toolbarSet="Basic" value="<%= dokument.getContent() %>">
					<FCK:config AutoDetectLanguage="false" DefaultLanguage="en" />
					<FCK:config ToolbarStartExpanded="true" />
					<FCK:config ShowBorders="false" />
					<FCK:config SkinPath="skins/office2003/" />
				</FCK:editor>	
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><dalie:ButtonOption name="submit" accesskey="v" permitId="3" tabindex="8"><!-- Button:Dokument verarbeiten --><%= show.session.getButton8() %></dalie:ButtonOption></td>
						<td><dalie:ButtonOption name="copy" accesskey="k" permitId="3" tabindex="9"><!-- Button:Dokument kopieren --><%= show.session.getButton9() %></dalie:ButtonOption></td>
				   <!-- <td><dalie:ButtonOption name="link" accesskey="A" tabindex="10">Ihre <span style="text-decoration:underline">A</span>nlagen bearbeiten</dalie:ButtonOption></td> -->
						<td><dalie:ButtonOption name="print" accesskey="d" permitId="2" tabindex="11"><!-- Button:drucken --><%= show.session.getButton6() %></dalie:ButtonOption></td>
		 				<td><dalie:ButtonOption name="delete" accesskey="l" permitId="4" tabindex="12"><!-- Button:Dokument löschen --><%= show.session.getButton10() %></dalie:ButtonOption></td>
						<% if(modus.equalsIgnoreCase("update")){ %>
							<td><dalie:ButtonOption name="beenden" accesskey="e" tabindex="13" permitId="2"><!-- Button:beenden --><%= show.session.getButton2() %></dalie:ButtonOption></td>
						<% }/*endif*/ %>	
					</tr>
					<tr> 
						<td colspan="4" align="left"><!-- CLASS:HinweisOption --><dalie:HinweisOption message='${requestScope.Message}'></dalie:HinweisOption></td>
					</tr>
				</table>
			</div><!-- /contentRight -->
		</div><!-- /wrapper -->
</form>	
		<div id="upload">
			<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
				<tr>
					<td width="15%" align="left" valign="top">Anlagen</td>
					<td width="85%" align="left">
						<dalie:selinas004FLTag data="N" columnHeader='<%= new Selinas004H().valueOf("4",language,linkOrderByTyp) %>' tableTagClass="linkTable"></dalie:selinas004FLTag>
						<iframe src="<%= request.getContextPath()%>/selinas/selinas004FL.jsp" width="100%" name="selinas1" frameborder="0" height="100"></iframe>						
					</td>
				</tr>
				<% if(upload.equalsIgnoreCase("0")){ %> 
				<tr>
					<td width="15%" align="left" valign="top">&nbsp;</td>
					<td width="85%" align="left">
						<form action="<%= request.getContextPath()%>/GoToSelinas004Servlet" method="post">
							<dalie:ButtonOption name="upLoadOn" accesskey="s" permitId="3" tabindex="3"><!-- Button:upload starten --><%= show.session.getButton7() %></dalie:ButtonOption>
						</form>							
					</td>
				</tr>
				<% }/*endif*/ %>				
				<% if(upload.equalsIgnoreCase("1")){ %> 
				<tr>
					<td width="15%" align="left"><%= show.session.getCaption9() %></td>
					<td width="85%" align="left" valign="bottom">
						<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
							<tr>
								<td nowrap="nowrap"  valign="bottom">
									<form action="<%= request.getContextPath()%>/Selinas004Upload" enctype="multipart/form-data" method="post">
									<input type="file" name="myFile" tabindex='2' maxlength="255" class="file"/>
									<dalie:ButtonOption name="submit" accesskey="s" permitId="3" tabindex="3"><!-- Button:upload starten --><%= show.session.getButton7() %></dalie:ButtonOption>
									</form>
								</td>	
								<td align="left" valign="bottom">
									<form action="<%= request.getContextPath()%>/GoToSelinas004Servlet" method="post">
									<dalie:ButtonOption name="upLoadOn" accesskey="s" tabindex="3"><!-- Button:beenden --><%= show.session.getButton2() %></dalie:ButtonOption>
									</form>
								</td>	
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="15%" align="left" valign="top">&nbsp;</td>
					<td width="85%" align="left">
						<dalie:HinweisOption message='${requestScope.upload}'></dalie:HinweisOption><!-- CLASS:HinweisOption --></td>
				</tr>
				<% }/*endif*/ %>
				<% if(memoLoad.equalsIgnoreCase("memoLoadOn")){ %> 
				<tr>
					<td width="15%" align="left"><%= show.session.getCaption10() %></td>
					<td width="85%" align="left" valign="bottom">
						<form action="<%= request.getContextPath()%>/GoToSelinas004Servlet" method="post">
						<input type="hidden" name="ApplicationsId" value="<%= linkOfDokument.getApplicationsId() %>" />
						<table style="border-style: solid; 
							border-top-width: 1px; 
							border-right-width: 1px; 
							border-left-width: 1px; 
							border-bottom-width: 1px; 
							border-color: #557AA6;" width="99%" border="0" cellpadding="0" cellspacing="5" class="details">
							<tr>
								<td nowrap="nowrap"  valign="bottom">
								<dalie:InputOption name='memo' value='<%= linkOfDokument.getNotizOfLink() %>' tabindex="6" size="38"></dalie:InputOption>
								</td>	
								<td align="left" valign="bottom">
									<dalie:ButtonOption name="memoLoadOFF" accesskey="s" tabindex="3"><!-- Button:beenden --><%= show.session.getButton2() %></dalie:ButtonOption>
								</td>	
							</tr>
						</table>
						</form>
					</td>
				</tr>
				<% }/*endif*/ %>
			</table> 
		</div><!-- /upload -->
		<div id="footer">
		</div><!-- /footer -->	
		<div id="navigationDetail">
			<dalie:selinas004FDTag data="N" columnHeader='<%= new Selinas004H().valueOf("1",language,dokumentOrderByTyp) %>' tableTagClass="linkTable"></dalie:selinas004FDTag>
			<iframe src="<%= request.getContextPath()%>/selinas/selinas004FD.jsp" width="100%" name="selinas2" frameborder="0" height="100"></iframe>
		</div><!-- /navigationDetail -->
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