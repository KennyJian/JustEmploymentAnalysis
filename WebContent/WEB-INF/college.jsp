<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-3.2.1.min.js"></script>
<title>全校毕业工作及升学情况</title>
<style type="text/css">
 #tb{
	   	 	border-width: 1px 0px 0px 1px;
	   	 	border-collapse:collapse;
	   	 	text-align: center;
	   	 //   background: deepskyblue;
	   	 }
	   	 
</style>


	</head>
<body>

	<div >
	<table    cellpadding="0" cellspacing="0" id="tb" class="table table-striped" >
		<caption>全校毕业工作及升学情况</caption>
		<tr>
		    <td>学院</td>
			<td>专业</td>
			<td>毕业人数</td>
			<td>升学人数</td>
			<td>升学比例</td>
			<td>出国人数</td>
			<td>出国比例</td>
			<td>就业人数</td>
			<td>就业比例</td>
			<td>灵活就业人数</td>
			<td>灵活就业比例</td>
		</tr>
		<c:forEach items="${college}" var="college"   >
	
		<tr>
		    <td>${college.business_college2}</td>
			<td>${college.business_major2}</td>
			<td>${college.business_graduation}</td> 
			 <td>${college.business_school}</td> 
			 <td><fmt:formatNumber type="number" value="${college.business_school/college.business_graduation*100} " maxFractionDigits="2"/>%</td>
			  <td >${college.business_abroad}</td>
            <td><fmt:formatNumber type="number" value="${college.business_abroad/college.business_graduation*100} " maxFractionDigits="2"/>%</td>
             <td >${college.business_work}</td>
            <td><fmt:formatNumber type="number" value="${college.business_work/college.business_graduation*100} " maxFractionDigits="2"/>%</td>
			<td >${college.business_agile}</td>
            <td><fmt:formatNumber type="number" value="${college.business_agile/college.business_graduation*100} " maxFractionDigits="2"/>%</td>
      	</tr>
		
		</c:forEach>
		<c:forEach items="${college3}" var="college3"   >
		<tr>
		    <td>${college3.ship_college2}</td>
			<td>${college3.ship_major2}</td>
			<td>${college3.ship_graduation}</td> 
			 <td>${college3.ship_school}</td> 
			 <td><fmt:formatNumber type="number" value="${college3.ship_school/college3.ship_graduation*100} " maxFractionDigits="2"/>%</td>
			  <td >${college3.ship_abroad}</td>
            <td><fmt:formatNumber type="number" value="${college3.ship_abroad/college3.ship_graduation*100} " maxFractionDigits="2"/>%</td>
             <td >${college3.ship_work}</td>
            <td><fmt:formatNumber type="number" value="${college3.ship_work/college3.ship_graduation*100} " maxFractionDigits="2"/>%</td>
			<td >${college3.ship_agile}</td>
            <td><fmt:formatNumber type="number" value="${college3.ship_agile/college3.ship_graduation*100} " maxFractionDigits="2"/>%</td>
      	</tr>
      	</c:forEach>
      	<c:forEach items="${college2}" var="college2"   >
		<tr>
		    <td>${college2.education_college2}</td>
			<td>${college2.education_major2}</td>
			<td>${college2.education_graduation}</td> 
			 <td>${college2.education_school}</td> 
			 <td><fmt:formatNumber type="number" value="${college2.education_school/college2.education_graduation*100} " maxFractionDigits="2"/>%</td>
			  <td >${college2.education_abroad}</td>
            <td><fmt:formatNumber type="number" value="${college2.education_abroad/college2.education_graduation*100} " maxFractionDigits="2"/>%</td>
             <td >${college2.education_work}</td>
            <td><fmt:formatNumber type="number" value="${college2.education_work/college2.education_graduation*100} " maxFractionDigits="2"/>%</td>
			<td >${college2.education_agile}</td>
            <td><fmt:formatNumber type="number" value="${college2.education_agile/college2.education_graduation*100} " maxFractionDigits="2"/>%</td>
      	</tr>
      	</c:forEach>
      	<c:forEach items="${college4}" var="college4"   >
      	<tr>
		    <td>${college4.gold_college2}</td>
			<td>${college4.gold_major2}</td>
			<td>${college4.gold_graduation}</td> 
			 <td>${college4.gold_school}</td> 
			 <td><fmt:formatNumber type="number" value="${college4.gold_school/college4.gold_graduation*100} " maxFractionDigits="2"/>%</td>
			  <td >${college4.gold_abroad}</td>
            <td><fmt:formatNumber type="number" value="${college4.gold_abroad/college4.gold_graduation*100} " maxFractionDigits="2"/>%</td>
             <td >${college4.gold_work}</td>
            <td><fmt:formatNumber type="number" value="${college4.gold_work/college4.gold_graduation*100} " maxFractionDigits="2"/>%</td>
			<td >${college4.gold_agile}</td>
            <td><fmt:formatNumber type="number" value="${college4.gold_agile/college4.gold_graduation*100} " maxFractionDigits="2"/>%</td>
      	</tr>
      	</c:forEach>
      	<c:forEach items="${college5}" var="college5"   >
      	<tr>
		    <td>${college5.electricity_college2}</td>
			<td>${college5.electricity_major2}</td>
			<td>${college5.electricity_graduation}</td> 
			 <td>${college5.electricity_school}</td> 
			 <td><fmt:formatNumber type="number" value="${college5.electricity_school/college5.electricity_graduation*100} " maxFractionDigits="2"/>%</td>
			  <td >${college5.electricity_abroad}</td>
            <td><fmt:formatNumber type="number" value="${college5.electricity_abroad/college5.electricity_graduation*100} " maxFractionDigits="2"/>%</td>
             <td >${college5.electricity_work}</td>
            <td><fmt:formatNumber type="number" value="${college5.electricity_work/college5.electricity_graduation*100} " maxFractionDigits="2"/>%</td>
			<td >${college5.electricity_agile}</td>
            <td><fmt:formatNumber type="number" value="${college5.electricity_agile/college5.electricity_graduation*100} " maxFractionDigits="2"/>%</td>
      	</tr>
      	</c:forEach>
      	<c:forEach items="${college6}" var="college6"   >
      	<tr>
		    <td>${college6.telecom_college2}</td>
			<td>${college6.telecom_major2}</td>
			<td>${college6.telecom_graduation}</td> 
			 <td>${college6.telecom_school}</td> 
			 <td><fmt:formatNumber type="number" value="${college6.telecom_school/college6.telecom_graduation*100} " maxFractionDigits="2"/>%</td>
			  <td >${college6.telecom_abroad}</td>
            <td><fmt:formatNumber type="number" value="${college6.telecom_abroad/college6.telecom_graduation*100} " maxFractionDigits="2"/>%</td>
             <td >${college6.telecom_work}</td>
            <td><fmt:formatNumber type="number" value="${college6.telecom_work/college6.telecom_graduation*100} " maxFractionDigits="2"/>%</td>
			<td >${college6.telecom_agile}</td>
            <td><fmt:formatNumber type="number" value="${college6.telecom_agile/college6.telecom_graduation*100} " maxFractionDigits="2"/>%</td>
      	</tr>
      	</c:forEach>
	</table>

<a>导出表格</a>



<script>
 //实现导出execl表格
  var html = "<html><head><meta charset='utf-8' /></head><body><div>" + document.getElementsByTagName("table")[0].outerHTML + "</div></body></html>";
  var blob = new Blob([html], { type: "application/vnd.ms-excel"});
  var a = document.getElementsByTagName("a")[0];
  a.href = URL.createObjectURL(blob);
  a.download = "全校毕业工作及升学情况.xls";

</script>
</div>
</body>
</html>