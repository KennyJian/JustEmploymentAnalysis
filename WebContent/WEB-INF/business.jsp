<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script> 
<link rel="stylesheet" href="css/bootstrap.min.css" />


<title>分学院及专业就业率</title>
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
		<caption>商学院专业就业率</caption>
		<tr>
		    <td>学院</td>
			<td>专业</td>
			<td>毕业人数</td>
			<td>就业人数</td>
			<td>就业率</td>
				
		</tr>
		<c:forEach items="${business}" var="business"  varStatus="loop" >
	
		<tr>
		    <td>${business.business_college}</td>
			<td>${business.business_major}</td>
			 <td class="count1" >${business.business_graduate_count}</td> 
			<td class="count2">${business_gra[loop.count-1].business_employment_count}</td>
            <td><fmt:formatNumber type="number" value="${business_gra[loop.count-1].business_employment_count/ business.business_graduate_count*100} " maxFractionDigits="2"/>%</td>
      	</tr>
		
		</c:forEach>
		<tr id="tr">
		
		<td colspan="2">总人数</td>
		<td id=""><c:out value="${gr_count} " ></c:out></td>
		<td id=""><c:out value="${empCount} " ></c:out></td>
		<td id="count"><fmt:formatNumber type="number" value="${empCount/gr_count*100} " maxFractionDigits="2"/>%</td>
		</tr>
	</table>

<a>导出表格</a>



<script>
 //实现导出execl表格
  var html = "<html><head><meta charset='utf-8' /></head><body><div>" + document.getElementsByTagName("table")[0].outerHTML + "</div></body></html>";
  var blob = new Blob([html], { type: "application/vnd.ms-excel"});
  var a = document.getElementsByTagName("a")[0];
  a.href = URL.createObjectURL(blob);
  a.download = "商学院专业就业率.xls";

</script>
</div>
</body>
</html>