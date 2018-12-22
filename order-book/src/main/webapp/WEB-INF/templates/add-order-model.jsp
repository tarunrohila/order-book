<div id="addOrderModel" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Add Order</h4>
			</div>
			<div class="modal-body">
				<div class="well well-sm">Please provide below details to add
					order</div>
				<form id="addOrderForm" role="form" autocomplete="off" class="form-horizontal"
					action="javascript:addOrder()">
					<input type="hidden" id="instrumentName" />
					<div class="form-group">
                            <label class="col-lg-3 control-label" for="orderType">Order Type: </label>
                            <div class="col-lg-6">
                                <select id="orderType" class="form-control">
                                    <option hidden>Please select</option>
                                    <option value="limit" >Limit Order</option>
                                    <option value="market" >Market Order</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label" for="qty">Quantity: </label>
                            <div class="col-lg-6">
                                <input type="text" class="form-control" id="qty">
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-lg-3 control-label" for="price">Price: </label>
                            <div class="col-lg-6">
                                <input type="text" class="form-control" id="price">
                            </div>
                        </div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-success"
					onclick="$('#addOrderForm').submit()">Add order</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
<script>
	function addOrder() {
		$("#addOrderModel").modal("hide");
		var qty = $("#qty").val();
		var price = $("#price").val();
		var instrumentName = $("#instrumentName").val();
		var orderType = $("#orderType").val();
		$.ajax({
			type : "POST",
			url : instrumentName + "/add-order",
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			dataType : "json",
			data : JSON.stringify({
				"price" : price,
				"quantity" : qty,
				"orderType" : orderType
			}),

			beforeSend : function() {
			},
			success : function(data) {
			},
			error : function(xhr, textStatus, err) {
				$("#msg").html(xhr.responseText);
				$("#msg").show();
			}
		});
	}
</script>