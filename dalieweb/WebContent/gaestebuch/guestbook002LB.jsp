<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
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

.lightbox {
      color: #333;
      /*display: none;*/
      position: absolute;
      top: 25%;
      left: 25%;
      width: 50%;
      height: 50%;
      padding: 1em;
      border: 1em solid #B8B8B8;
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
.lightbox[id]{ 
      /* IE6 and below Can't See This */    
      position:fixed;    
}
#overlay[id]{ 
      /* IE6 and below Can't See This */    
      position:fixed;    
}
</style>    
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb/xml/dalieweb.xml"/>
<!-- Script's  -->
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body>
	<div id="fullscreen" class="fullscreen">
	  <div id="lightbox" class="lightbox">
	  <div id="lb_close"><a href="javascript:void(0);" class="footer"> x</a></div>

	   <ul><li>1</li><li>2</li><li>3</li></ul>
      <h1><b>Lightbox</b></h1>
      <br /><br />
      <form name="GoToGuestBookCaptuer" id="GuestBookCaptuer" class="" style="" action="/dalieweb/GoToGuestBookCapturer">
      <FCK:editor instanceName="HelloWorld" inputName="HelloWorld" toolbarSet="Basic" value="HelloWorld">
					<FCK:config AutoDetectLanguage="false" DefaultLanguage="en" />
					<FCK:config ToolbarStartExpanded="true" />
					<FCK:config ShowBorders="false" />
					<FCK:config SkinPath="skins/office2003/" />
				</FCK:editor>
		<input type="submit" name="FCKSubmit" id="FCKSubmit" value="Übernehmen" />	
      </form>
      </div>
    </div>	
<script type="text/javascript">
	jQuery(function() {
		jQuery("#lb_close").click(closeLightbox);

	});
	function closeLightbox(){
		jQuery("#fullscreen").remove();
	}
</script>
</body>
</html>