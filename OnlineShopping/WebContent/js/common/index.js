
$(document).ready(function () {
	if ($("#status").val() != "") {
		alert($("#status").val());
	}
	$(".goodlist").mousemove(function () {
		$(".goodlist").css("background-color", "#F5F0F0");
	});
	$(".goodlist").mouseout(function () {
		$(".goodlist").css("background-color", "white");
	});
});

