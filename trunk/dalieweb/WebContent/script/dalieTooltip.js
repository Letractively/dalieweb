YAHOO.namespace("example.container");
function init() {
	// Instantiate a Panel from markup
	YAHOO.example.container.panel1 = new YAHOO.widget.Panel("panel1",{ width:"320px", visible:false, constraintoviewport:true } );
	YAHOO.example.container.panel1.render();
	
	YAHOO.util.Event.addListener("show1", "click", YAHOO.example.container.panel1.show, YAHOO.example.container.panel1, true);
}
YAHOO.util.Event.addListener(window, "load", init);