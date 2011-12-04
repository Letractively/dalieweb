/* *** bindLinksWithAjaxContent - BEGIN *** */
function bindLinksWithAjaxContent() {
	
	jQuery("input[type='submit'].ajaxInput, input[type='button'].ajaxInput").live("click", function(event){
		event.preventDefault();
		
		var getCustomTargetContainer = jQuery(this).parents("form").attr("target");
		
		if (getCustomTargetContainer != "") {
		
			globalGetAjaxContent({
				currentElement	:jQuery(this),
				formSubmit		:jQuery(this).parents("forms"),
				targetContainer	:"#" + jQuery(this).parents("target")
			});
		} else {
			globalGetAjaxContent({
				currentElement	:jQuery(this),
				formSubmit		:jQuery(this).parents("forms")
			});
		}
		return false;
	});
	
} /* *** bindLinksWithAjaxContent - END *** */

/* *** globalGetAjaxContent - BEGINN */
function globalGetAjaxContent(settings) {
	
	settings = jQuery.extend({//default settings
		currentElement				:	null,
		type						:	"GET",
		formSubmit					:	null,
		url							:	null,
		data						:	null,
		targetContainer				:	"targetContainerForAjaxContent",
		nameOfLightbox				:	"#lightbox_content",
		nameOfAjaxLoader			:	"#ajaxLoader",
		doNotLoadContentInLightbox	: false,
		onComplete					: function(){}
	}, settings || {});
	

} /* *** globalGetAjaxContent - END *** */

/* #################### DOCUMENT READY - BEGIN ############################# */
jQuery(document).ready(function(){
	/* NOTE: initialize all jQuery functionalities here */
	
	bindLinksWithAjaxContent();
});
/* #################### DOCUMENT READY - END    ############################ */