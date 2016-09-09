
$(document).ready(function () {
	$("#number").validate();
	if ($("#status").val() != "") {
		alert($("#status").val());
	}
	var id;
	var name;
	var i;
	var number;
	$("button").click(function () {
		id = this.id; // this就是当前产生事件的button
		name = $("#" + id).attr("name");
		i = $("#" + id).attr("class");
		$("#gid").attr("value", $("#gid" + i).val());
		number = $("#number" + i).val();
		if (name == "add") {
			$("#number" + i).attr("value", ++number);
			$("#number").attr("value", number);
			$("#bus").submit();
		} else {
			if (name == "minus") {
				if ($("#number" + i).val() > 1) {
					$("#number" + i).attr("value", --number);
					$("#number").attr("value", number);
					$("#bus").submit();
				} else {
					$("#number" + i).attr("value", 1);
					$("#number").attr("value", 1);
					$("#bus").submit();
				}
			}
		}
	});
	$(".number").change(function () {
		id = this.id;
		i = $("#" + id).attr("name");
		$("#gid").attr("value", $("#gid" + i).val());
		if (/^\d+$/.test($("#" + id).val())) {
			if ($("#" + id).val() > 0) {
				$("#" + id).attr("value", $("#" + id).val());
				$("#number").attr("value", $("#" + id).val());
				$("#bus").submit();
			} else {
				alert("\u9009\u8d2d\u6570\u91cf\u4e0d\u80fd\u5c0f\u4e8e1\uff01");
				$("#" + id).attr("value", 1);
				$("#number").attr("value", 1);
				$("#bus").submit();
			}
		} else {
			alert("\u8f93\u5165\u9519\u8bef\uff0c\u9009\u8d2d\u6570\u91cf\u5e94\u8be5\u662f\u4e0d\u5c0f\u4e8e1\u7684\u6570\u5b57\uff01");
			$("#" + id).attr("value", 1);
			$("#number").attr("value", 1);
			$("#bus").submit();
		}
	});
	$("#myinf a").click(function () {
		var url = $(this).attr("href");
		$("#right").load(url);
		return false;
	});
	$("#goodManage a").click(function () {
		var url = $(this).attr("href");
		$("#right").load(url);
		return false;
	});
});

