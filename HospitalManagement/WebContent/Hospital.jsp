<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.hospital"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/hospital.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4">

				<h1>Online Hospital Registration</h1>

				<form id="formHospital" name="formHospital">

					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Hospital Code:
							</span>
						</div>
						<input id="hCode" name="hCode" type="text"
							class="form-control form-control-sm">
					</div>

					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Hospital Name:
							</span>
						</div>
						<input id="hName" name="hName" type="text"
							class="form-control form-control-sm">
					</div>
					
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Chief Doctor:
							</span>
						</div>
						<input id="cDoc" name="cDoc" type="text"
							class="form-control form-control-sm">
					</div>

					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Type: </span>
						</div>
						&nbsp;&nbsp;Government <input type="radio" id="type"
							name="type" value="Government"> &nbsp;&nbsp;Private <input
							type="radio" id="type" name="type" value="Private">
					</div>
					
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName"> phone: </span>
						</div>
						<input id="phone" name="phone" type="text"
							class="form-control form-control-sm">

					</div>

					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Address: </span>
						</div>
						<input id="address" name="address" type="text"
							class="form-control form-control-sm">

					</div>

					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Description: </span>
						</div>
						<input id="desc" name="desc" type="text"
							class="form-control form-control-sm">

					</div>


					<input id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidHospitalIDSave" name="hidHospitalIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success"></div>

				<div id="alertError" class="alert alert-danger"></div>


			</div>
			<div class='col-12'>
				<div id="divHospitalsGrid">

					<%
						hospital Hospital = new hospital();
					out.print(Hospital.getHospitalDetails());
					%>
				</div>

			</div>
		</div>
	</div>

</body>
</html>