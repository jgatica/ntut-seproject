<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="jquery-1.6.2.js"></script>


<script type = "text/javascript">
	
	function onClick(){
		alert("You click it !!");
	}
	
	function onMouseOver(event){
		this.style.color = "#990000";
	}	
	
	function onMouseOut(event){
		this.style.color = "black";
	}

	
	/* Jquery 版本*/
	$(document).ready(function(){
		
		// 動態載入資料
		$.getJSON('GradeAction.do', {op : "4"}, function(data) {
			var content = "";
			console.log(data);
			
			for(var i = 0; i < data.length ; i++){
				var index = i%2;
				if(index == 1){
					content += "<tr class='even'>";
				}
				else {
					content += "<tr class='odd'>";
				}
				content += "<td class='grade'>" +  data[i].grade + "</td>";
				content += "<td class='lastupdtime'>" +  data[i].lastupdtime + "</td>";
				content += "<td class='mrscid'>" +  data[i].mrscid + "</td>";
				content += "<td class='orderid'>" +  data[i].orderid + "</td>";
				content += "<td id='remark' name='remark'>" +  data[i].remark + "</td>";
				content += "<td class='viprovid'>" +  data[i].viprovid + "</td>";
				content += "<td>" +  "<input type='button' value='顯示' onclick=\"javascript:alert('" + data[i].remark + "')\">" + "</td>";
				/*
				var form = "<form action='GradeAction.do'>";
				form += "<input type='hidden' name='op' value='2'>";
				form += "<input type='hidden' name='mrscid' value='"+ data[i].mrscid +"'>";
				form += "<input type='hidden' name='viprovid' value='"+ data[i].viprovid +"'>";
				form += "<input type='hidden' name='orderid' value='"+ data[i].orderid +"'>";
				form += "<input type='text' name='remark'>";
				form += "<input type='submit' value='更新'>";
				form += "</form>";
				content += "<td>" +  form + "</td>";
*/
				content += "</tr>";
			}
			
			$("#myTable").append(content);
			$("tr:even").css("backgroundColor","#66FFCC");
			$("tr:odd").css("backgroundColor","#FFFFCC");
			
			
			var tds = $('td#remark');
			tds.click(function(){
				
				var tdObj = $(this);
				if (tdObj.children("input").length > 0) {
					return false;
				}
				var text = tdObj.html(); 
				tdObj.html("");
				var inputObj = $("<input type='text'>").css("border-width","0")
				.css("font-size","16px").width(tdObj.width())
				.css("background-color",tdObj.css("background-color"))
				.val(text).appendTo(tdObj);
				inputObj.trigger("focus").trigger("select");
				inputObj.click(function() {
					return false;
				});
				inputObj.keyup(function(event){
					var keycode = event.which;
					if (keycode == 13) {
						var inputtext = $(this).val();
						tdObj.html(inputtext);
						// 在這裡處理更新的方法
						// 取得tr
						var tr = tdObj.parent();
						
						var op = "2";
						var grade = $(tr).children(".grade").html();
						var mrscid = $(tr).children(".mrscid").html();
						var viprovid = $(tr).children(".viprovid").html();
						var remark = inputtext;
						var orderid = $(tr).children(".orderid").html();

						$.post("GradeAction.do", { grade: grade, mrscid: mrscid, viprovid: viprovid, remark: remark, orderid: orderid, op: op  }, function(data) {
							alert( data + " 更新成功" );
						});
						
					}
					if (keycode == 27) {
						tdObj.html(text);
					}
				});
				
			});
			
			
		});		
		
		// odd's style
		$(".odd").live('mouseout',onMouseOut).live('mouseover',onMouseOver);
		$(".even").live('mouseout',onMouseOut).live('mouseover',onMouseOver);
		
		$("#close").click(function(){
			$("#addContain").html("");
		});
		
		/*步驟四  秀Remark*/
		$(".showremark").live('click',function(){
			var num = this.name;
			alert($(".remark").get(num).innerHTML);
			
		});
	});
	
	// 動態載入addgrade.jsp檔案
	$(function(){
		$("#add").click(function(){
			//使用異步傳輸，可以接收不同的參數(key-value)
			$.ajax({
				type: "POST",
				url: "addgrade.jsp",
				dataType: "html",
				success: function(returnedData){
					$("#addContain").html("<h1>新增資料</h1>"+returnedData);
				}
			});
		});
	});
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>評價紀錄列表</title>
<meta content="text/html;charset=UTF-8" />

</head>

<body>

	<div style="background-color:#99FFCC; width:100%;">
		<table id="myTable"></table>
		<div id="addContain">
			
		</div>
		
		<input type="button" id="add" value="加入新資料">
		<input type="button" id="close" value="關閉">
		<input type="button" class="showremark" value="showRemark">
	</div>
</body>
</html>
