/**
 * 
 */

function yearFun() {
	var yearValue = document.getElementById("yearId").value;
	if (yearValue < 1000) {
		document.getElementById("yearValidationMsg").innerHTML = "Enter valid year.";
	}
	else {
		document.getElementById("yearValidationMsg").innerHTML = "";
	}
}

