$(document).ready(function () {
	var price = $("#price").val();
	var carriage = $("#carriage").val();
	$("#number").validate();
	var number = $("#number").val();
	$("#number").change(function () {
		if (/^\d+$/.test($("#number").val())) {
			if ($("#number").val() > 0) {
				$("#number").attr("value", $("#number").val());
			} else {
				alert("\u9009\u8d2d\u6570\u91cf\u4e0d\u80fd\u5c0f\u4e8e1\uff01");//小于0时
				$("#number").attr("value", 1);
			}
		} else {
			alert("\u8f93\u5165\u9519\u8bef\uff0c\u9009\u8d2d\u6570\u91cf\u5e94\u8be5\u662f\u4e0d\u5c0f\u4e8e1\u7684\u6570\u5b57\uff01");//不是整数时
			$("#number").attr("value", 1);
		}
		$("#money").attr("value", $("#number").val()*(price+carriage));
	});
});


