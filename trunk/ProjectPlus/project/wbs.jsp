<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>jOrgChart - A jQuery OrgChart Plugin</title>
		<link rel="stylesheet" href="/js/tree/css/jquery.jOrgChart.css"/>
		<link rel="stylesheet" href="/js/tree/css/custom.css"/>
		<link href="/js/tree/css/prettify.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="/js/tree/prettify.js"></script>
		<!-- jQuery includes -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script><script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
		<script src="/js/tree/jquery.jOrgChart.js"></script>
		<script>
            $(document).ready(function() {

                // 測試與伺服器拿取WBS Tree
				var projectId = <%= request.getParameter("id")%>;
                $.getJSON('/ProjectAction.do', {
                    op : 8,projectId:projectId
                }, function(data) {

                    var size = data.length, // 節點大小
                		index;              // 迴圈用變數

                    for( index = 0; index < size; index++) {

                        var content = '<li name="' + data[index].name + '">' + '<div><a>' + data[index].name + '</a></div>' + '<div><a>' + data[index].descript + '</a></div>' + '<ul name="' + data[index].name + '"></ul>' + '</li>';
                        // 如果為根節點
                        if(data[index].parent == "") {
                            $("#org").append(content);
                        }
                        // 不是根節點
                        else {
                            $('ul[name="' + data[index].parent + '"]').append(content);
                        }
                    }

                    // 使用jQrgChart創建樹狀表格
                    $("#org").jOrgChart({
                        chartElement : '#chart',
                        dragAndDrop : false
                    });

                });

                $("#show-list").click(function(e) {
                    e.preventDefault();

                    $('#list-html').toggle('fast', function() {
                        if($(this).is(':visible')) {
                            $('#show-list').text('Hide underlying list.');
                            $(".topbar").fadeTo('fast', 0.5);
                        } else {
                            $('#show-list').text('Show underlying list.');
                            $(".topbar").fadeTo('fast', 1);
                        }
                    });
                });

                $('#list-html').text($('#org').html());

                $("#org").bind("DOMSubtreeModified", function() {
                    $('#list-html').text('');

                    $('#list-html').text($('#org').html());

                    prettyPrint();
                });
            });

		</script>
	</head>
	<body onload="prettyPrint();">
		<!--存放樹狀結構的ul,li-->
		<ul id="org" style="display:none"></ul>
		<!--END - 存放樹狀結構的ul,li-->
		<!--最後用來顯示樹狀圖的地方-->
		<div id="chart" class="orgChart"></div>
		<!--END - 最後用來顯示樹狀圖的地方-->
	</body>
</html>