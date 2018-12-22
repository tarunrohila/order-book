 $(document).ready(function() {
	/* function openImportRefDataModal() {
		    $("#importRefDataModal").modal();
		}*/
        particlesJS.load('particles', '/order-book/js/particles/particles.json', function() {
            console.log('callback - particles.js config loaded');
        });

        $("#instruments-list").click(function(){
    		$.ajax({
    			type: "GET",
    			url: "instruments",
    			dataType: "json",
    		beforeSend: function(){
    		},
    		success: function(data){
    			$("#instrumentTable td").remove();

    			$("#home-container").hide();
    			$("#instruments").show();
    			$.each(data, function(i, f) {
    				var obj = JSON.stringify(f.instrumentName)
    			       var tblRow = "<tr>" + "<td>" + f.instrumentId + "</td>" + "<td >" + f.instrumentName +  "</td>" + 
    			       "<td>" + "<div class='btn-group'>" + "<button type = 'button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>" + "<i class='fa fa-cog' title='Settings' aria-hidden='true'>" + "</i>" +"</button>" +"<ul class='dropdown-menu'>"+
    			       "<li>"+"<a onclick='javascript:openBook(" + obj +")'>"+"Open Order Book"+"</a>"+"</li>"
    			       +"<li>"+"<a onclick='javascript:closeBook(" + obj +")'>"+"Close Order Book"+"</a>"+"</li>"
    			       +"<li>"+"<a onclick='javascript:openImportRefDataModal(" + obj +")'>"+"Execute Order Book"+"</a>"+"</li>"
    			       +"</ul>"+"</div>"+ "</td>"+ "<td>" + "<button type = 'button' class='btn btn-default'  aria-haspopup='true' aria-expanded='false' onclick='javascript:openAddOrderModel(" + obj +")'>" + "Add Order" +"</button>" + "</td>"
                                             + "</tr>"
    			       $(tblRow).appendTo("#instrumentTable tbody");
    			    });
    		},
    		error: function(xhr,textStatus,err){
    			
    			console.log("readyState: " + xhr.readyState);
    		    console.log("responseText: "+ xhr.responseText);
    		    console.log("status: " + xhr.status);
    		    console.log("text status: " + textStatus);
    		    console.log("error: " + err);
    		}
    		});
    	});

        $("#add-instrument-url").click(function(){
    		$.ajax({
    			type: "GET",
    			url: "add-instrument-url",
    			dataType: "html",
    		beforeSend: function(){
    		},
    		success: function(data){
    			$("#instruments").hide();
    			$("#home-container").show();
    			$("#home-container").html(data);
    		},
    		error: function(xhr,textStatus,err){
    			
    			console.log("readyState: " + xhr.readyState);
    		    console.log("responseText: "+ xhr.responseText);
    		    console.log("status: " + xhr.status);
    		    console.log("text status: " + textStatus);
    		    console.log("error: " + err);
    		}
    		});
    	});
        
        $("#orderbooks-list").click(function(){
    		$.ajax({
    			type: "GET",
    			url: "order-books-url",
    			dataType: "html",
    		beforeSend: function(){
    			alert("ok");
    		},
    		success: function(data){
    			$("#app-container").html(data);
    		},
    		error: function(xhr,textStatus,err){
    			
    			console.log("readyState: " + xhr.readyState);
    		    console.log("responseText: "+ xhr.responseText);
    		    console.log("status: " + xhr.status);
    		    console.log("text status: " + textStatus);
    		    console.log("error: " + err);
    		}
    		});
    	});
        
        
        
    });

