YAHOO.util.Event.onDOMReady( function() {

	var Event = YAHOO.util.Event, Dom = YAHOO.util.Dom, dialog, calendar;

	var showBtn = Dom.get("show");

	Event.on(showBtn, "click", function() {

		/*Lazy Dialog Creation - Wait to create the Dialog, 
		  and setup document click listeners, until the first time the button is clicked.*/
			if (!dialog) {

				// Hide Calendar if we click anywhere in the document other than the calendar
			Event.on(document, "click", function(e) {
				var el = Event.getTarget(e);
				var dialogEl = dialog.element;
				if (el != dialogEl && !Dom.isAncestor(dialogEl, el)
						&& el != showBtn && !Dom.isAncestor(showBtn, el)) {
					dialog.hide();
				}
			});

			function resetHandler() {
			/* Reset the current calendar page to the select date, or 
			   to today if nothing is selected. */
			var selDates = calendar.getSelectedDates();
			var resetDate;

			if (selDates.length > 0) {
				resetDate = selDates[0];
			} else {
				resetDate = calendar.today;
			}
			calendar.cfg.setProperty("pagedate", resetDate);
			calendar.render();
		}

		function closeHandler() {
			dialog.hide();
		}

		dialog = new YAHOO.widget.Dialog("container", {
			visible : false,
			context : [ "show", "tl", "bl" ],
			buttons : [ {
				text : "Reset",
				handler : resetHandler,
				isDefault : true
			}, {
				text : "Close",
				handler : closeHandler
			} ],
			draggable : false,
			close : true
		});
		dialog.setHeader('Pick A Date');
		dialog.setBody('<div id="cal"></div>');
		dialog.render(document.body);

		dialog.showEvent.subscribe( function() {
			if (YAHOO.env.ua.ie) {
				/* Since we're hiding the table using yui-overlay-hidden, 
				 * we want to let the dialog know that the content size has 
				 * changed, when shown */
				dialog.fireEvent("changeContent");
			}
		});
	}

	// Lazy Calendar Creation - Wait to create the Calendar until the first time the button is clicked.
	if (!calendar) {

		calendar = new YAHOO.widget.Calendar("cal", {
			iframe : false, // Turn iframe off, since container has iframe support.
			hide_blank_weeks : true
		// Enable, to demonstrate how we handle changing height, using
		// changeContent
				});
		calendar.cfg.setProperty("WEEKDAYS_LONG", [ "Sonntag", "Montag",
				"Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag" ]);
		calendar.cfg.setProperty("MONTHS_LONG", [ "Januar", "Februar",
				"M\u00E4rz", "April", "Mai", "Juni", "Juli", "August",
				"September", "Oktober", "November", "Dezember" ]);
		calendar.render();

		calendar.selectEvent.subscribe( function() {
			if (calendar.getSelectedDates().length > 0) {

				var selDate = calendar.getSelectedDates()[0];

				// Pretty Date Output, using Calendar's Locale values: Friday, 8
				// February 2008
				var wStr = calendar.cfg.getProperty("WEEKDAYS_LONG")[selDate.getDay()];
				var dStr = selDate.getDate();
				var mStr = calendar.cfg.getProperty("MONTHS_LONG")[selDate.getMonth()];
				/* var mStr = calendar.cfg.getProperty("MONTHS_SHORT")[selDate.getMonth()]; */
				var yStr = selDate.getFullYear();
				/* Dom.get("date").value = wStr + ", " + dStr + "." + mStr + "." + yStr; */
				Dom.get("date").value = dStr + "." + mStr + "." + yStr;
			} else {
				Dom.get("date").value = "";
			}
			dialog.hide();
		});

		calendar.renderEvent.subscribe( function() {
			// Tell Dialog it's contents have changed, which allows 
				// container to redraw the underlay (for IE6/Safari2)
				dialog.fireEvent("changeContent");
			});
	}

	var seldate = calendar.getSelectedDates();

	if (seldate.length > 0) {
		// Set the pagedate to show the selected date if it exists
		calendar.cfg.setProperty("pagedate", seldate[0]);
		calendar.render();
	}

	dialog.show();
}	);
});