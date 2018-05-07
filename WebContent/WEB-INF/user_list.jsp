<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<title>就业数据全表</title>
<style type="text/css">
 #tb{
	   	 	border-width: 1px 0px 0px 1px;
	   	 	border-collapse:collapse;
	   	 	text-align: center;
	   	 //   background: deepskyblue;
	   	 }
	   	 
/*  #size{
	   	 	
	   	 	width: 700px;
	   	 	height: 700px;
	   	 }
 */
</style>
<script type="text/javascript">
function xlh(){
var tb = document.getElementById("tb");
var rows = tb.rows.length;

for(var i=0;i<rows;i++){
	tb.rows[0].style.backgroundColor = "#1C86EE";
 if(i%2 == 0){
   tb.rows[i].style.backgroundColor = "#87CEFA";
	}else{
		 tb.rows[i].style.backgroundColor = "#FFFFFF";
	}
  }
}
</script>

</head>
<body >

	<div >
	<table   cellpadding="0" cellspacing="0" id="tb"  class="table table-striped">
		<caption>就业信息数据全表</caption>
		<tr>
			<td>学院</td>
			<td>学号</td>
			<td>姓名</td>
			<td>身份证</td>
			<td>毕业去向</td>
			<td>报到证签发类别</td>
			<td>单位名称</td>
			<td>单位代码</td>
			<td>单位隶属</td>
			<td>所在地区</td>
			<td>单位性质</td>
			<td>就业类别</td>
			<td>未就业类别</td>
			<td>就业状况</td>
			<td>实际工作单位名称</td>
			<td>实际所在地</td>
			<td>单位组织机构代码</td>
			<td>单位行业</td>
			<td>工作职位类别</td>
			<td>生源地区</td>
			<td>报到证号</td>
			<td>上报时间</td>
			<td>操作人</td>
			<td>档案转递单位名称</td>
			<td>档案转递地址</td>
			<td>档案转递邮编</td>
			<td>档案转递联系电话</td>
			<td>档案转递收件人</td>
			<td>性别</td>
			<td>学历</td>
			<td>专业</td>
			<td>师范标志</td>
			<td>困难生类别</td>
			<td>培养方式</td>
			<td>学制</td>
			<td>民族</td>
			<td>政治面貌</td>
			<td>出生日期</td>
			<td>入学时间</td>
			<td>毕业时间</td>
			<td>学位</td>
			<td>专业方向</td>
			<td>编号</td>
			<td>派遣费</td>
			<td>改派原因</td>
			<td>原单位名称</td>
			<td>原报到证号</td>
			<td>学籍变动</td>
			<td>主修外语语种</td>
				
		</tr>
		<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.college}</td>
			<td>${user.student_id}</td>
			<td>${user.name}</td>
			<td>${user.id_card}</td>
			<td>${user.graduation_to}</td>
			<td>${user.report_category}</td>
			<td>${user.company_name}</td>
			<td>${user.company_code}</td>
			<td>${user.company_subjection}</td>
			<td>${user.adderss}</td>
			<td>${user.company_property}</td>
			<td>${user.employment_category}</td>
			<td>${user.non_employment_category}</td>
			<td>${user.employment_status}</td>
			<td>${user.actual_company_name}</td>
			<td>${user.actual_adderss}</td>
			<td>${user.organizing_institution_barcode}</td>
			<td>${user.job_position}</td>
			<td>${user.company_industry}</td>
			<td>${user.student_in}</td>
			<td>${user.registration_number}</td>
			<td>${user.reporting_time}</td>
			<td>${user.operator}</td>
			<td>${user.file_transfer_company}</td>
			<td>${user.file_transfer_address}</td>
			<td>${user.file_transfer_postcode}</td>
			<td>${user.file_transfer_phone}</td>
			<td>${user.file_transfer_recipients}</td>
			<td>${user.sex}</td>
			<td>${user.education}</td>
			<td>${user.major}</td>
			<td>${user.normal_sign}</td>
			<td>${user.difficult_student_category}</td>
			<td>${user.training_mode}</td>
			<td>${user.educational_system}</td>
			<td>${user.nation}</td>
			<td>${user.politics_status}</td>
			<td>${user.birthdate}</td>
			<td>${user.enrolment_time}</td>
			<td>${user.graduation_time}</td>
			<td>${user.degree}</td>
			<td>${user.professional_direction}</td>
			<td>${user.number}</td>
			<td>${user.dispatch_cost}</td>
			<td>${user.change_of_dispatch}</td>
			<td>${user.previous_company_name}</td>
			<td>${user.previous_registration_number}</td>
			<td>${user.student_status_change}</td>
			<td>${user.major_in_foreign_languages}</td>
			
			
		</tr>
		</c:forEach>
	</table>
<a>导出表格</a>

<script>

  var html = "<html><head><meta charset='utf-8' /></head><body><div>" + document.getElementsByTagName("table")[0].outerHTML + "</div></body></html>";
  var blob = new Blob([html], { type: "application/vnd.ms-excel"});
  var a = document.getElementsByTagName("a")[0];
  a.href = URL.createObjectURL(blob);
  a.download = "就业信息数据全表.xls";

</script>
</div>
</body>
</html>