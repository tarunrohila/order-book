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
        <div class="col-lg-12">
            <h1 class="page-header">
                Financial Instruments
            </h1>
        </div>
    </div>
   <%@include file="../search/search.jsp"%>
    <div class="pull-right p-b-10">
        <a class="btn btn-warning btn-sm " href="add-instrument"><i class="fa fa-plus" aria-hidden="true"></i> Create new</a>
    </div>
    <div style="clear: both;"></div>

    <div class="row">
        <div class="col-lg-12">
            <div class="card-box" style=" box-shadow: 10px 0 10px 10px rgba(0, 0, 0, 0.05)">

                <div class="card-box-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover table-condensed" id="instrumentTable" style="width: 99%;">
                            <thead>
                            <tr>
                                <th>Instrument Name</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${instruments}" var="instrument">
                                <tr>
                                    <td>${instrument.instrumentName}</td>
                                    <td><input type="checkbox" data-toggle="toggle" data-on="Active" data-off="Inactive" data-onstyle="success" onchange="updateStatus(${instrument.instrumentId})"
                                              <c:if test = "${instrument.status}">checked</c:if>></td>
                                               <td>
                                    
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="fa fa-cog" title="Settings" aria-hidden="true"></i>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a href="delete-instrument/${instrument.instrumentId}" id="delete-instrument-link"><i class="fa fa-trash" aria-hidden="true"></i>Delete</a></li>
                                            </ul>
                                        </div>

                                    </td>
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
<%@include file="../includes/footer.jsp"%>
<%@include file="../includes/resources.jsp"%>
<script>
    $(document).ready(function () {
        $('#instrumentTable').DataTable({
            "pageLength": 15,
            "lengthChange": false,
            "aoColumnDefs": [
                {'bSortable': false, 'aTargets': [2]}
            ],
            "order": [[0, "asc"]]
        });


        $("#search-input").on("keyup search input paste cut", function () {
            $('#instrumentTable').DataTable().search(this.value).draw();
        });
        prettyPrint();
    });

</script>
</body>
</html>