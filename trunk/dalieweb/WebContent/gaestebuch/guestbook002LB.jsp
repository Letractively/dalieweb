<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
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
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<style type="text/css">
.lightbox {
	color: #333;
	display: none;
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

#overlay{
	display:none;
	position:absolute;
	top:0;
	left:0;
	width:100%;
	height:100%;
	z-index:1000;
	background-color:#333;
	/*-moz-opacity: 0.8;*/
	opacity:.80;
	filter: alpha(opacity=80);
}
.footer	{
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript"></script>
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<script src="<%= request.getContextPath()%>/script/prototype.js" type="text/javascript"></script>
<script src="<%= request.getContextPath()%>/script/lightbox.js" type="text/javascript"></script>
<script type="text/javascript">

	jQuery(window).ready(function() {
		if (jQuery('a[href=#lightbox2]').size() > 0) {

			jQuery('a[href=#lightbox2]').live();
		}
	});
</script>
<title>dalieweb</title>
</head>
<body>
	<p><a href="#lightbox2" rel="lightbox2" class="lbOn">Open Lightbox with CSS and JS</a></p>
	<div id="lightbox2" class="lightbox">
	<p class="footer">
		<a href="#" class="lbAction" rel="deactivate">x</a>
	</p>

	<h1>Lightbox</h1>

	<p> Lorem ipsum dolor sit amet, consectetuer adipiscing elit. 
	Donec aliquet. Donec sit amet elit at nisl commodo pellentesque. 
	Proin vel odio. Proin vitae mi eu libero consequat rhoncus. 
	Pellentesque aliquam varius purus. 
	Etiam ac mauris sit amet purus facilisis dapibus. 
	Nulla tellus. 
	In aliquam sem. 
	Duis nisi velit, scelerisque egestas, feugiat id, suscipit et, mi. 
	Vestibulum id erat eu enim nonummy fringilla.</p>
</div>
</body>
</html>