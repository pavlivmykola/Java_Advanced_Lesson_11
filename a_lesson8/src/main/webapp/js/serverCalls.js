$("button.createJornal").click(
		function() {
			var name = $("form.createJornal input.jornalName").val();
			var description = $("form.createJornal input.jornalDescription").val();
			var price = $("form.createJornal input.jornalPrice").val();

			var jornal = {
					name : name,
					description : description,
					price : price
				};
				$.post("jornalServlet", jornal, function(data) {
					if (data == 'success') {
//						$("form")[0].reset();
//						$("form")[1].reset();
//						showAlertAfterRegistration();
						alert("suceess");
					}
				});
		});