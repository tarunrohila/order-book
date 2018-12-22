<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="execute-order-book-model.jsp"%>
<%@include file="add-order-model.jsp"%>
<div class="container" id="instruments" style="display: none">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">
                Financial Instruments
            </h1>
        </div>
    </div>
    <div id="msg" class="alert alert-success" style="display: none"></div>
    <div class="pull-right p-b-10">
        <a class="btn btn-warning btn-sm " id="add-instrument-url"><i class="fa fa-plus" aria-hidden="true"></i> Create new</a>
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
                                <th>Instrument ID</th>
                                <th>Instrument Name</th>
                                <th></th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script>
function openImportRefDataModal(any) {
	$("#instrumentName").val( any );
    $("#executeOrderBook").modal();
}
function openAddOrderModel(any) {
	$("#instrumentName").val( any );
    $("#addOrderModel").modal();
}
</script>