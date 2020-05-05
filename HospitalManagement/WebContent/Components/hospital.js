$(document).ready(function() {

	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}

	$("#alertError").hide();
});

$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateHospitalForm();
	if (status != true) {

		$("#alertError").text(status);
		$("#alertError").show();

		return;
	}

	var type = ($("#hidHospitalIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "hospitalAPI",
		type : type,
		data : $("#formHospital").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onHospitalSaveComplete(response.responseText, status);
		}
	});

	// $("#formHospital").submit();

});

function onHospitalSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divHospitalsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidHospitalIDSave").val("");
	$("#formHospital")[0].reset();
}
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "hospitalAPI",
		type : "DELETE",
		data : "HID=" + $(this).data("hid"),
		dataType : "text",
		complete : function(response, status) {
			onHospitalDeleteComplete(response.responseText, status);
		}
	});
});

function onHospitalDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divHospitalsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

$(document)
		.on("click",".btnUpdate",function(event) {
					$("#hidHospitalIDSave").val(
							$(this).closest("tr").find('#hidHospitalIDUpdate')
									.val());
					$("#hCode").val(
							$(this).closest("tr").find('td:eq(0)').text());
					$("#hName").val(
							$(this).closest("tr").find('td:eq(1)').text());
					$("#cDoc").val(
							$(this).closest("tr").find('td:eq(2)').text());
					$("#type").val(
							$(this).closest("tr").find('td:eq(3)').text());
					$("#phone").val(
							$(this).closest("tr").find('td:eq(4)').text());
					$("#address").val(
							$(this).closest("tr").find('td:eq(5)').text());
					$("#desc").val(
							$(this).closest("tr").find('td:eq(6)').text());

				});

// CLIENT-MODEL================================================================
function validateHospitalForm() {
	// hos code
	if ($("#hCode").val().trim() == "") {

		return "Insert Hospital Code.";
	}
	//hos name
	if ($("#hName").val().trim() == "") {

		return "Insert Hospital Name.";
	}
	//chief Doc
	if ($("#cDoc").val().trim() == "") {

		return "Insert Chief Doctor.";
	}
	//type
	if ($('input[name="type"]:checked').length === 0) {
		return "Select type.";
	}
	//phone
	if ($("#phone").val().trim() == "") {

		return "Insert phone Number.";
	}

	var temcard = $("#phone").val().trim();
	if (!(/02[1,2,5,6,7,8][0-9]{7}/)
			.test(temcard)) {

		return "Enter the valid phone number.";

	}

	// address
	if ($("#address").val().trim() == "") {

		return "Insert address .";
	}

	
	if ($("#desc").val().trim() == "") {

		return "Insert Description .";
	}
	
	
	return true;
	
	
}