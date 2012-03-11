<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!-- own TagLib-Directive -->
<%@ taglib uri="/WEB-INF/TagLibraryDescriptor.tld" prefix="dalie" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- MetaData -->
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=ISO-8859-1"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta name="keywords" content="dalieweb"/>
<meta name="author" content="u.dalies"/>
<!-- CSS and Icons --> 
<link href="<%= request.getContextPath()%>/build/base/base-min.css" rel="stylesheet" type="text/css"/>
<link href="<%= request.getContextPath()%>/build/reset-fonts-grids/reset-fonts-grids.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/theme/immo001.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="<%=request.getContextPath()%>/theme/dalieSite.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Script's  -->
<script src="http://code.jquery.com/jquery-1.6.2.min.js" type="text/javascript"></script>
<style type="text/css">

form {
	padding: 0px;
	margin: 0px;
	background-color: #F7F8FD;
}
td {
	border-color: #7F9DB9;
}
</style>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/>
<!-- Script's  -->
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body>
<div id="GuestBookCaptuer">
		<h1><b>Verfassen Sie Ihren Kommentar.</b></h1>
		<br />
		<br />
	<form id="GuestBookCaptuer" class="" style="" target="GuestBookCaptuer" action="./GoToGuestBookEntry">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" >
		<tr>
			<td>Name:</td>
			<td><dalie:InputOption name="Guestbook.EntryName" value='${GuestBookEntry.entryName}' permitId="3" tabindex="1"></dalie:InputOption></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><dalie:InputOption name="Guestbook.EntryEMail" value='${GuestBookEntry.entryEMail}' permitId="3" tabindex="2"></dalie:InputOption></td>
		</tr>
		<tr>
			<td colspan="2">
				<FCK:editor instanceName="Guestbook.EntryMessage" inputName="Guestbook.EntryMessage" toolbarSet="Basic" value="${GuestBookEntry.entryText}" height="300px" width="600px">
				<FCK:config AutoDetectLanguage="false" DefaultLanguage="en" />
				<FCK:config ToolbarStartExpanded="true" />
				<FCK:config ShowBorders="true" />
				<FCK:config SkinPath="skins/office2003/" />
				</FCK:editor>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" name="Guestbook.isSubmitted" id="Guestbook.isSubmitted" class="ajaxInput" value="Übernehmen" />
			</td>
		</tr>
	</table>
	</form>
<c:forEach var="message" items="${ GuestBookEntry.error }" > 
	<c:out value="${message}"></c:out><br />
</c:forEach>
</div>
</body>
</html>