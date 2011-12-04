<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<!-- CSS and Icons --> 
<link href="http://yui.yahooapis.com/2.9.0/build/base/base-min.css" rel="stylesheet" type="text/css"/>
<link href="http://yui.yahooapis.com/2.9.0/build/reset-fonts-grids/reset-fonts-grids.css" rel="stylesheet" type="text/css"/>
<script src="http://www.google.com/jsapi" type="text/javascript"></script>
<script type="text/javascript">
	google.load("jquery","1.7");
</script>
<script src="<%=request.getContextPath()%>/script/dalieSite.js" type="text/javascript"></script>
<title>Lightbox-Demo</title>
</head>
<body>
	<br /><br /><br />
	<div id="targetDIV">
	<form id="StartLightbox" name="StartLightbox" target="targetDIV" action="">
		<input id="refresh" type="hidden" value="refresh"/>
		<input id="apply" class="ajaxInput" type="button" value="Start Lightbox"/>
	</form>
	</div>
</body>
</html>