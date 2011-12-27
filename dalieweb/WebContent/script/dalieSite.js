/* *** bindLinksWithAjaxContent - BEGIN *** */
function bindLinksWithAjaxContent() {
	
	jQuery("input[type='submit'].ajaxInput, input[type='button'].ajaxInput").live("click", function(event){
		event.preventDefault();
		
		var getCustomTargetContainer = jQuery(this).parents("form").attr("target");
		
		if (getCustomTargetContainer != "") {
		
			globalGetAjaxContent({
				currentElement	:jQuery(this),
				formSubmit		:jQuery(this).parents("form"),
				targetContainer : "#" + jQuery(this).parents("form").attr("target")
			});
		} else {
			globalGetAjaxContent({
				currentElement	:jQuery(this),
				formSubmit		:jQuery(this).parents("form")
			});
		}
		return false;
	});
	
} /* *** bindLinksWithAjaxContent - END *** */

/* *** bindLinksWithLightboxAjaxContent - BEGINN *** */
function bindLinksWithLightboxAjaxContent(){
	
	jQuery('.lightboxLink, .lightboxInput').live("click", function(event){
		event.preventDefault();
		alert("Hier");
		//lightboxOpen(this);
	});
	
} /* *** bindLinksWithLightboxAjaxContent - END *** */

/* *** globalGetAjaxContent - BEGINN */
function globalGetAjaxContent(settings) {
	
	settings = jQuery.extend({//default settings
		currentElement				:	null,
		type						:	"post",
		formSubmit					:	null,
		url							:	null,
		data						:	null,
		targetContainer				:	"targetContainerForAjaxContent",
		nameOfLightbox				:	"#lightbox_content",
		nameOfAjaxLoader			:	"#ajaxLoader",
		doNotLoadContentInLightbox	: false,
		onComplete					: function(){}
	}, settings || {});
	
if( settings.type == "post" || settings.formSubmit ){
		
		if( !settings.url ){
			var getAjaxContentParameter = addAjaxUrlParameter({
				currentURL : jQuery(settings.formSubmit).attr('action')
			});
			settings.url = getAjaxContentParameter;
		}
		
		if( !settings.data ){
			
			var currentElementAttrName = "&";
			
			if( settings.currentElement ){
				if( jQuery(settings.currentElement).is("input") ){
					currentElementAttrName += jQuery(settings.currentElement).attr("name");
				}
			}
			settings.data = jQuery(settings.formSubmit).serialize() + currentElementAttrName;
		}
		
		jQuery.ajax({
			type		: "POST",
			url      	: settings.url,
			data     	: settings.data,
//			beforeSend: function(XMLHttpRequest){
				// A pre-callback to modify the XMLHttpRequest object before it is sent. Use this to set custom headers etc. 
				// The XMLHttpRequest is passed as the only argument. This is an Ajax Event. 
				// You may return false in function to cancel the request. 
//				if( settings.isOpenedInLightbox ){
//					jQuery(settings.nameOfLightbox).hide();
//					jQuery(settings.nameOfAjaxLoader).show();
//				} else {
//					prepareAnimationLoader({
//						targetContainer : settings.targetContainer
//					});
//				}
				//centerLightbox();
//			},
			success		: function(data, textStatus){
				// A function to be called if the request succeeds. The function gets passed two arguments: The data returned from the server, formatted according to the 'dataType' parameter, and a string describing the status.
				// data could be xmlDoc, jsonObj, html, text, etc...
				//alert(settings.targetContainer);
				jQuery(settings.targetContainer).html(data);
				
				if( settings.isOpenedInLightbox ){
					
					jQuery(settings.nameOfLightbox).show();
					jQuery(settings.nameOfAjaxLoader).hide();
				} else {
					jQuery(settings.targetContainer).removeAttr("style");
				}
				
			} ,
			error: function(XMLHttpRequest, textStatus, errorThrown){
				ajaxRedirect({ 
					ar_XMLHttpRequest	: XMLHttpRequest,
					targetContainer		: settings.targetContainer
				});
			},
			complete 	: function(XMLHttpRequest, textStatus){ 
				settings.onComplete();
			} 
		});
	}

} /* *** globalGetAjaxContent - END *** */

/************ addAjaxUrlParameter - BEGIN ************/
function addAjaxUrlParameter(settings){


	settings = jQuery.extend({// default settings
		currentURL : null
	}, settings || {});
	
	
	if( settings.currentURL ){
		
		var currentURL = settings.currentURL;
		var currentSeparator = "?";
		
		if( currentURL.indexOf("ajaxContent") != -1){
			currentURL = currentURL;
		} else {
			if( currentURL.indexOf("?") != -1){
				currentSeparator = "&";
			} 
			
			currentURL = currentURL + currentSeparator + "ajaxContent=true";
		}
	
	} else {
		currentURL = "";
	}
	
	return currentURL;
	
}
/************ addAjaxUrlParameter - END ************/

/* #################### DOCUMENT READY - BEGIN ############################# */
jQuery(document).ready(function(){
	/* NOTE: initialize all jQuery functionalities here */
	
	bindLinksWithAjaxContent();
	bindLinksWithLightboxAjaxContent();
});
/* #################### DOCUMENT READY - END    ############################ */