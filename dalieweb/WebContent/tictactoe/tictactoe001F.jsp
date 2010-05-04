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
<link href="<%= request.getContextPath()%>/theme/immo001.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%= request.getContextPath()%>/theme/selinas-DruckTyp.css" rel="stylesheet" type="text/css" media="print"/>
<title>dalieweb</title>
</head>
<body class="yui-skin-sam">
	<div id="doc3" class="yui-t7">
	<div align="left"><font color="#800040">package applet</font>;<br />
<br />
<font color="#800040">import</font> java.awt.*;<br />
<font color="#800040">import</font> java.awt.event.*;<br />
<font color="#800040">import</font> java.util.*;<br />
<font color="#800040">import</font> java.text.*;<br />
<font color="#800040">import</font> java.applet.*;<br />
<br />
&nbsp;&nbsp;<font color="#800040">public class</font> TicTacToe<font
	color="#800040"> extends</font> Applet <font color="#800040">
implements</font> MouseListener { <br />
&nbsp;&nbsp;<font color="#800040">static</font> Feld[][] <font
	color="#0033FF">feld</font> = <font color="#800040">new</font> Feld
[3][3];<br />
&nbsp;&nbsp;<font color="#800040">int</font><font color="#0033FF">
spieler </font>= 2;<br />
&nbsp;&nbsp;<font color="#800040">Image</font><font color="#0033FF">
kreuz </font>= null;<br />
&nbsp;&nbsp;<font color="#800040">Image</font><font color="#0033FF">
punkt </font> = null;<br />
&nbsp;&nbsp;<font color="#800040">boolean</font><font color="#0033FF">
status </font> = <font color="#800040">true</font>;<br />
<br />
&nbsp;&nbsp;<font color="#800040">public void</font> init(){<br />
&nbsp;&nbsp;&nbsp;addMouseListener(<font color="#800040">this</font>);<br />
<br />
&nbsp;&nbsp;<font color="#008080">//erst einmal Spielfeldinizalisieren</font><br />
&nbsp;&nbsp;<font color="#800040">for</font>(<font color="#800040">int</font>
x =0;x < <font color="#0033FF">feld.length</font>; x++)<br />
&nbsp;&nbsp;<font color="#800040">for</font>(<font color="#800040">int</font>
y = 0;y < <font color="#0033FF">feld.length</font>; y++)<br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[x][y] = <font
	color="#800040">null</font>;<br />
<br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[0][0] = <font
	color="#800040">new</font> Feld(41,41); <br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[1][0] = <font
	color="#800040">new</font> Feld(81,41); <br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[2][0] = <font
	color="#800040">new</font> Feld(121,41);<br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[0][1] = <font
	color="#800040">new</font> Feld(41,81);<br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[1][1] = <font
	color="#800040">new</font> Feld(81,81);<br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[2][1] = <font
	color="#800040">new</font> Feld(121,81);<br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[0][2] = <font
	color="#800040">new</font> Feld(41,121);<br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[1][2] = <font
	color="#800040">new</font> Feld(81,121);<br />
&nbsp;&nbsp;<font color="#0033FF">feld</font>[2][2] = <font
	color="#800040">new</font> Feld(121,121);<br />
&nbsp;&nbsp;}&nbsp;<font color="#008080">//init</font><br />
<br />
&nbsp;&nbsp;<font color="#800040">public void</font> start(){<br />
&nbsp;&nbsp;&nbsp;MediaTracker mt = new MediaTracker(<font
	color="#800040">this</font>);<br />
&nbsp;&nbsp;&nbsp;<font color="#0033FF">punkt</font> =
getToolkit().getImage(<font color="#0033FF">"applet\\O.gif"</font>);<br />
&nbsp;&nbsp;&nbsp;mt.addImage(<font color="#0033FF">punkt</font>,0);<br />
&nbsp;&nbsp;&nbsp;<font color="#800040">try</font> {&nbsp;<font
	color="#008080">//Warten, bis das Image vollständig geladen ist.</font><br />
&nbsp;&nbsp;&nbsp;mt.waitForAll();<br />
&nbsp;&nbsp;}<font color="#800040"> catch</font> (InterruptedException
e) {<br />
&nbsp;&nbsp;}&nbsp;<font color="#008080">//nothing</font><br />
&nbsp;&nbsp;&nbsp;<font color="#0033FF">kreuz</font> =
getToolkit().getImage(<font color="#0033FF">"applet\\X.gif"</font>);<br />
&nbsp;&nbsp;&nbsp;mt.addImage(<font color="#0033FF">kreuz</font>,0);<br />
&nbsp;&nbsp;<font color="#800040">try</font> { mt.waitForAll();<br />
&nbsp;&nbsp;}<font color="#800040">catch</font> (InterruptedException e)
{ <br />
&nbsp;&nbsp;}&nbsp;<font color="#008080">//nothing</font> <br />
&nbsp;&nbsp;}&nbsp;<font color="#008080">//start</font><br />
<br />
&nbsp;&nbsp;<font color="#800040">public void</font> destroy() { <br />
&nbsp;&nbsp;&nbsp;&nbsp;removeMouseListener(this);<br />
&nbsp;&nbsp;}&nbsp;<font color="#008080">//destroy</font><br />
<br />
&nbsp;&nbsp;<font color="#800040">public void</font> paint(Graphics g){<br />
&nbsp;&nbsp;&nbsp;<font color="#008080">//SpielFeld zeichnen</font><br />
&nbsp;&nbsp;&nbsp;g.setColor(Color.<font color="#0033FF">blue</font>);<br />
&nbsp;&nbsp;&nbsp;<font color="#800040">for</font>(<font color="#800040">int</font>
x = 39;x <= 159;x+=40)<br />
&nbsp;&nbsp;&nbsp;&nbsp;g.drawLine(x,39,x,159);<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">for</font>(<font
	color="#800040">int</font> y = 39;y <= 159;y+=40)<br />
&nbsp;&nbsp;&nbsp;&nbsp;g.drawLine(39,y,159,y);<br />
&nbsp;&nbsp;&nbsp;<font color="#008080">//nochmal</font><br />
&nbsp;&nbsp;&nbsp;<font color="#800040">for</font>(<font color="#800040">int</font>
x = 40;x <= 160;x+=40)<br />
&nbsp;&nbsp;&nbsp;&nbsp;g.drawLine(x,40,x,160);<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">for</font>(<font
	color="#800040">int</font> y = 40;y <= 160;y+=40)<br />
&nbsp;&nbsp;&nbsp;&nbsp;g.drawLine(40,y,160,y);<br />
}&nbsp;<font color="#008080">//paint</font><br />
<br />
&nbsp;&nbsp;<font color="#800040">private</font> Image getImage(){<br />
&nbsp;&nbsp;&nbsp;<font color="#800040">if</font> (<font color="#0033FF">spieler</font>
==1){<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#0033FF">spieler</font> ++; <br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">return</font>&nbsp;<font
	color="#0033FF">punkt</font>;<br />
&nbsp;&nbsp;&nbsp;}else{<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#0033FF">spieler</font> --;<br />
&nbsp;&nbsp;&nbsp;<font color="#800040">return</font>&nbsp;<font
	color="#0033FF">kreuz</font>;<br />
&nbsp;&nbsp;&nbsp;}&nbsp;<font color="#008080">//endif Spieler</font><br />
&nbsp;&nbsp;}&nbsp;<font color="#008080">//getImage</font><br />
<br />
&nbsp;&nbsp;<font color="#800040">private void</font> checksieg(){<br />
&nbsp;&nbsp;&nbsp;<font color="#800040">int</font> produkt=1;<br />
&nbsp;&nbsp;&nbsp;<font color="#800040">for</font>(<font color="#800040">byte</font>
x=0; x > <font color="#0033FF">feld.length</font>; x++)<br />
&nbsp;&nbsp;&nbsp;<font color="#800040">for</font>(<font color="#800040">byte</font>
y=0; y > <font color="#0033FF">feld</font>[0].<font color="#0033FF">length</font>;
y++)<br />
&nbsp;&nbsp;&nbsp;&nbsp;produkt *= <font color="#0033FF">feld</font>[x][y].<font
	color="#0033FF">gamer</font>;<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">if</font>(&nbsp;produkt&nbsp;>&nbsp;0){<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;showStatus(<font color="#0033FF">"Unentschieden"</font>);<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#0033FF">status</font>&nbsp;=&nbsp;<font
	color="#800040">false</font>;}<br />
&nbsp;&nbsp;<font color="#800040">else</font>{<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#008080">//check von links,oben
nach rechts,unten</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">if</font>(<font
	color="#0033FF">feld</font>[0][0].<font color="#0033FF">gamer</font> ==
<font color="#0033FF">spieler</font> && <font color="#0033FF">feld</font>[1][1].<font
	color="#0033FF">gamer</font> == <font color="#0033FF">spieler</font> &&
<font color="#0033FF">feld</font>[2][2].<font color="#0033FF">gamer</font>
== <font color="#0033FF">spieler</font>){<br />
&nbsp;&nbsp;&nbsp;&nbsp;showStatus(<font color="#0033FF">"Spieler " +
spieler + " hat gewonnen, Glückwunsch!!!"</font>);<br />
&nbsp;&nbsp;&nbsp;&nbsp;status&nbsp;=&nbsp;<font color="#800040">false;</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;}<font color="#008080">&nbsp;//endif</font><br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#008080">//check von
links,unten nach rechts,oben</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">if</font>(<font
	color="#0033FF">feld</font>[2][0].<font color="#0033FF">gamer</font> ==
<font color="#0033FF">spieler</font> && <font color="#0033FF">feld</font>[1][1].<font
	color="#0033FF">gamer</font> == <font color="#0033FF">spieler</font> &&
<font color="#0033FF">feld</font>[0][2].<font color="#0033FF">gamer</font>
== <font color="#0033FF">spieler</font>){<br />
&nbsp;&nbsp;&nbsp;&nbsp;showStatus(<font color="#0033FF">"Spieler " +
spieler + " hat gewonnen!!! Glückwunsch"</font>);<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#0033FF">status</font>&nbsp;=&nbsp;<font
	color="#800040">false;</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<font color="#008080">//endif</font><br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#008080">//check wagerecht</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">for</font>(<font
	color="#800040">int</font>&nbsp;x&nbsp;=&nbsp;0;x&nbsp;<&nbsp;feld.length;&nbsp;x++&nbsp;){<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">if</font>(<font
	color="#0033FF">feld</font>[x][0].<font color="#0033FF">gamer</font>&nbsp;==&nbsp;<font
	color="#0033FF">spieler</font>&nbsp;&&&nbsp;<font color="#0033FF">feld</font>[x][1].<font
	color="#0033FF">gamer</font>&nbsp;==&nbsp;<font color="#0033FF">spieler</font>&nbsp;&&&nbsp;<font
	color="#0033FF">feld</font>[x][2].<font color="#0033FF">gamer</font>&nbsp;==&nbsp;<font
	color="#0033FF">spieler</font>){<br />
&nbsp;&nbsp;&nbsp;&nbsp;showStatus(<font color="#0033FF">"Spieler&nbsp;"&nbsp;+&nbsp;spieler&nbsp;+&nbsp;"&nbsp;hat&nbsp;gewonnen&nbsp;!!!&nbsp;Glückwunsch&nbsp;!!!"</font>);<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#0033FF">status</font>&nbsp;=&nbsp;<font
	color="#800040">false;</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<font color="#008080">//endif</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<font color="#008080">//for</font><br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#008080">//check senkrecht</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">for</font>( <font
	color="#800040">int</font>&nbsp;x&nbsp;=&nbsp;0&nbsp;;&nbsp;x&nbsp;<&nbsp;feld.length&nbsp;;&nbsp;x++){<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#800040">if&nbsp;</font>(<font
	color="#0033FF">feld</font>[0][x].<font color="#0033FF">gamer</font>&nbsp;==&nbsp;<font
	color="#0033FF">spieler</font>&nbsp;&&&nbsp;<font color="#0033FF">feld</font>[1][x].<font
	color="#0033FF">gamer</font>&nbsp;==&nbsp;<font color="#0033FF">spieler</font>&nbsp;&&&nbsp;<font
	color="#0033FF">feld</font>[2][x].<font color="#0033FF">gamer</font>&nbsp;==&nbsp;<font
	color="#0033FF">spieler</font>){<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;showStatus(<font color="#0033FF">"Spieler&nbsp;"&nbsp;+&nbsp;spieler&nbsp;+&nbsp;"&nbsp;hat&nbsp;gewonnen&nbsp;Glückwunsch&nbsp;!&nbsp;!&nbsp;!&nbsp;"</font>);<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#0033FF">status</font>&nbsp;=&nbsp;<font
	color="#800040">false;</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<font color="#008080">//endif</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<font color="#008080">//for</font><br />
<br />
&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;&nbsp;<font color="#008080">//endif
Produkt</font><br />
&nbsp;&nbsp;}&nbsp;&nbsp;<font color="#008080">//checksieg</font><br />
<br />
&nbsp;&nbsp;<font color="#800040">public&nbsp;void</font>&nbsp;mousePressed(MouseEvent&nbsp;event){&nbsp;}<br />
&nbsp;&nbsp;<font color="#800040">public&nbsp;void</font>&nbsp;mouseReleased(MouseEvent&nbsp;event){&nbsp;}<br />
&nbsp;&nbsp;<font color="#800040">public&nbsp;void</font>&nbsp;mouseClicked(MouseEvent&nbsp;event){<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Graphics&nbsp;g&nbsp;=&nbsp;getGraphics(&nbsp;);<br />
&nbsp;&nbsp;<font color="#800040">&nbsp;&nbsp;&nbsp;&nbsp;int</font>&nbsp;x&nbsp;=&nbsp;event.getX(&nbsp;)&nbsp;/&nbsp;40&nbsp;-&nbsp;1;<br />
&nbsp;&nbsp;<font color="#800040">&nbsp;&nbsp;&nbsp;&nbsp;int</font>&nbsp;
y&nbsp; =&nbsp;event.getY(&nbsp;)&nbsp;/&nbsp;40&nbsp;-&nbsp;1;<br />
&nbsp;&nbsp;<font color="#800040">&nbsp;&nbsp;&nbsp;&nbsp;if</font>&nbsp;(!<font
	color="#0033FF">feld</font>[x][y].<font color="#0033FF">besetzt</font>&nbsp;&&&nbsp;event.getClickCount(&nbsp;)&nbsp;>&nbsp;1&nbsp;&&&nbsp;<font
	color="#0033FF">status</font>){<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g.drawImage(getImage(&nbsp;)&nbsp;,&nbsp;<font
	color="#0033FF">feld</font>[x][y].x&nbsp;,&nbsp;<font color="#0033FF">feld</font>[x][y].y,<font
	color="#800040">this</font>);<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#0033FF">feld</font>[x][y].<font
	color="#0033FF">besetzt</font>&nbsp;=&nbsp;<font color="#800040">true;</font><br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#0033FF">feld</font>[x][y].<font
	color="#0033FF">gamer</font>&nbsp;=&nbsp;<font color="#0033FF">spieler</font>;<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;checksieg();<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}&nbsp;<font color="#008080">//endif</font><br />
&nbsp;&nbsp;}&nbsp;<font color="#008080">//moiseClicked</font><br />
<br />
&nbsp;&nbsp;<font color="#800040">public void</font>&nbsp;mouseEntered(MouseEvent&nbsp;event){&nbsp;}<br />
&nbsp;&nbsp;<font color="#800040">public void</font>&nbsp;mouseExited(MouseEvent&nbsp;event){&nbsp;}<br />
&nbsp;&nbsp;<font color="#800040">public</font>&nbsp;String&nbsp;getAppletInfo(&nbsp;){<br />
&nbsp;&nbsp;<font color="#800040">&nbsp;&nbsp;return</font> &nbsp;&nbsp;<font
	color="#0033FF">"TicTacToe&nbsp;Ver.&nbsp;1.0&nbsp;(C)&nbsp;2006&nbsp;Uwe&nbsp;Dalies";&nbsp;</font>}
<br />
&nbsp;&nbsp;}&nbsp;<font color="#008080"> //getAppletInfo</font><br />
<br />
&nbsp;&nbsp;}<font color="#008080"> //TicTacToe Class</font><br />
</div>
	</div><!-- /doc3 = 100%, -->
</body>
</html>
