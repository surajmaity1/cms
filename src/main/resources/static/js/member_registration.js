document.addEventListener("DOMContentLoaded", function() {

	var insuranceTypeSelect = document.getElementById("insuranceType");
	var insuranceAmount = document.getElementById("insuranceAmount");
	var maxClaimAmount = document.getElementById("max_claim_amount");

	if (insuranceTypeSelect && insuranceAmount && maxClaimAmount) {
		insuranceTypeSelect.addEventListener("change", function() {
			var selectedValue = this.value;
			console.log("Selected Value" + selectedValue);

			var xhrInsuranceAmount = new XMLHttpRequest();
			xhrInsuranceAmount.open("POST", fetchInsuranceAmountUrl, true);
			xhrInsuranceAmount.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

			console.log("Reached...");
			xhrInsuranceAmount.onreadystatechange = function() {
				if (xhrInsuranceAmount.readyState === 4 && xhrInsuranceAmount.status === 200) {
					insuranceAmount.value = xhrInsuranceAmount.responseText;
				}
			};
			xhrInsuranceAmount.send("insuranceType=" + selectedValue);

			var xhrMaxClaimAmount = new XMLHttpRequest();
			xhrMaxClaimAmount.open("POST", fetchMaxClaimAmountUrl, true);
			xhrMaxClaimAmount.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

			console.log("Reached...");
			xhrMaxClaimAmount.onreadystatechange = function() {
				if (xhrMaxClaimAmount.readyState === 4 && xhrMaxClaimAmount.status === 200) {
					maxClaimAmount.value = xhrMaxClaimAmount.responseText;
				}
			};
			xhrMaxClaimAmount.send("insuranceType=" + selectedValue);
		});
	} else {
		console.error("Element with id 'insurance_type' not found");
	}
});