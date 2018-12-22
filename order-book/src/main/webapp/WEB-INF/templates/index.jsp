<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navigation/navigation.jsp"%>
	<div id="app-container">
		<div id="home-container">
			<div id="particles">
				<span style="z-index: 1">Welcome To Order Book</span>
			</div>
		</div>
		<%@include file="instruments.jsp"%>
	</div>
	<%@include file="includes/footer.jsp"%>
	<%@include file="includes/resources.jsp"%>
	<script type="text/javascript">
		function openBook(any) {
			$.ajax({
				type : "POST",
				url : any+"/open",
				dataType : "html",
				beforeSend : function() {
				},
				success : function(data) {
					$("#msg").html(data);
					$("#msg").show();
				},
				error : function(xhr, textStatus, err) {

					console.log("readyState: " + xhr.readyState);
					console.log("responseText: " + xhr.responseText);
					console.log("status: " + xhr.status);
					console.log("text status: " + textStatus);
					console.log("error: " + err);
				}
			}); 
			
		}
		function closeBook(any) {
			$.ajax({
				type : "PUT",
				url : any+"/close",
				dataType : "html",
				beforeSend : function() {
				},
				success : function(data) {
					$("#msg").html(data);
					$("#msg").show();
				},
				error : function(xhr, textStatus, err) {

					console.log("readyState: " + xhr.readyState);
					console.log("responseText: " + xhr.responseText);
					console.log("status: " + xhr.status);
					console.log("text status: " + textStatus);
					console.log("error: " + err);
				}
			}); 
			
		}
	</script>
</body>
</html>