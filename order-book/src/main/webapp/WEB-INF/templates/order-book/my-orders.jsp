<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
