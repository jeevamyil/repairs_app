function validate() {
	var name = document.getElementById("name").value.trim();
	var number = document.getElementById("number").value.trim();
	var location = document.getElementById("location").value.trim();
	var namelen = name.length;
	var numberlen = number.length;
	var locationlen = location.length;

	if (namelen == 0) {
		alert("Name is required");
		return false;
	}

	if (namelen <= 2 || namelen >= 65) {
		alert("Name should have 2 to 65 characters.");
		return false;
	}
	if (numberlen != 10) {
		alert("Enter valid Phone number.");
		return false;

	}

	if (locationlen == 0) {
		alert("valid location is required");
		return false;
	}

	if (isNaN(number)) {
		alert("Enter valid Phone number");
		return false;
	}

}

function loginValidate() {
	var name = document.getElementById("name").value;
	var number = document.getElementById("number").value;

	var namelen = name.length;
	var numberlen = number.length;

	if (namelen == 0) {
		alert("Name is required");
		return false;
	}

	if (namelen <= 2 || namelen >= 65) {
		alert("Name should have 2 to 65 characters.");
		return false;
	}
	if (numberlen != 10) {
		alert("Enter valid Phone number.");
		return false;

	}

	if (isNaN(number)) {
		alert("Enter valid Phone number");
		return false;
	}

}

function locValidate() {

	var location = document.getElementById("location").value;

	var locationlen = location.length;

	if (locationlen == 0) {
		alert("valid location is required");
		return false;
	}

}