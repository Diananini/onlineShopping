$(document).ready(function() {
			$('#register').eq(0).validate();
			$('.email').addClass('required');
			$('#register').submit(function() {
						if ($('#passwd').val() != ''
								&& $('#passwd1').val() != '') {
							if ($('#passwd').val() == $('#passwd1').val())
								return true;
							else {
								alert('确认密码与登录密码不一致，请重新输入！');
								return false;
							}
						}
					});
		})