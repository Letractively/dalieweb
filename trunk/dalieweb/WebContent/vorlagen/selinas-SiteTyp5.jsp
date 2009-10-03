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
<link href="<%= request.getContextPath()%>/theme/Master.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-SiteTyp5.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/Druck.css" rel="stylesheet" type="text/css" media="print"/>
<link href="http://www.dalieweb.de/pfeilmit01.ico" rel="shortcut icon" title="dalieweb" type="image/x-icon"/>
<!-- Definition RSS Feed -->
<link rel="alternate" type="application/rss+xml" title="dalieweb.de RSS-Feed" href="http://www.dalieweb.de/dalieweb.xml"/> 
<!-- Script's  -->
<script src="<%= request.getContextPath()%>/script/dalieLogo.js" type="text/javascript"></script>
<title>dalieweb</title>
</head>
<body>
<div id="page">
	<div id="pageHeader"><p>Platz für Logo</p></div><!-- pageHeader -->
	<div id="pageContentWrapper">
		<div id="pageContent"><p>pageContentLeft</p></div><!-- pageContent -->
		<div id="pageContentRight">
		<div id="wrapper">
	<div id="header">
		<h1>Header</h1>
			<div id="headerMenu">
				<ul>
					<li><a href="selinas-SiteTyp1.jsp">SiteTyp 1</a></li>
					<li><a href="selinas-SiteTyp2.jsp">SiteTyp 2</a></li>
					<li><a href="selinas-SiteTyp3.jsp">SiteTyp 3</a></li>
					<li><a href="selinas-SiteTyp4.jsp">SiteTyp 4</a></li>
					<li><a class="on" href="selinas-SiteTyp4.jsp">SiteTyp 5</a></li>
					<li><a href="selinas-SiteTyp6.jsp">SiteTyp 6</a></li>
				</ul>
			</div><!-- headerMenu -->
	</div><!-- header -->
	<div id="wrapperContent">
	<div id="content">		
		<h2>Content!</h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
		<p>Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus.</p>
		<h3>Et harum quidem rerum</h3>
		<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
	</div><!-- content -->
	<div id="contentRight">	
		<h2>Content Right</h2>
		<ul>
					<li><a href="selinas-SiteTyp1.jsp">SiteTyp 1</a></li>
					<li><a href="selinas-SiteTyp2.jsp">SiteTyp 2</a></li>
					<li><a href="selinas-SiteTyp3.jsp">SiteTyp 3</a></li>
					<li><a href="selinas-SiteTyp4.jsp">SiteTyp 4</a></li>
					<li><a href="selinas-SiteTyp5.jsp">SiteTyp 5</a></li>
					<li><a href="selinas-SiteTyp6.jsp">SiteTyp 6</a></li>
				</ul>
		<h3>Technologien</h3>
		<p>Java<br />JavaServer Pages/Servlet<br />Benutzerdefinierte Aktion TagSupport<br />JavaScript<br />MySql<br />XML/XSL<br />FOP<br />HTML<br />CSS - Cascading Style Sheets<br /></p>
		<h3>Vitae dicta sunt</h3>	
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
		<h4>Eaque ipsa quae</h4>	
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>	
	</div><!-- contentRight -->
	</div><!-- wrapperContent -->	
	<div id="footer">
	<p>footer</p>
	</div><!-- footer -->	
</div><!-- wrapper -->
	</div><!-- pageContentRight -->
	</div><!-- pageContentWrapper -->
	<div id="pageFooter"><p>pageFooter</p></div><!-- pageFooter -->	
</div><!-- page -->
</body>
</html>
