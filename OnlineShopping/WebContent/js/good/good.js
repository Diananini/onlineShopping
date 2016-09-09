$(document).ready(function() {
	$('#goodnum').eq(0).validate();
	if ($('#status').val()!='') {
				alert($('#status').val());
				$('#lookbus').append("查看购物车"); 
				$('#lookbus').attr('href','shoppingcart?action=lookbus');
			}
	$('#number').change(function() {
		var number = $('#number').val();
		var gid = $('#gid').val();
		if (/^\d+$/.test(number)) {// is number
			if (number == '0') {
				alert("选购数量不能小于1！");
				$('#number').attr("value", 1);
			} else {
				$('.active-buy').attr(
						"href",
						'shoppingcart?gid=' + gid + '&number=' + number
								+ '&action=good');
				$('.active-intobus').attr(
						"href",
						'shoppingcart?gid=' + gid + '&number=' + number
								+ '&action=intobus');
			}
		} else {
			alert("输入错误，选购数量应该是不小于1的数字！");
			$('#number').attr("value", 1);
		}
	});
});
