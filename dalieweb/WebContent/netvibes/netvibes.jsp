<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" 
  xmlns:widget="http://www.netvibes.com/ns/" >
  <head>
 
    <meta name="author" content="dalieweb" />
    <meta name="description" content="Hello World" />
 
    <meta name="apiVersion" content="1.0" />
    <meta name="debugMode" content="true" />
 
    <link rel="stylesheet" type="text/css" href="http://www.netvibes.com/themes/uwa/style.css" />
    <script type="text/javascript" src="http://www.netvibes.com/js/UWA/load.js.php?env=Standalone"></script>
 
    <widget:preferences>
      <preference name="hellowho" type="text" label="Hello who ?" defaultValue="World" />
    </widget:preferences>
 
    <title>dalieweb</title>
    <link rel="icon" type="image/png" href="http://www.dalieweb.de/dalieweb/bilder/pfeilmit01.ico" />
 
    <script type="text/javascript">
      // widget.onLoad() is fired when the widget is fully loaded
      // or when the preferences are validated 
      widget.onLoad = function() {
        var who = widget.getValue('hellowho');
        // widget.setBody() replaces the content of the body element
        widget.setBody('<p>Hello ' + who + '</p><br<ul><li><a href="http://www.dalieweb.de" title="dalieweb" alt="dalieweb">dalieweb</a></li><li><a href="http://www.google.de" title="google" alt="google">google</a></li></ul>');
      }
    </script>
  </head>
  <body>
  </body>
</html>
