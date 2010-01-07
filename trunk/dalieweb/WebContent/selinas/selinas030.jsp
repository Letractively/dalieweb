<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	import="selinas.bean.SelinasSession"
	import="selinas.ColumHeader"
	import="selinas.SelinasUser"
	import="database.dateien.Adresse"
	import="database.dateien.Selinas"
	import="database.dateien.User"
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
<link href="<%= request.getContextPath()%>/theme/selinas030.css" rel="stylesheet" type="text/css" media="screen"/>
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
	User showUser = (User)session.getAttribute("ShowUser");
	Adresse adresse = (Adresse)session.getAttribute("Adresse");
	String language = (String)session.getAttribute("Speech");
	String userOrderByTyp = (String)session.getAttribute("UserOrderByTyp");//SessionAttribut:sort by Typ
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
						<td valign="bottom" align="left"><img src='<%= request.getContextPath()%>/bilder/spacer.gif' class="admin4" alt='<%= show.session.getImage5() %>' title='<%= show.session.getImage5() %>'/></td><td valign="middle" align="left"><a href="/dalieweb/GoToSelinas030Servlet" title="<%= show.session.getLink6t() %>" target="_self" class="linkNav"><span class="linkNav"><%= show.session.getLink6() %></span></a></td>
						</tr>
					</table>	
				</td>
			</tr>
		</table>
		<div id="header">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<th width="100%" align="left" valign="middle"><!-- Verwaltung Dokumenttypen --><%= show.session.getCaption4() %></th>
				</tr>
			</table>
		</div><!-- /header -->
		<div id="wrapper">
			<br />
			<div id="navigationDetail">
			<dalie:selinas030FUTag data="N" columnHeader='<%= ColumHeader.valueOf("8",language,userOrderByTyp) %>' tableTagClass="anforderungsdetails"></dalie:selinas030FUTag>
				<iframe src="<%= request.getContextPath()%>/selinas/selinas030FU.jsp" width="100%" name="selinas2" frameborder="0" height="160"></iframe>
		</div><!-- /navigationDetail -->
		<br />
<form action="/dalieweb/UserToProcessServlet" method="post">
<input type="hidden" name="<%= show.session.getUserId() %>" value="<%= showUser.getUserId() %>" />
<input type="hidden" name="<%= show.session.getAdressUserId() %>" value="<%= showUser.getUserId() %>" />
<input type="hidden" name="AdressTyp" value="U" />
				<table style="border-style: solid; border-top-width: 1px; border-right-width: 1px; border-left-width: 1px; border-bottom-width: 0px; border-color: #557AA6;"
				width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
				<tr>
				<td style="border-style: solid; border-top-width: 0px; border-right-width: 0px; border-left-width: 0px; border-bottom-width: 1px; border-color: #557AA6; padding-left: 5px;" 
					colspan="2" align="left">
						<strong><em><%= showUser.getUserId() %>&nbsp;-&nbsp;<%= showUser.getName() %>,<%= showUser.getVorname() %></em></strong>
				</td>
				</tr>
				<tr>
					<td align="left" valign="top"><!--1.Spalte  -->
						<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
							<caption style="text-align: left; font: bold 10px Helvetica, sans-serif; margin-left: 3px;"><!-- Benutzerangaben: --><%= show.session.getCaption5() %></caption>
							<tr>
								<td align="left"><%= show.session.getPermitId() %></td><td align="left"><dalie:Selectbox name="PermitId" argument='<%= (new Integer(showUser.getPermitId())).toString() %>' ccsStyle="selectbox" permitId="5"></dalie:Selectbox></td>
							</tr>
							<tr>
								<td align="left"><%= show.session.getUserAppId() %></td><td align="left"><dalie:Selectbox name="AutorisierungId" argument='<%= (new Integer(showUser.getUserAutorisierungsId())).toString() %>' ccsStyle="selectbox" permitId="5"></dalie:Selectbox></td>
							</tr>
							<tr>
								<td align="left"><%= show.session.getName() %></td><td align="left"><dalie:InputOption name='<%= show.session.getName() %>' value='<%= showUser.getName() %>' tabindex="2"></dalie:InputOption></td>
							</tr>
							<tr>
								<td align="left"><%= show.session.getVorname() %></td><td align="left"><dalie:InputOption name='<%= show.session.getVorname() %>' value='<%= showUser.getVorname() %>' tabindex="3"></dalie:InputOption></td>
							</tr>
							<tr>
								<td align="left"><%= show.session.getStatus() %></td><td align="left"><dalie:Selectbox name="Status" argument='<%= showUser.getUserStatus() %>' ccsStyle="selectbox" permitId="5"></dalie:Selectbox></td>
							</tr>
						</table>
						<table border="0" cellpadding="0" cellspacing="4" class=""><tr><th>&nbsp;</th></tr></table>
						<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
							<caption style="text-align: left; font: bold 10px Helvetica, sans-serif; margin-left: 3px;"><!-- Passwort: --><%= show.session.getCaption7() %></caption>
							<tr>
								<td align="left"><%= show.session.getPassword() %></td><td align="left"><dalie:InputOption type="password" name='<%= show.session.getPassword() %>' value='<%= showUser.getPassword() %>' tabindex="5" size="10"></dalie:InputOption></td>
							</tr>
							<tr>
								<td align="left"><%= show.session.getPasswordchek() %></td><td align="left"><dalie:InputOption type="password" name='<%= show.session.getPasswordchek() %>' value='<%= showUser.getPassword() %>' tabindex="6" size="10"></dalie:InputOption></td>
							</tr>
						</table>
					</td>
					<td align="left" valign="top"><!-- 2.Spalte --> 
						<table width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
							<caption style="text-align: left; font: bold 10px Helvetica, sans-serif; margin-left: 3px;"><!-- Adresse: --><%= show.session.getCaption6() %></caption>
							<tr>
								<td align="left"><%= show.session.getStrasse() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getStrasse() %>' value='<%= adresse.getStrasse() %>' tabindex="7" size="30"></dalie:InputOption></td>
							</tr>
							<tr>
								<td width="15%" align="left"><%= show.session.getNummer() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getNummer() %>' value='<%= adresse.getNummer() %>' tabindex="8"></dalie:InputOption></td>
							</tr>
							<tr>
								<td width="15%" align="left"><%= show.session.getPlz() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getPlz() %>' value='<%= adresse.getPlz() %>' tabindex="9"></dalie:InputOption></td>
							</tr>
							<tr>
								<td width="15%" align="left"><%= show.session.getOrt() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getOrt() %>' value='<%= adresse.getOrt() %>' tabindex="10" size="30"></dalie:InputOption></td>
							</tr>
							<tr>
								<td width="15%" align="left"><%= show.session.getLand() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getLand() %>' value='<%= adresse.getLand() %>' tabindex="10" size="30"></dalie:InputOption></td>
							</tr>
							<tr>
								<td width="15%" align="left">&nbsp;</td><td width="35%" align="left">&nbsp;</td>
							</tr>	
							<tr>
								<td width="15%" align="left"><%= show.session.getMail() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getMail() %>' value='<%= adresse.getMail() %>' tabindex="11"></dalie:InputOption></td>
							</tr>
							<tr>
								<td width="15%" align="left"><%= show.session.getTelefon() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getTelefon() %>' value='<%= adresse.getTelefon() %>' tabindex="12"></dalie:InputOption></td>
							</tr>
							<tr>
								<td width="15%" align="left"><%= show.session.getFax() %></td><td width="85%" align="left"><dalie:InputOption name='<%= show.session.getFax() %>' value='<%= adresse.getFax() %>' tabindex="13"></dalie:InputOption></td>
							</tr>
						</table> 
					</td>
				</tr>
			</table>
			<table style="border-style: solid; border-top-width: 0px; border-right-width: 1px; border-left-width: 1px; border-bottom-width: 0px; border-color: #557AA6;" 
				width="99%" border="0" cellpadding="0" cellspacing="3" class="details">
				<tr>
					<td align="left"><dalie:ButtonOption name="submit" accesskey="s" permitId="3" tabindex="14"><!-- Button:Verarbeitung starten --><%= show.session.getButton1() %></dalie:ButtonOption>
					<dalie:ButtonOption name="delete" accesskey="l" permitId="4" tabindex="15"><!-- Button:Dokumenttyp löschen --><%= show.session.getButton14() %></dalie:ButtonOption>
					<dalie:ButtonOption name="new" accesskey="n" permitId="3" tabindex="16"><!-- Button:Dokumenttyp anlegen --><%= show.session.getButton15() %></dalie:ButtonOption>
					<dalie:ButtonOption name="beenden" accesskey="e" tabindex="17" permitId="2"><!-- Button:beenden --><%= show.session.getButton2() %></dalie:ButtonOption>
					</td> 
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
