<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<html>
<head>
<%@include file="../includes/head.jsp"%>
</head>
<body>
	<%@include file="../includes/navigation/navigation.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Add Instrument
				</h1>
			</div>
		</div>
<form:form action="add-instrument-form" role="form" class="form-horizontal" id="instrument-form" modelAttribute="instrumentObject" method="POST">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default ">
					<div class="panel-heading">
						<h4>Instrument Info</h4>
					</div>
					<div class="panel-body">
							<div class="form-group">
								<label class="col-lg-3 control-label" for="instrumentName">Instrument Name:
								</label>
								<div class="col-lg-6">
									<form:input type="text" class="form-control" id="instrumentName"
										placeholder="Enter Name" path="instrumentName"></form:input>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label" for="status">Status:
								</label>
								<div class="col-lg-6">
									<form:checkbox path="status" class="checkbox" data-toggle="toggle" data-on="Active" data-off="Inactive" data-onstyle="success"></form:checkbox>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-offset-1 col-lg-10">
				<form:button id="addInstrumentBtn" type="submit"  class="btn btn-primary btn-lg btn-block"><i class="fa fa-pencil-square-o"></i>
					Add Instrument
				</form:button>
			</div>
		</div>
		</form:form>


	</div>
	<%@include file="../includes/footer.jsp"%>
	<%@include file="../includes/resources.jsp"%>
</body>
</html>



