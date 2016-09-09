$(document).ready(function() {
			$('#editpasswd').validate();
			$('#editpasswd').submit(function() {
						if ($('#passwd1').val() == $('#passwd2').val())
							return true;
						else {
							alert('新密码和确认密码不一致，请重试！');
							return false;
						}
					})
		})
