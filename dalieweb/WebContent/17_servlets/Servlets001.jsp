<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script  type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
     google.load("jquery","1.7",{uncompressed:true});
</script>
<link href="<%=request.getContextPath()%>/theme/sunrise.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}
.defaultForm textarea.textareaInTabContainer {
	width:			526px;
	height:			60px;
}
* html .defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell input.defaultFormInputtext {/* IE6 */
	margin-left:	1px;
}
*+html .defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell input.defaultFormInputtext {/* IE7 */
	margin-left:	1px;
}
.defaultForm input.defaultFormInputtext.sizeStreet {
	width:			170px;
}
.defaultForm input.defaultFormInputtext.sizePostcode {
	width:			20px;
}
.defaultForm input.defaultFormInputtext.sizeCity {
	width:			150px;
}
.defaultForm input.defaultFormInputtext.sizeZip {
	width:			40px;
}
.defaultForm input.defaultFormInputtext.smallSizeCity {
	width:			100px;
}
.defaultForm input.defaultFormInputtext.smallSizeZip {
	width:			40px;
}
.defaultForm input.defaultFormInputtext.smallSize {
	width:			150px;
}
.defaultForm input.defaultFormInputtext.smallSizeStreet {
	width:			120px;
}
.defaultForm input.defaultFormInputtext.smallSizePostcode {
	width:			20px;
}
.defaultForm input.defaultFormInputtext.smallSizeLimit {
	width:			30px !important;		
}
.defaultForm input.defaultFormInputtext.smallSize2Chars {
	width:			17px;		
}
.defaultForm input.defaultFormInputtext.smallSize6Chars {
	width:			46px;		
}
.defaultForm input.defaultFormInputtext.smallSize1Char {
	width:			11px;		
}
.defaultForm input.defaultFormInputtext.sizeDate_Day {
	width:			20px;
}
.defaultForm input.defaultFormInputtext.sizeDate_Month {
	width:			20px;
}
.defaultForm input.defaultFormInputtext.sizeDate_Year {
	width:			92px;
}
.defaultForm input.defaultFormInputtext.largeSize {
	width:			280px;
}
.defaultForm input.defaultFormInputtext.maxSize {
	width:			98%;
}
.defaultForm #targetContainerForAjaxContent_CustomerPaymentMethodConfiguration input.defaultFormInputtext {
	width:			225px;
}
.defaultForm #targetContainerForAjaxContent_CustomerPaymentMethodConfiguration input.defaultFormInputtext.smallSize {
	width:			186px;
}
.defaultForm #targetContainerForAjaxContent_CustomerPaymentMethodConfiguration input.postAccountNumber {
	width:			146px;
}
/* inputDisabled */
.defaultForm input.inputDisabled {
	background-color:#ece9d8;
}
/* defaultFormSelect */
.defaultForm select.defaultFormSelect {
	width:			205px;
}
.defaultForm select.defaultFormSelect.smallSize {
	width:			155px;
}
.defaultForm select.defaultFormSelect.autoWidth {
	width:			auto;
}
.defaultForm select.defaultFormSelect.sizeDate_Month,
.defaultForm select.defaultFormSelect.sizeDate_Year {
	width:			auto;
}
.defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell select.defaultFormSelect {
	position:		relative;
	top:			-1px;
}
/* defaultFormInputRadio */
.defaultForm input.defaultFormInputRadio {
	margin:			3px 0 0 0;
	border:			none;
}
* html .defaultForm input.defaultFormInputRadio {/* IE6 */
	margin-top:		-2px;
	margin-left:	-4px;
}
*+html .defaultForm input.defaultFormInputRadio {/* IE7 */
	margin-top:		-2px;
	margin-left:	-4px;
}
/* defaultFormInputCheckbox */
.defaultForm input.defaultFormInputCheckbox {
	margin:			3px 0 0 0;
	border:			none;
}
* html .defaultForm input.defaultFormInputCheckbox {/* IE6 */
	margin-top:		1px;
}
*+html .defaultForm input.defaultFormInputCheckbox {/* IE7 */
	margin-top:		1px;
}
.defaultForm input.noMargin {
	margin:			0;
}
.defaultForm textarea {
	
}
/* error */
.defaultForm p.inputError {
	background: 	none;
	margin: 		0;
	padding: 		0 0 20px 0;
}
.defaultForm fieldset label.defaultFormError {
	color:			#D10505 !important; 
	font-weight:	bold !important;
}
.defaultForm input.defaultFormError {
	border: 		solid 2px #D10505 !important;
}
/* formSpacer */
.defaultForm div.formSpacer {
	padding:		0 0 10px 0;
}
.defaultForm div.formSpacer.small {
	padding-bottom:	4px;
}
.defaultForm div.formSpacer.last {
	padding-bottom:	4px;
}
* html .defaultForm div.formSpacer .globalButton,
* html .defaultForm div.formSpacer .globalButtonBig {/* IE6 */
	position:		relative;
	right:			5px;
}
/* fieldset */
.defaultForm fieldset {
	margin:			0; 
	padding:		10px 0;
	position:		relative;
}
.defaultForm fieldset legend {
	padding:		0;
	font-weight:	bold;
	color:			#4c2032;
}
* html .defaultForm fieldset legend {/* IE6 */
	margin:			0 0 0 -7px;
}
*+html .defaultForm fieldset legend {/* IE7 */
	margin:			0 0 0 -7px;
}
.defaultForm fieldset legend strong {
	color:			red;
}
/* label */
.defaultForm fieldset label {
	display:		block; 
	width:			170px; 
	float:			left; 
	margin:			3px 10px 0 0;
}
* html .defaultForm fieldset label {/* IE6 */
	margin-top:		5px;
}
*+html .defaultForm fieldset label {/* IE7 */
	margin-top:		5px;
}
.defaultForm fieldset label.noBold {
	font-weight:	normal;
}
#lightbox .defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell label,
.defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell label {
	display:		block; 
	float:			left; 
	margin:			3px 0 0 0;
	width:			100%;
	font-weight:	normal;
}
#lightbox .defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell label.required,
.defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell label.required {
	font-weight:	bold;
	color:				#4c2032;	
}
* html .defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell label {/* IE6 */
	margin-top:		5px;
}
*+html .defaultForm div.globalTableLayout div.globalTableLayout-Row div.globalTableLayout-Cell label {/* IE7 */
	margin-top:		5px;
}
/* defaultFormList */
/*
	Example:
	-------------------------------
	<ul class="defaultFormList level_1">
		<li class="level_1 cell_1">
			<input class="defaultFormInputCheckbox" type="checkbox" name="test" value="tester" />
		</li>
		<li class="level_1 cell_2">
			test
		</li>
	</ul>
*/
.defaultForm ul.defaultFormList,
.defaultForm ul.defaultFormList li,
.defaultForm ul.defaultFormList li ul {
	display:		block;
	float:			left;
	padding: 0;
}
.defaultForm ul.defaultFormList li.inline {
	display:		inline;
	float:			none;
}
.defaultForm ul.defaultFormList,
.defaultForm ul.defaultFormList li ul {
	width:			100%;
	clear:			both;
}
.defaultForm ul.defaultFormList li ul {
	padding:		0 0 6px 0 !important;
}
* html .defaultForm ul.defaultFormList li input.defaultFormInputCheckbox {/* IE6 */
	margin:			-2px 0 0 0;
}
*+html .defaultForm ul.defaultFormList li input.defaultFormInputCheckbox {/* IE7 */
	margin:			-2px 0 0 0;
}
/* formListInLightbox_ConfigureAdslSecurityServiceOption_1 */
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_1 {
	padding:		0 0 8px 0 !important;
}
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_1 li.cell_1 {
	width:			20px;
	padding: 0 !important;
	background: none !important;
}
* html .defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_1 li.cell_1 {/* IE6 */
	width:			26px;
}
*+html .defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_1 li.cell_1 {/* IE7 */
	width:			26px;
}
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_1 li.cell_2 {
	width:			136px;
	padding:		2px 0 0 0 !important;
	background: none !important;
}
* html .defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_1 li.cell_2 {/* IE6 */
	width:			130px;
}
*+html .defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_1 li.cell_2 {/* IE7 */
	width:			130px;
}
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_1 li.cell_3 {
	width:			300px;
	padding:		2px 0 0 0 !important;
	background: none !important;
}
/* formListInLightbox_ConfigureAdslSecurityServiceOption_2 */
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_2 li.level_1 {
	padding:		0 0 0 26px !important;
	background: none !important;
}
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_2 li ul li.cell_1 {
	width:			30px;
	padding:		0 !important;
	background: none !important;
}
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_2 li ul li.cell_2 {
	width:			100px;
	padding:		0 !important;
	background: none !important;
}
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureAdslSecurityServiceOption_2 li ul li.cell_3 {
	width:			300px;
	padding:		0 !important;
	background: none !important;
}
/* formListInLightbox_ConfigureInbox */
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureInbox li.level_2.cell_1 {
	padding-left:	26px;
}
.defaultForm ul.defaultFormList.formListInLightbox_ConfigureInbox li.level_2.cell_2 {
	padding-right:	10px;
}
/* defaultFormList_ProntomaxProductShortcut */
.defaultForm ul.defaultFormList.defaultFormList_ProntomaxProductShortcut li.level_1.cell_1 {
	padding:		3px 10px 0 0;
}
/* defaultFormList_ProntomaxTabAccount */
.defaultForm ul.defaultFormList.defaultFormList_ProntomaxTabAccount {
	padding:		10px 0 23px 0;
}
.defaultForm ul.defaultFormList.defaultFormList_ProntomaxTabAccount li.level_1.cell_1 {
	padding:		3px 10px 0 0;
}
/* infoContainerTable */
div.infoContainer.defaultForm ul.infoContainerTable {
	float:			none;
}
div.infoContainer.defaultForm ul.infoContainerTable li.cell_1 {
	padding:		0 10px 0 0;
}
div.infoContainer.defaultForm ul.infoContainerTable li.cell_2 {
	padding:		2px 0 0 0;
}
.defaultForm ul.defaultFormList.defaultFormListPadding {
	padding:	4px 0 0 !important;
	background: none !important;
}
.defaultForm ul.defaultFormList.defaultFormListPadding li.cell_1 {
	padding:	0 10px 0 0 !important;
	background: none !important;
}
.defaultForm ul.defaultFormList.defaultFormListPadding li.cell_2,
.defaultForm ul.defaultFormList.defaultFormListPadding li.cell_3,
.defaultForm ul.defaultFormList.defaultFormListPadding li.cell_4 {
	padding: 2px 0 0 !important;
	background: none !important;
}
</style>
<title>Insert title here</title>
</head>
<body>
<p>Hello World</p>
<form name="NameOFWebForm" method="post" class="defaultForm" id="defaultForm" action="./GoToServlet001" >
<div class="globalTableLayout noMargin">

			<div class="formSpacer area">
				<label>test</label>
				<input type="text" class="defaultFormInputtext" name="test" value="test_1" />
			</div>
<div class="formSpacer area">
			<label>Name</label>
	
			<input name="NameOFWebForm_Name" class="defaultFormInputtext" type="text" value="${ BeanForServlet001.name }" maxlength="20" size="22" tabindex="1"/><br />
		</div>

<div class="globalTableLayout-Row">
			<div class="globalTableLayout-Cell cell_1">
			<label>FirstName</label>
</div>
			<div class="globalTableLayout-Cell cell_2">		
			<input name="NameOFWebForm_FirstName" type="text" value="${ BeanForServlet001.firstName }" maxlength="20" size="22" tabindex="2"/><br />
	</div>
		</div>	



<input name="NameOFWebForm_Submit" value="Apply" type="submit" tabindex="3"/>
</div>
</form>

<c:forEach var="message" items="${ BeanForServlet001.errorList }" > 
  <c:out value="${message}"></c:out><br />
</c:forEach>

<c:url value="http://localhost:8080/dalieweb/GoToServlet001" var="url" context="hello">
  <c:param name="Name" value="${BeanForServlet001.name}"/> 
</c:url> 

<script type="text/javascript">

	$(document).ready(function() {
		$('input:text:first').focus();

		$('input:text').bind("keyup", function() {
			var numberOfInputs = $('input:text').length;
			var maxlength = $(this).attr("maxlength");
			var countChar = $(this).val().length;
			var nextIndex = $('input:text').index(this) + 1;
			if (countChar == maxlength) { //Enter key
				if (nextIndex <= numberOfInputs){
					$('input:text')[nextIndex].focus();
				
				}
			}
		});

	});
</script>
</body>
</html>