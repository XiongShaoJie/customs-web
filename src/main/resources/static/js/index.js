$(document).ready(function() {

});

function formSubmit() {
	var name = $("#name").val();
	var age = $("#age").val();
	var password = $("#password").val();
	var email = $("#email").val();
	$.ajax({
		url : "/person/register",
		type : "post",
		data : {
			"name" : name,
			"age" : 500,
			"password" : password,
			"email" : email
		},
		dataType : "json",
		success : function(result) {
			for ( var key in result) {
				console.log(key + ":" + result[key]);
			}
		},
		error : function() {
			alert("请求出错！");
		}
	});
}