/* *** bindLinksWithAjaxContent - BEGIN *** */
function bindLinksWithAjaxContent() {
	
	jQuery("input[type='submit'].ajaxInput, input[type='button'].ajaxInput").live("click", function(event){
		event.preventDefault();
		
		var getCustomTargetContainer = jQuery(this).parents("form").attr("target");
		
		if (getCustomTargetContainer != "") {
		
			alert(getCustomTargetContainer);
		} else {
			alert(getCustomTargetContainer);
		}
		
		return false;
	});
	
}
/* *** bindLinksWithAjaxContent - END *** */


/* ######################################## DOCUMENT READY - BEGIN ######################################## */
jQuery(document).ready(function(){
	/* NOTE: initialize all jQuery functionalities here */
	bindLinksWithAjaxContent();
});
/* ######################################## DOCUMENT READY - END ######################################## */