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
	<div id="simulator-container">
		<div id="particles">
			<span style="z-index: 1">Welcome To Order Book</span>
		</div>
	</div>
	<%@include file="includes/resources.jsp"%>
	<script>
    $(document).ready(function() {
        particlesJS.load('particles', '/order-book/js/particles/particles.json', function() {
            console.log('callback - particles.js config loaded');
        });
    });
</script>
</body>
</html>