$(document).ready(function() {

	var frm = $('form').eq(0);
	frm.validate();

	var radios = frm.find(':radio');
	$.each(radios, function(idx, r) {
				var jr = $(r);
				var jrVal = jr.val();
				var jrSel = jr.attr('selectedValue');
				var checked = (jrVal == jrSel);
				// alert(checked);
				if (jrSel == null) {
					checked =1;
				}

				jr.attr('checked', checked);
			});
	$('#acdm').change(function() {
		var vals = $('#acdm').val();
		if (vals == "0") {
			$('#spet').empty();
			$('#spet').append("<option >-请选择专业-</option>");
		} else if (vals == "10") {
			$('#spet').empty();
			$('#spet').append("<option >通信</option>" + "<option >网络</option>");
		} else if (vals == "11") {
			$('#spet').empty();
			$('#spet').append("<option >过控</option>");
		} else if (vals == "12") {
			$('#spet').empty();
			$('#spet').append("<option >高分子</option>"
					+ "<option >模具成型</option>");
		} else if (vals == "13") {
			$('#spet').empty();
			$('#spet').append("<option >数学</option>" + "<option >物理</option>");
		} else if (vals == "14") {
			$('#spet').empty();
			$('#spet').append("<option >英语</option>" + "<option >法律</option>");
		} else if (vals == "15") {
			$('#spet').empty();
			$('#spet').append("<option >计算机科学与技术</option>"
					+ "<option >软件工程</option>");
		}
	});

	var selects = frm.find('#select');
	$.each(selects, function() {
				var selval = $('#vty').val() - 3;
				// alert(selval);digits
				$("#select")[0].selectedIndex = selval;
			});

	$('.digits').addClass("required");
	$('.number').addClass("required");
	$('.email').addClass("required");
	$('#date').datepicker();

	var j = 1, i = 1;
	$('#addbtn').click(function() {
		do {
			$('#order-list')
					.append("<tr>"
							+ "<td>ISBN号:</td><td><input type='text' class='required' name='isbn"
							+ i + "'></td>"
							+ "<td>订购数量:</td><td><input type='text' class='digits' id='bnumber' name='bnumber"
							+ i + "' maxlength='7'></td>"
							+ "<td>金额（￥）:</td><td><input type='text' class='number' id='money' name='money"
							+ i + "' maxlength='7'></td></tr>");
			i++;
		} while (i < j);
		j++;
		$('#j').val(j);
		$('.number').addClass('required');
		$('.digits').addClass('required');

	});

});