$( document ).ready(function() {
     $('.leftmenutrigger').on('click', function(e) {
     $('.side-nav').toggleClass("open");
     e.preventDefault();
    });
});


$("#logout").click(
		function() {
				$.get("logoutServlet",  function(data) {
					if (data !=''){
						var customUrl='';
						var urlContent=window.location.href.split('/');
						for (var i=0;i<urlContent.length-1;i++){
							customUrl+=urlContent[i]+'/';						
						}
						customUrl+=data;
						window.location=customUrl;
					}	
				});
		});