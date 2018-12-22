<div id="executeOrderBook" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Execute Order Book</h4>
			</div>
			<div class="modal-body">
				<div class="well well-sm">Please provide below details to
					execute order book</div>

				<form id="executeOrderBookForm" role="form" autocomplete="off" class="form-horizontal"
					action="javascript:executebook()">
					<input type="hidden" id="instrumentName" />
					<div class="form-group">
                            <label class="col-lg-3 control-label" for="qty">Execution Quantity: </label>
                            <div class="col-lg-6">
                                <input type="text" class="form-control" id="executionQty">
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-lg-3 control-label" for="price">Execution Price: </label>
                            <div class="col-lg-6">
                                <input type="text" class="form-control" id="executionPrice">
                            </div>
                        </div>


				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-success"
					onclick="$('#executeOrderBookForm').submit()">Execute</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>
<script>
	function executebook() {
		$("#executeOrderBook").modal("hide");
		var executionQty = $("#executionQty").val();
		var executionPrice = $("#executionPrice").val();
		var instrumentName = $("#instrumentName").val();
		$.ajax({
			type : "PUT",
			url : instrumentName + "/execute",
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			dataType : "json",
			data : JSON.stringify({
				"executionQuantity" : executionQty,
				"executionPrice" : executionPrice
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