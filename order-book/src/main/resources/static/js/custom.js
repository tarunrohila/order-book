var URLs = {
	toggleStatus : '/order-book/toggle-status',
	deleteOrderBook : '/order-book/delete-order-book'
};


function updateStatus(instrumentId) {
	$.ajax({
		type: "POST",
		url: URLs.toggleStatus,
		dataType: "html",
		data :  {
			instrumentId : instrumentId
		},
	beforeSend: function(){
	},
	success: function(data){
		window.location.href = "";
	},
	error: function(xhr,textStatus,err){
	}
	});
}


