$(document).ready(function () {
	$('#normalEmail').blur(function(){
		var normalEmail=$('#normalEmail').val();
			$.ajax({
				url:'/register/idCheck',
				type:'POST', 
				dataType: "json",
				data: {normalEmail : normalEmail},
				success:function(data){
					if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("이미 사용중인 아이디입니다.  ");
						$('#id_check').css('color', 'red');
					}
					else if(data == 0){
						$("#id_check").text("' " + normalEmail + " '" +  " 사용가능 아이디입니다.  ");
						$('#id_check').css('color', 'blue');
					}
				},
				error: function() {
					alert("ajax 통신 오류");
				}
		});	
	}); 
});