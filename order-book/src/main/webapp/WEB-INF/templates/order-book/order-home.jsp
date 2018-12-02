<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@include file="../includes/head.jsp"%>
</head>
<body>
	<%@include file="../includes/navigation/navigation.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<table
					class="table table-striped table-bordered table-hover table-condensed"
					id="" style="width: 99%;">
					<tr>
						<td><h3 class="page-header">Select Instrument</h3></td>
						<td><select class="form-control" id="selectedInstrumentId"
							for="buyOrderType" onchange="openBuyAndSell($(this).val())">
								<option hidden>Please select</option>
								<c:forEach items="${instruments}" var="instrument">
								<option value='<c:out value="${instrument.instrumentId}"></c:out>'>${instrument.instrumentName}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
			</div>
		</div>
		<div style="clear: both;"></div>

		<div class="row" id="buyAndSellWindow" style="display: none">
			<div class="col-lg-6">
				<div class="card-box"
					style="box-shadow: 10px 0 10px 10px rgba(0, 0, 0, 0.05)">
					<div class="row">
						<div class="col-lg-6">
							<h3 class="page-header">Buy</h3>
						</div>
					</div>
					<div class="card-box-body">
						<div class="table-responsive">
							<table
								class="table table-striped table-bordered table-hover table-condensed"
								id="" style="width: 99%;">
								<tr>
									<td>Order Type</td>
									<td><select id="buyOrderType" class="form-control"
										for="buyOrderType" onchange="toggleBuyPrice()">
											<option hidden>Please select</option>
											<option value="limit">Limit</option>
											<option value="market">Market</option>
									</select></td>
								</tr>
								<tr>
									<td>Quantity</td>
									<td><input type="text" id="buyQty"></input></td>
								</tr>
								<tr id="buyPrice">
									<td>Price</td>
									<td><input type="text" id="limitBuyPrice"></input></td>
								</tr>
								<tr>
									<td colspan="2">
										<button id="buyOrderBtn" type="button"
											class="btn btn-primary btn-lg btn-block" onclick="javascript:buyOrder()">
											<i class="fa fa-pencil-square-o"></i> Buy
										</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-6">

				<div class="card-box"
					style="box-shadow: 10px 0 10px 10px rgba(0, 0, 0, 0.05)">
					<div class="row">
						<div class="col-lg-6">
							<h3 class="page-header">Sell</h3>
						</div>
					</div>
					<div class="card-box-body">

						<div class="table-responsive">
							<table
								class="table table-striped table-bordered table-hover table-condensed"
								id="" style="width: 99%;">
								<tr>
									<td>Order Type</td>
									<td><select id="sellOrderType" class="form-control"
										onchange="toggleSellPrice()">
											<option hidden>Please select</option>
											<option value="limit">Limit</option>
											<option value="market">Market</option>
									</select></td>
								</tr>
								<tr>
									<td>Quantity</td>
									<td><input type="text" id="sellQty"></input></td>
								</tr>
								<tr id="sellPrice">
									<td>Price</td>
									<td><input type="text" id="limitSellPrice"></input></td>
								</tr>
								<tr>
									<td colspan="2">
										<button id="sellOrderBtn" type="button" class="btn btn-primary btn-lg btn-block" onclick="javascript:sellOrder()">
											<i class="fa fa-pencil-square-o"></i> Sell
										</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
<div style="clear: both;"></div>
<div class="row">
        <div class="col-lg-12">
            <div class="card-box" style=" box-shadow: 10px 0 10px 10px rgba(0, 0, 0, 0.05)">

                <div class="card-box-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover table-condensed" id="orderBookTable" style="width: 99%;">
                            <thead>
                            <tr>
                            <th>Instrument</th>
                                <th>Order</th>
                                <th>Order Type</th>
                                <th>Status</th>
                                <th>Create Date</th>
                                <th>Execution Price</th>
                                <th>Execution Qty</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${orders}" var="order">
                                <tr>
                                    <td>${order.instrument.name}</td>
                                    <td>${order.transactionType}</td>
                                    <td>${order.orderType}</td>
                                    <td>${order.status}</td>
                                    <td>${order.orderCreationDate}</td>
                                    <td>${order.executionPrice}</td>
                                    <td>${order.executionQuantity}</td>
                                </tr>
                                
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
</div>
    </div>
	</div>
	<%@include file="../includes/footer.jsp"%>
	<%@include file="../includes/resources.jsp"%>
	<script>
		$(document).ready(function() {
			$('#instrumentTable').DataTable({
				"pageLength" : 15,
				"lengthChange" : false,
				"aoColumnDefs" : [ {
					'bSortable' : false,
					'aTargets' : [ 7 ]
				} ],
				"order" : [ [ 0, "asc" ] ]
			});

			$("#search-input").on("keyup search input paste cut", function() {
				$('#instrumentTable').DataTable().search(this.value).draw();
			});
		});
		function toggleBuyPrice() {
			var type = $('#buyOrderType').val();
			if (type == "limit") {
				$("#buyPrice").show();

			} else if (type == "market") {
				$("#buyPrice").hide();
			}
		}
		function toggleSellPrice() {
			var type = $('#sellOrderType').val();
			if (type == "limit") {
				$("#sellPrice").show();

			} else if (type == "market") {
				$("#sellPrice").hide();
			}
		}
		function openBuyAndSell(selectObject) {
				$("#buyAndSellWindow").show();
		}
		
		function buyOrder() {
			var buyOrderType = $("#buyOrderType").val();
			var limitBuyPrice = $("#limitBuyPrice").val();
			var buyQty = $("#buyQty").val();
			var instrumentId = $("#selectedInstrumentId").val();
			$.ajax({
				type: "POST",
				url: "buy-order",
				dataType: "html",
				data :  {
					buyOrderType : buyOrderType,
					limitBuyPrice : limitBuyPrice,
					buyQty : buyQty,
					instrumentId : instrumentId
				},
			beforeSend: function(){
			},
			success: function(data){
			},
			error: function(xhr,textStatus,err){
			}
			});
	}
		
		function sellOrder() {
			var sellOrderType = $("#sellOrderType").val();
			var limitSellPrice = $("#limitSellPrice").val();
			var sellQty = $("#sellQty").val();
			var instrumentId = $("#selectedInstrumentId").val();
			$.ajax({
				type: "POST",
				url: "sell-order",
				dataType: "html",
				data :  {
					sellOrderType : sellOrderType,
					limitSellPrice : limitSellPrice,
					sellQty : sellQty,
					instrumentId : instrumentId
				},
			beforeSend: function(){
			},
			success: function(data){
			},
			error: function(xhr,textStatus,err){
			}
			});
	}
	</script>
</body>
</html>