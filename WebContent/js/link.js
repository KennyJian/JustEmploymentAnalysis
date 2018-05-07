/**
 *
 */

/*jQuery.fn.rowspan = function(colIdx) { //封装的一个JQuery小插件   实现表格某一列相同值合并
	return this.each(function(){
	var that;
	$('tr', this).each(function(row) {
	$('td:eq('+colIdx+')', this).filter(':visible').each(function(col) {
	if (that!=null && $(this).html() == $(that).html()) {
	rowspan = $(that).attr("rowSpan");
	if (rowspan == undefined) {
	$(that).attr("rowSpan",1);
	rowspan = $(that).attr("rowSpan"); }
	rowspan = Number(rowspan)+1;
	$(that).attr("rowSpan",rowspan);
	$(this).hide();
	} else {
	that = this;
	}
	});
	});
	});
	}
	$(function() {

	$("#tb").rowspan(0);//传入的参数是对应的列数从0开始，哪一列有相同的内容就输入对应的列数值
    //$("#tb").rowspan(2);

	}); */


	
/*function getTableContent(id){  //获取表格列累加
    var mytable = document.getElementById(id);
    var data = [];
    var sum1 = 0;
    var sum2 = 0;
    for(var i=0,rows=mytable.rows.length; i<rows; i++){
      for(var j=0,cells=mytable.rows[i].cells.length; j<cells; j++){
        if(!data[i]){
          data[i] = new Array();
        }
        data[i][j] = mytable.rows[i].cells[j].innerHTML;
      }
    }
 
    for(var i=1;i<data.length-1;i++){
           sum1 +=parseInt(data[i][2]);   
    
    } 
    for(var i=1;i<data.length-1;i++){
           sum2 +=parseInt(data[i][3]);   
    
    }
	 console.log(sum1,sum2);

	// $('#graCount').append(sum1);
	  document.getElementById("graCount").innerHTML = sum1;
	  
     //var s2 =  document.getElementById("empCount");
      
      
       document.getElementById("count").write=((sum2/sum1)*100).toFixed(2).toString()+"%";

      
  }
*/
function loadJson(){
	$.getJSON ("data/titleData.json", function (data){
        $.each (data, function (i, item){
        				firstitem = data[i]['data'][0];
						var firstTitleHTML = "<li id='firstTitle" + i + "'>";//<li id='firstTitle1'>
						firstTitleHTML += " <a href='#' onclick=showSecondTitle(" + i +");test(\"" + firstitem.addr + "\",\"" + firstitem.secTitle + "\",\"" + firstitem.type + "\")>";
						 //<a href='#' onclick='showSecondTitle(firstTitle1)>
						firstTitleHTML += item.firTitle + "</a></li>";
            $ ("#title1").append (firstTitleHTML);
        });
  });
}




var frontFirstTitleIndex;

function showSecondTitle(firstTitleIndex){
	clearChart();
	
	cleartable1();
	$("#firstTitle" + frontFirstTitleIndex).removeClass("active");
	//设置第一标题的tag为active
	$("#firstTitle" + firstTitleIndex).addClass("active");
	frontFirstTitleIndex = firstTitleIndex;
	//首先清空第二标题展示区的所有标签
	$ ("#secondTitleShowPlace").empty();
	//接着遍历json文件中json数组中的firstTitleIndex下标的
	$.getJSON ("data/titleData.json", function (data){
				$.each (data[firstTitleIndex]['data'], function (i, item){
					//alert(item.secTitle);
						var secondTitleHTML =
							"<a class='content-a  ' id='" + item.addr + "' onclick=changeSecondTitleStyle(\"" + item.addr + "\");test(\"" + item.addr + "\",\"" + item.secTitle + "\",\"" + item.type + "\") href='#'>" + item.secTitle + "</a>";
						//test("item.addr","item.secTitle");
					
						$ ("#secondTitleShowPlace").append (secondTitleHTML);
				});
	});
}

   //动态添加class
function changeSecondTitleStyle(secondTitleId){
    $("#secondTitleShowPlace a").click(function() {
    	 if($(this).hasClass("active1")){
    		 $(this).siblings('a').removeClass('active1');  // 删除其他兄弟元素的样式
    	     $(this).addClass('active1');                            // 添加当前元素的样式
    	 }else{
    		 $(this).addClass('active1');                            // 添加当前元素的样式
    	 }
        

    });
}

//function xlh(){   //表格间隔颜色方法
//	var tb = document.getElementById("tb");
//	var rows = tb.rows.length;
//	
//	for(var i=0;i<rows;i++){
//		tb.rows[0].style.backgroundColor = "#1C86EE";
//	 if(i%2 == 0){
//	   tb.rows[i].style.backgroundColor = "#87CEFA";
//		}else{
//			 tb.rows[i].style.backgroundColor = "#FFFFFF";
//		}
//	  }
//}

//清除表格类内容
function clearTable(){
	var table = document.getElementById("myTable");
	if(table != null)content.removeChild(table);
}
function cleartable1(){
	document.getElementById("table1").innerHTML = "";
}
//清除echarts类内容
function clearChart(){
	var chartContent = document.getElementById("chartContent");
	if(chartContent != null)content.removeChild(chartContent);
}
//创建新的echarts容器(定高宽的div)
function getChart(){
	cleartable1();
	var chartContent = document.createElement("div");
	chartContent.setAttribute("id","chartContent");
	chartContent.style.height="600px";
	chartContent.style.width="1000px";
	content.appendChild(chartContent);
	return  echarts.init(document.getElementById('chartContent'));
}

//求和
var totalEmployment = 0;
function countTotalEmployment(jsonData){
	totalEmployment = 0;
	for(var p in jsonData){
		var x = parseInt(jsonData[p]);
		totalEmployment += x;
		//alert("total:" + totalEmployment);
	}

	console.log(totalEmployment);
}

//省市的表格方法的调用
function createEmploymentTable(jsonData){
	
	console.log(jsonData);
	countTotalEmployment(jsonData);
	clearTable();
	clearChart();
	var table = document.createElement("table");
	table.setAttribute("id","myTable");
	table.setAttribute("class","table table-striped");
	var tbody = document.createElement("tbody");
   // for(let index in jsonData) {         
    //	console.log("in for:");
    //	console.log( jsonData[index]);
		for(var p in jsonData){
			var tr = document.createElement("tr");
			var td_province = document.createElement("td");
			td_province.innerHTML = p;
			//alert(p.name);
			
			var td_value = document.createElement("td");
			td_value.innerHTML = jsonData[p];
			//alert(p.value);
			
			var td_radio = document.createElement("td");
			var x = parseInt(jsonData[p]);
			td_radio.innerHTML = (Math.round(x / totalEmployment * 10000) / 100.00 + "%");
			tr.appendChild(td_province);
			tr.appendChild(td_value);
			tr.appendChild(td_radio);
			tbody.appendChild(tr);
		}
    
	table.appendChild(tbody);
	//插入整个table
	content.appendChild(table);
}


//创建表格，参数jsonData是json,tableHead是表头组成的数组
function createTable(jsonData,tableHead){
	clearTable();
	clearChart();
	console.log(jsonData);
	console.log(tableHead);
	console.log(content);
	//table
	var table = document.createElement("table");
	table.setAttribute("id","myTable");
	table.setAttribute("class","table table-striped");
	//caption
	var caption = document.createElement("caption");
	caption.innerHTML="就业去向";
	table.appendChild(caption);
	//thead
	//thead.innerHTML="<tr><td>性别</td><td>人数</td></tr>";
	var thead = document.createElement("thead");
	var theadHTML="<tr>";
	for(var item in tableHead){
		theadHTML+="<td>";
		theadHTML+=tableHead[item].toString();
		theadHTML+="</td>";
	}
	theadHTML+="</tr>";
	console.log(theadHTML);
	thead.innerHTML=theadHTML;
	table.appendChild(thead);

	//tbody
	var tbody = document.createElement("tbody");
	for(var p in jsonData){
		var tr = document.createElement("tr");
		var td_key = document.createElement("td");
		td_key.innerHTML=p.toString();
		var td_value = document.createElement("td");
		td_value.innerHTML=jsonData[p].toString();
		tr.appendChild(td_key);
		tr.appendChild(td_value);
		tbody.appendChild(tr);
	}
	table.appendChild(tbody);

	//插入整个table
	content.appendChild(table);
}

//show sex count(饼图)
function createEchartsPie(URL,title){
	$.ajax({
		url:URL,
		type:"post",
		dataType:"json",
		success:function(dataMap){//result接受服务器返回的json内容
			//var thead=["就业方向","人数"];
			//createTable(employStatusMap,thead);
			clearTable();
			clearChart();
			var myChart = getChart();

			var Data=[];
			var item;
			for(var key in dataMap){
				item = new Object;
				item.name=key;
				item.value=dataMap[key];
				Data.push(item);
			}
			console.log(Data);
			// 指定图表的配置项和数据
			var option = {
				    title : {
				        text: title,
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient: 'vertical',
				        x: 'left',
				        data:Data.name
				    },
				    toolbox: {
				        show: true,
				        orient: 'vertical',
				        left: 'right',
				        top: 'center',
				        feature: {
				            dataView: {readOnly: false},
				            restore: {},
				            saveAsImage: {}
				        }
				    },
				    series : [
				        {
				            name: title,
				            type: 'pie',
				            radius : '55%',
				            center: ['55%', '50%'],
				            data: Data,
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		},
		error:function(){
			alert("数据加载失败");
		}
	});
}

//创建echarts柱状图
function createEchartsHistogram(URL,title){//URL -> "ajaxStatistics/nationCount.form"
		$.ajax({
			url:URL,
			type:"post",
			dataType:"json",
			success:function(dataMap){//result接受服务器返回的json内容
				clearTable();
				clearChart();
				var myChart = getChart();
		
				var nameData=[];
				var valueData=[];
				for(var key in dataMap){
					nameData.push(key);
					valueData.push(dataMap[key]);
				}
				console.log(nameData);
				console.log(valueData);
				option = {
						title: {
								text: title,
								left: 'center',
								top: 20,
								textStyle: {
										color: '#ccc'
								}
						},
						color: ['#3398DB'],
						tooltip : {
								trigger: 'axis',
								axisPointer : {            // 坐标轴指示器，坐标轴触发有效
										type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
								}
						},
						grid: {
								left: '3%',
								right: '4%',
								bottom: '3%',
								containLabel: true
						},
						   toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType : {show: true, type: ['line']},
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    calculable : true,
						xAxis : [
								{
										type : 'category',
										data : nameData,
										axisTick: {
												alignWithLabel: true
										}
								}
						],
						yAxis : [
								{
										type : 'value'
								}
						],
						series : [
								{
										name:title,
										type:'bar',
										barWidth: '60%',
										data: valueData,
										barWidth:25,    //柱状图设置粗细
										label : {  //设置数字显示
											show: true,
											position: 'top',
									    	color: 'black'
		
										}
								},
								{
									name:title,
									type:'line',
									data: valueData,
								    color:"#FF0000"
		
		
							}
		
		
						]
				};
				myChart.setOption(option);
			},
			error:function(){
				alert("数据加载失败");
			}
		});
}

function createEchartsMap(URL,title){ //地图
	$.ajax({
		url:URL,
		type:"post",
		dataType:"json",
		success:function(dataMap){//result接受服务器返回的json内容
			clearTable();
			clearChart();

			var myChart = getChart();

			var mapdata=[];
			var item;
			for(var key in dataMap){
				item = new Object;
				item['name']=key;
				item['value']=dataMap[key];
				mapdata.push(item);
			}
			console.log(mapdata);
				var option = {
				    title: {
				        text: title,
				        left: 'center'
				    },
				    tooltip: {
				        trigger: 'item'
				    },
				    legend: {
				        orient: 'vertical',
				        left: 'left',
				        data:['mapdata']
				    },
				     visualMap: {
				        min: 0,
				        max: 2500,

				        text: ['高','低'],           // 文本，默认为数值文本
				        calculable: true
				    },
				    toolbox: {
				        show: true,
				        orient: 'vertical',
				        left: 'right',
				        top: 'center',
				        feature: {
				            dataView: {readOnly: false},
				            restore: {},
				            saveAsImage: {}
				        }
				    },

				    series: [
				        {
				            name: title,
				            type: 'map',
				            mapType: 'china',
				            label: {
				                normal: {
				                    show: true
				                },
				                emphasis: {
				                    show: true
				                }
				            },
				            data: mapdata
				        }
				    ]
				};

			myChart.setOption(option);
		
		},
		error:function(){
			alert("数据加载失败");
		}
	});
}
function createEchartsTable(URL,title){
	
	$.ajax({
		url:URL,                          //"ajaxStatistics/actualaddressCount.form",
		type:"post",
		dataType:"json",
		success:function(actualaddressMap){//result接受服务器返回的json内容
			clearTable();
			cleartable1();
			clearChart();
			createEmploymentTable(actualaddressMap);
		},
		error:function(){
			alert("数据加载失败");
		}
	});
}
function createEcharts(URL,title,gramType){
	switch(gramType){
	case "Histogram":
		createEchartsHistogram(URL,title);//"ajaxStatistics/collegeCount.form"
		break;
	case "Pie":
		createEchartsPie(URL,title);
		break;
	case "Map":
		createEchartsMap(URL,title);
		break;
	case "Table":
		createEchartsTable(URL,title);
		break;
	default :
		createEchartsHistogram(URL,title);//"ajaxStatistics/collegeCount.form"
		break;
	}
	
}

function test(type,title,gramType){
	
	if(type.indexOf(".")==-1){ //等于-1表示这个字符串中没有.这个字符
		//生成echarts
		//alert(type);
		
		createEcharts("ajaxStatistics/" + type + ".form" , title,gramType);		
	}else{
		console.log(type);
		var table1 = document.getElementById("table1");
		/*if(table != null)content.removeChild(table);*/
		clearChart();
		clearTable();
		table1.innerHTML="<iframe  src='"+ type+"' frameborder='no' width=1100 height=1000></iframe>";
	}
	
}


