<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:widget="http://www.netvibes.com/ns/">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="autoRefresh" content="10000" />
<%-- DALIEWEB:LINKS --%>
<link rel="stylesheet" type="text/css"
	href="http://www.netvibes.com/themes/uwa/style.css" />
<link rel="stylesheet" type="text/css"
	href="http://www.dalieweb.de/theme/netvibes.css" />
<link rel="icon" type="image/ico"
	href="http://www.dalieweb.de/pfeilmit01.ico" />
<%-- WIDGET:Preferences --%>
<widget:preferences>
	<preference name="widgetTitle" type="hidden" label="Title"
		defaultValue="dalieweb" />
	<preference name="feedUrl" type="text" label="URL"
		defaultValue="http://www.dalieonline.de/dalieweb/xml/netvibes.xml" />
	<preference name="feedJena" type="hidden" label="URL"
		defaultValue="http://www.dalieonline.de/dalieweb/xml/jena.xml" />
	<preference name="feedStuttgart" type="hidden" label="URL"
		defaultValue="http://www.dalieonline.de/dalieweb/xml/stuttgart.xml" />
	<preference name="feedToronto" type="hidden" label="URL"
		defaultValue="http://www.dalieonline.de/dalieweb/xml/toronto.xml" />
	<preference name="nbTitles" type="range"
		label="Number of items to display" defaultValue="4" step="1" min="1" max="20" />
	<preference name="charLimit" type="range"
		label="Limit on characters per feed item (zero=unlimited)"
		defaultValue="500" step="10" min="0" max="1000" />
	<preference name="imgWidth" type="range" label="Width of image"
		defaultValue="80" step="10" min="10" max="200" />
	<preference name="offset" type="hidden" defaultValue="0" />
</widget:preferences>
<script type="text/javascript"
	src="http://www.netvibes.com/js/UWA/load.js.php?env=Standalone"></script>
<script type="text/javascript">

var TabViewSample = {};
var RSSDalieweb = {};
var RSSJena = {};
var RSSStuttgart = {};
var RSSToronto = {};
var nextpic = 0;

	RSSDalieweb.display = function(feed) {
			if (feed) { 
				RSSDalieweb.feed = feed;
				var linkForThisTab = widget.createElement('a');
                linkForThisTab.href = 'http://www.dalieonline.de';
                linkForThisTab.textContent = 'Hier geht es auch zur Homepage';
				linkForThisTab.className = 'myBottomLink';
                content = buildFeedContent(RSSDalieweb, linkForThisTab);
                TabViewSample.tabs.setContent("tab1", content);
			}//feed
			
			var pager = new UWA.Controls.Pager(
			{
    			module: widget,
    			limit: widget.getValue('nbTitles'),
    			offset: widget.getValue('offset'),
    			dataArray: feed
    		} 
			);
		
			pager.onChange = function(newOffset) {
  				widget.setValue('offset', newOffset);
  				RSSDalieweb.display();
			}//pager.onChange
			
			var pagerContainer = UWA.$element(widget.body.getElementsByClassName('paging')[0] );
			pagerContainer.setContent( pager.getContent() );					
  	
  	}//RSSDalieweb.display
	
	RSSJena.display = function(feed) {
			if (feed) { 
				RSSJena.feed = feed;
                
				var feedList = widget.createElement('ul');
				feedList.className = 'nv-tabContent';
				var j = 0;
				// loop through the downloaded items		
			    for (var i = widget.getValue('offset'); i < RSSJena.feed.items.length; i++) {
			    
				// if the limit is reached, stop looping
				if (j >= widget.getValue('nbTitles')) break;
				var item = RSSJena.feed.items[i];
				var li = widget.createElement('li');
				var a = widget.createElement('a');
				a.href = item.link;
				a.target = '_blank';
				if(widget.getValue('charLimit') == 0)  
					a.desc = item.content.stripTags().truncate(255);
				else 
					a.desc = item.content.stripTags().truncate(widget.getValue('charLimit'));
				a.onmouseover = function() {
				UWA.Utils.setTooltip(this, this.desc, 250);
				}
				var img = widget.createElement('img');
				img.src = item.enclosures[0].url;
				//img.width = widget.getValue('imgWidth');
				img.width = "110";
				img.height = "90";
				img.title = item.content.stripTags().truncate(255);
				if(widget.getValue('charLimit') == 0)  
					img.alt = item.content.stripTags().truncate(255);
				else 
					img.alt = item.content.stripTags().truncate(widget.getValue('charLimit'));
				a.appendChild(img);
				li.appendChild(a);
				feedList.appendChild(li);
 				j++;
				}//for
				TabViewSample.tabs.setContent("tab2", feedList);
			}//feed
			
			var pager = new UWA.Controls.Pager(
			{
    			module: widget,
    			limit: widget.getValue('nbTitles'),
    			offset: widget.getValue('offset'),
    			dataArray: feed
    		} 
			);
		
			pager.onChange = function(newOffset) {
  				widget.setValue('offset', newOffset);
  				newsDigest.display();
			}//pager.onChange
			
			var pagerContainer = UWA.$element(widget.body.getElementsByClassName('paging')[0] );
			pagerContainer.setContent( pager.getContent() );					
  	
  	}//RSSJena.display
	
	RSSStuttgart.display = function(feed) {
			if (feed) { 
				RSSStuttgart.feed = feed;
                
				var feedList = widget.createElement('ul');
				feedList.className = 'nv-tabContent';
				var j = 0;
				// loop through the downloaded items		
			    for (var i = widget.getValue('offset'); i < RSSStuttgart.feed.items.length; i++) {
			    
				// if the limit is reached, stop looping
				if (j >= widget.getValue('nbTitles')) break;
				var item = RSSStuttgart.feed.items[i];
				var li = widget.createElement('li');
				var a = widget.createElement('a');
				a.href = item.link;
				a.target = '_blank';
				if(widget.getValue('charLimit') == 0)  
					a.desc = item.content.stripTags().truncate(255);
				else 
					a.desc = item.content.stripTags().truncate(widget.getValue('charLimit'));
				a.onmouseover = function() {
				UWA.Utils.setTooltip(this, this.desc, 250);
				}
				var img = widget.createElement('img');
				img.src = item.enclosures[0].url;
				//img.width = widget.getValue('imgWidth');
				img.width = "110";
				img.height = "90";
				img.title = item.content.stripTags().truncate(255);
				if(widget.getValue('charLimit') == 0)
					img.alt = item.content.stripTags().truncate(255);
				else 
					img.alt = item.content.stripTags().truncate(widget.getValue('charLimit'));
				a.appendChild(img);
				li.appendChild(a);
				feedList.appendChild(li);
 				j++;
				}//for
				TabViewSample.tabs.setContent("tab3", feedList);
			}//feed
			
			var pager = new UWA.Controls.Pager(
			{
    			module: widget,
    			limit: widget.getValue('nbTitles'),
    			offset: widget.getValue('offset'),
    			dataArray: feed
    		} 
			);
		
			pager.onChange = function(newOffset) {
  				widget.setValue('offset', newOffset);
  				newsDigest.display();
			}//pager.onChange
			
			var pagerContainer = UWA.$element(widget.body.getElementsByClassName('paging')[0] );
			pagerContainer.setContent( pager.getContent() );					
  	
  	}//RSSStuttgart.display
	
	RSSToronto.display = function(feed) {
			if (feed) { 
				RSSToronto.feed = feed;
                
				var feedList = widget.createElement('ul');
				feedList.className = 'nv-tabContent';
				var j = 0;
				// loop through the downloaded items		
			    for (var i = widget.getValue('offset'); i < RSSToronto.feed.items.length; i++) {
			    
				// if the limit is reached, stop looping
				if (j >= widget.getValue('nbTitles')) break;
				var item = RSSToronto.feed.items[i];
				var li = widget.createElement('li');
				var a = widget.createElement('a');
				a.href = item.link;
				a.target = '_blank';
				if(widget.getValue('charLimit') == 0)  
					a.desc = item.content.stripTags().truncate(255);
				else 
					a.desc = item.content.stripTags().truncate(widget.getValue('charLimit'));
				a.onmouseover = function() {
				UWA.Utils.setTooltip(this, this.desc, 250);
				}
				var img = widget.createElement('img');
				img.src = item.enclosures[0].url;
				//img.width = widget.getValue('imgWidth');
				img.width = "110";
				img.height = "90";
				img.title = item.content.stripTags().truncate(255);
				if(widget.getValue('charLimit') == 0)  
					img.alt = item.content.stripTags().truncate(255);
				else 
					img.alt = item.content.stripTags().truncate(widget.getValue('charLimit'));
				a.appendChild(img);
				li.appendChild(a);
				feedList.appendChild(li);
 				j++;
				}//for
				TabViewSample.tabs.setContent("tab4", feedList);
			}//feed
			
			var pager = new UWA.Controls.Pager(
			{
    			module: widget,
    			limit: widget.getValue('nbTitles'),
    			offset: widget.getValue('offset'),
    			dataArray: feed
    		} 
			);
		
			pager.onChange = function(newOffset) {
  				widget.setValue('offset', newOffset);
  				newsDigest.display();
			}//pager.onChange
			
			var pagerContainer = UWA.$element(widget.body.getElementsByClassName('paging')[0] );
			pagerContainer.setContent( pager.getContent() );					
  	
  	}//RSSToronto.display
	
	widget.onLoad = function() {
		var tabs = new UWA.Controls.TabView();
			TabViewSample.tabs = tabs;
			updateTitle();
			
			// Create tab items
			tabs.addTab("tab1", {text: "dalieweb"});
			tabs.addTab("tab2", {text: "Jena"});
			tabs.addTab("tab3", {text: "Stuttgart"});
			tabs.addTab("tab4", {text: "Toronto"});
			
			// Put some content in tabs
			tabs.setContent("tab1", "<p>dalieweb is loading...</p>");
			tabs.setContent("tab2", "<p>Sorry.. but Jena is in construction...</p>");
			tabs.setContent("tab3", "<p>Sorry.. but Stuttgart is in construction.. </p>");
			tabs.setContent("tab4", "<p>Sorry.. but Toronto is in construction ..</p>");
			
			// Restore saved active tab
			var activeTab = widget.getValue("activeTab");
			if (activeTab) {
				tabs.selectTab(activeTab);
			}//activeTa
			
			// Register to activeTabChange event
			tabs.observe('activeTabChange', TabViewSample.onActiveTabChanged);
			// Add the Logo 
			widget.setBody('<DIV align="right"><A HREF="http://www.dalieonline.de/dalieweb" target="_top"><IMG SRC="' + firstimg()+ '" NAME="ani"></A><BR><FONT face="Arial" size="1">dalieweb</FONT></DIV>');
			
			// Append tabview to widget body
			tabs.appendTo(widget.body);
						
  			UWA.Data.getFeed(widget.getValue('feedUrl'), RSSDalieweb.display);
  			UWA.Data.getFeed(widget.getValue('feedJena'), RSSJena.display);
			UWA.Data.getFeed(widget.getValue('feedStuttgart'), RSSStuttgart.display);
			UWA.Data.getFeed(widget.getValue('feedToronto'),RSSToronto.display);
			
	}//widget.onLoad

			
	TabViewSample.onActiveTabChanged = function(name, data) {
		var tabs = TabViewSample.tabs;
		// Save active tab
		widget.setValue("activeTab", name);	
	}//TabViewSample.onActiveTabChanged

<%-- Funktion to load Title --%>	
function updateTitle () {
    var title='<a href="http://www.dalieonline.de" target="_blank">' + 'dalieweb</a>';
    widget.setTitle(title);
}//function updateTitle
<%--Funktion for loade to first pictuer --%>	
function firstimg(){
	setTimeout("goimg(1)", 5000);
	return 'http://www.dalieonline.de/dalieweb/bilder/pfeilmit01.gif';
}//firstimg
<%--Funktion to loade the goPictuer --%>
function goimg(nexpic){
	var pic = new Array("http://www.dalieonline.de/dalieweb/bilder/pfeilmit01.gif","http://www.dalieonline.de/dalieweb/bilder/pfeilmit02.gif","http://www.dalieonline.de/dalieweb/bilder/pfeilmit03.gif","http://www.dalieonline.de/dalieweb/bilder/pfeilmit04.gif");
	nextpic++;
	if(nextpic==pic.length){
		nextpic = 0
	}//endif
	document.ani.src = pic[nextpic];
	setTimeout("goimg(nextpic)", 5000);
}//goimg
function buildFeedContent(usgsNWHC, bottomLink) {
			// get the number of items to display
			widget.preferences[1].max = usgsNWHC.feed.items.length;
			// number of parsed items
			var j = 0;
			var textHtml = '';
			var totalHTML = '';
			// loop through the downloaded items
			for (var i = widget.getValue('offset'); i < usgsNWHC.feed.items.length; i++) {
			
				// if the limit is reached, stop looping
				if (j >= widget.getValue('nbTitles')) break;
			
				// for each item, create ala the 'tr' element
				var item = usgsNWHC.feed.items[i];
				var imgHtml = '<a href="'+ item.link +'"><img src="'+ item.enclosures[0].url +'" width="'+ widget.getValue('imgWidth') +'" alt="'+item.title+'" border="1"/></a>';
				if(widget.getValue('charLimit') == 0) 
					textHtml = item.content.stripTags(); 
				else 
					textHtml = item.content.stripTags().truncate(widget.getValue('charLimit'));
				
    			var titleHtml = '<a href="' + item.link + '"><b><u>' + item.title + '</b></u></a>';
				totalHTML = totalHTML + '<table cellpadding=0 cellspacing=2 border=0><tr><td>'+ imgHtml + "</td><td style='padding-left:4px;'>" + titleHtml + '<br>' + textHtml + '</td></tr></table>';					
				j++;
			}//for
			return totalHTML;
}//function buildFeedContent
</script>
<title>dalieweb</title>
</head>
<body>
<p>dalieweb is loding...</p>
<div class="paging"></div>
</body>
</html>
