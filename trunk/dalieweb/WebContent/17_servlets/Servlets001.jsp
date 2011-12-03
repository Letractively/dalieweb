<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script  type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
     google.load("jquery","1.7",{uncompressed:true});
</script>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
}
	label {
		font: bold 0.8em Verdana;
	}
	
	label.error {
		color: red;
	}
	
	form {
		padding: 5px;
	}
	
	.globalTableLayout {
		text-align: left;
	}
	
	.table_Row {
		padding: 2px 5px;
	}
	.table_cell_first  {
		float: left;
		padding: 1px 0px;
		width: 10%;
	}
	.table_cell {
		display: inline;
		padding: 1px 0px;
	}
</style>
<title>dalieweb</title>
</head>
<body>

<form name="NameOFWebForm" method="post" class="defaultForm" id="defaultForm" action="./GoToServlet001" >
<div class="globalTableLayout">
	<div class="table_Row">
		<div class="table_cell_first">

			<label class="error">Vorname</label>
		</div>
		<div class="table_cell">
			<input name="Address.fristName" id="Address.fristName" type="text" class="defaultFormInputtext" value="${ Address.firstName }" size="30" maxlength="20" tabindex="1"/>
		</div>
	</div>
	<div class="table_Row">
		<div class="table_cell_first">

			<label>Name</label>
		</div>
		<div class="table_cell">
			<input name="Address.lastName" id="Address.lastName" type="text" class="defaultFormInputtext" value="${ Address.lastName }" size="30" maxlength="20" tabindex="2"/>
		</div>
	</div>
	<div class="table_Row">
		<div class="table_cell_first">

			<label>Strasse</label>
		</div>
		<div class="table_cell">
			<input name="Address.street1" id="Address.street1" type="text" class="defaultFormInputtext" value="${ Address.street1 }" size="30" maxlength="20" tabindex="3"/>
		</div>
		<div class="table_cell">

			<label>Zusatz</label>
		</div>
		<div class="table_cell">
			<input name="Address.street2" id="Address.street2" type="text" class="defaultFormInputtext" value="${ Address.street2 }" size="30" maxlength="20" tabindex="4"/>
		</div>
	</div>
	<div class="table_Row">
		<div class="table_cell_first"><!-- --></div>

		<div class="table_cell"><!--  --></div>
	</div>
	<div class="table_Row">
		<div class="table_cell_first">

			<label>PLZ</label>
		</div>
		<div class="table_cell">
			<input name="Address.postalCode" id="Address.postalCode" type="text" class="defaultFormInputtext" value="${ Address.postalCode }" size="12" maxlength="5" tabindex="5"/>
		</div>
		<div class="table_cell">

			<label>Stadt</label>
		</div>
		<div class="table_cell">
			<input name="Address.city" id="Address.city" type="text" class="defaultFormInputtext" value="${ Address.city }" size="28" maxlength="20" tabindex="6"/>
		</div>
	</div>
	<div class="table_Row">
		<div class="table_cell_first">

			<label>Land</label>
		</div>
		<div class="table_cell">
			<input name="Address.state" id="Address.state" type="text" class="defaultFormInputtext" value="${ Address.state }" size="30" maxlength="20" tabindex="7"/>
		</div>
	</div>
	<div class="table_Row">
		<div class="table_cell_first"><!-- --></div>

		<div class="table_cell">
			<input name="Address.isSubmitted" id="defaultForm_bottom" class="defaultFormInputbutton" type="submit" value="apply" tabindex="99"/>
		</div>
	</div>
</div>
</form>

<c:forEach var="message" items="${ Address.error }" > 
  <c:out value="${message}"></c:out><br />
</c:forEach>


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