<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Add Instrument
				</h1>
			</div>
		</div>
		<div id="addMsg" class="alert alert-success" style="display: none"></div>
<form:form  role="form" class="form-horizontal" id="instrument-form" modelAttribute="instrumentObject">
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
									<form:input type="text" class="form-control" path="instrumentName" id="instrumentName"
										placeholder="Enter Name" name="instrumentName"></form:input>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-offset-1 col-lg-10">
				<form:button id="addInstrumentBtn" type="button" onclick="javascript:addInstrument()" class="btn btn-primary btn-lg btn-block"><i class="fa fa-pencil-square-o"></i>
					Add Instrument
				</form:button>
			</div>
		</div>
		</form:form>


	</div>
	<script>
	 function addInstrument() {
		 $.ajax({
 			type: "POST",
 			url: "add-instrument",
 			headers: { 
 		        'Accept': 'application/json',
 		        'Content-Type': 'application/json' 
 		    },
 			dataType: "json",
 			data: JSON.stringify({"instrumentName":$('#instrumentName').val()}),
 		    
 		beforeSend: function(){
 		},
 		success: function(data){
 			$("#instruments").hide();
 			$("#home-container").show();
 			$("#home-container").html(data);
 		},
 		error: function(xhr,textStatus,err){
 			$("#addMsg").html(xhr.responseText);
 			$("#addMsg").show();
 		}
 		});
     }
	</script>



