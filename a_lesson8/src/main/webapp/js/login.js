function loginRegisterSwitch() {
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
}

function showAlertAfterRegistration() {
	$('div.alert.alert-success').show();
}

$('.message a').click(function() {
	loginRegisterSwitch();
});

$("button.register").click(
		function() {
			var firstName = $("form.register-form input.firstName").val();
			var lastName = $("form.register-form input.lastName").val();
			var email = $("form.register-form input.email").val();
			var password = $("form.register-form input.password").val();
			var cpassword = $("form.register-form input.cpassword").val();
			if (firstName == '' || lastName == '' || email == ''
					|| password == '' || cpassword == '') {
				alert("Please fill all fields...!!!!!!");
			} else if (!(password).match(cpassword)) {
				alert("Your passwords don't match. Try again?");
			} else {
				var userRegistration = {
					firstName : firstName,
					lastName : lastName,
					email : email,
					password : password
				};
				$.post("registrationServlet", userRegistration, function(data) {
					if (data == 'success') {
						$("form")[0].reset();
						$("form")[1].reset();
						loginRegisterSwitch();
						showAlertAfterRegistration();
					}
				});
			}
		});


$("button.login").click(
		function() {
			var email = $("form.login-form input.email").val();
			var password = $("form.login-form input.password").val();
			if (email == '' || password == '') {
				alert("Please fill all fields...!!!!!!");
			} else {
				var userLogin = {
					email : email,
					password : password
				};
				$.post("loginServlet", userLogin, function(data) {
					if (data !=''){
						var customUrl='';
						var urlContent=window.location.href.split('/');
						for (var i=0;i<urlContent.length-1;i++){
							customUrl+=urlContent[i]+'/';						
						}
						customUrl+=data.destinationURL;
						window.location=customUrl;
					}	
					$("form")[1].reset();
				});
			}
		});
