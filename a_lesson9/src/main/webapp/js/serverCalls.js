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
					if (data == 'Success') {
						alert("Suceess");
					}
				});
		});



$("button.buy-jornal").click(
		function() {
			var jornalId=jQuery(this).attr("jornal-id")
			
			
				$.post("bucket", {'jornalId':jornalId},	function(data) {
					if (data == 'Success') {
						$('#buyProductModal').hide();
						$("[data-dismiss=modal]").trigger({type:"click"});
						alert('Success');
					}
				});
		});