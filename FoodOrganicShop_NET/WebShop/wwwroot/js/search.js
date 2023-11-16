
		$(document).ready(function () {
			jQuery("#txtCatID").change(function () {
				var catID = jQuery(this).children(":selected").attr("value");
				catID = parseFloat(catID);
				$('#txtCatID option')
					.removeAttr('selected');
				$("#txtCatID > [value=" + catID + "]").attr("selected", "true");
				$.ajax({
					url: '/Home/Product/Filtter',
					datatype: "json",
					type: "GET",
					data: {
						CatID: catID
					},
					async: true,
					success: function (results) {
						if (results.status == "success") {
							window.location.href = results.redirectUrl;
						}
					},
					error: function (xhr) {
						alert('error');
					}
				});
			});

		$("#keyword").keyup(function () {
				var strkeyword = $('#keyword').val();
		console.log(strkeyword);
		$.ajax({
			url: '/SearchCus/FindCusProduct/',
		datatype: "json",
		type: "POST",
		data: {keyword: strkeyword },
		async: true,
		success: function (results) {
			$("#records_table").html("");
		$("#records_table").html(results);
					},
		error: function (xhr) {
			alert('error');
					}
				});
			});
		});

