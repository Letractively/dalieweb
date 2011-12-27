<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!-- own TagLib-Directive -->
<%@ taglib uri="/WEB-INF/TagLibraryDescriptor.tld" prefix="dalie"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
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
.lightbox {
      color: #333;
      /*display: none;*/
      position: absolute;
      top: 15%;
      left: 15%;
      width: 70%;
      height: 70%;
      padding: 1em;
      border-top: 0.5em solid #B8B8B8;
      border-right: 0.5em solid #B8B8B8;
      border-bottom: 0.5em solid #B8B8B8;
      border-left: 0.5em solid #B8B8B8;
      background-color: white;
      text-align: left;
      z-index:1001;
      overflow: auto;   
}

div.fullscreen {
      /*display:none;*/
      position:absolute;
      top:0;
      left:0;
      width:100%;
      height:100%;
      z-index:1000;
      background-color:#333;
      moz-opacity: 0.8;
      opacity:.80;
      filter: alpha(opacity=80);
}
.footer     {
      float:right;
      margin-right:6px;
      cursor:pointer;
}
</style>    
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/>
<!-- Script's  -->
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body>
<div id="background" class="background">
	<div id="fullscreen" class="fullscreen"></div>
	<div id="lightbox" class="lightbox">
		<div id="lb_close">
			<a href="javascript:void(0);" class="footer"> schliessen x</a>
		</div>
		<h1><b>Verfassen Sie Ihren Kommentar.</b></h1>
		<br />
		<br />

	<form id="GuestBookCaptuer" class="" style="" action="#">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" >
		<tr>
			<td>Name:</td>
			<td><dalie:InputOption name="Name" value='${GuestBook002LB.name}' permitId="3" tabindex="1"></dalie:InputOption></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><dalie:InputOption name="eMail" value='${GuestBook002LB.email}' permitId="3" tabindex="2"></dalie:InputOption></td>
		</tr>
		<tr>
			<td colspan="2">
				<FCK:editor instanceName="Commetary"
					inputName="Commentary" toolbarSet="Basic" value="${GuestBook002LB.content}"
					height="300px" width="600px">
				<FCK:config AutoDetectLanguage="false" DefaultLanguage="en" />
				<FCK:config ToolbarStartExpanded="true" />
				<FCK:config ShowBorders="false" />
				<FCK:config SkinPath="skins/office2003/" />
				</FCK:editor>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" name="FCKSubmit" id="FCKSubmit" value="Übernehmen" />
			</td>
		</tr>
		<tr>
			<td>${GuestBook002LB.message}</td>
		</tr>
	</table>
	</form>
	</div>
</div>
<script type="text/javascript">
	jQuery(function() {
		jQuery("#lb_close").click(closeLightbox);

	});
	function closeLightbox(){
		jQuery("#background").remove();
	}
	
	jQuery(function() {
		jQuery("#FCKSubmit").click(lightbox);

	});
	
	function showLightbox(text) {
		//alert(text);
		jQuery('#background').append(text);
	}
	function lightbox() {
		alert('Hello');
		jQuery.ajax({
			type : "GET",
			url : "/dalieweb/GoToGuestBookCapture",
			data : jQuery("#GuestBookCaptuer").serialize(),
			success : showLightbox
		});
	}
</script>
</body>
</html>