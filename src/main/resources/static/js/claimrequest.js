document.addEventListener("DOMContentLoaded", function() {
    var memberIdSelect = document.getElementById("memberId");
    var firstNameInput = document.getElementById("first_name");
    var lastNameInput = document.getElementById("last_name");
    var nomineeCount = document.getElementById("nominee_count");
    var maxClaimAmount = document.getElementById("max_claim_amount");
	var insuranceType = document.getElementById("insurance_type");
	var finalClaimAmount = document.getElementById("final_claim_amount");

    if (memberIdSelect && firstNameInput && lastNameInput && nomineeCount && insuranceType && finalClaimAmount) {
        memberIdSelect.addEventListener("change", function() {
            var selectedValue = this.value;

            var xhrFirstName = new XMLHttpRequest();
            xhrFirstName.open("POST", fetchFirstNameUrl, true);
            xhrFirstName.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhrFirstName.onreadystatechange = function() {
                if (xhrFirstName.readyState === 4 && xhrFirstName.status === 200) {
                    firstNameInput.value = xhrFirstName.responseText; // Update first name input
                }
            };
            xhrFirstName.send("memberId=" + selectedValue);

            var xhrLastName = new XMLHttpRequest();
            xhrLastName.open("POST", fetchLastNameUrl, true);
            xhrLastName.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhrLastName.onreadystatechange = function() {
                if (xhrLastName.readyState === 4 && xhrLastName.status === 200) {
                    lastNameInput.value = xhrLastName.responseText; // Update last name input
                }
            };
            xhrLastName.send("memberId=" + selectedValue);

            var xhrNomineeCount = new XMLHttpRequest();
            xhrNomineeCount.open("POST", fetchNomineeCountUrl, true);
            xhrNomineeCount.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhrNomineeCount.onreadystatechange = function() {
                if (xhrNomineeCount.readyState === 4 && xhrNomineeCount.status === 200) {
                    nomineeCount.value = xhrNomineeCount.responseText; // Update nomineeCount input
                }
            };
            xhrNomineeCount.send("memberId=" + selectedValue);

            var xhrMaxClaimAmount = new XMLHttpRequest();
            xhrMaxClaimAmount.open("POST", fetchMaxClaimAmountUrl, true);
            xhrMaxClaimAmount.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhrMaxClaimAmount.onreadystatechange = function() {
                if (xhrMaxClaimAmount.readyState === 4 && xhrMaxClaimAmount.status === 200) {
                    maxClaimAmount.value = xhrMaxClaimAmount.responseText; // Update nomineeCount input
                }
            };
            xhrMaxClaimAmount.send("memberId=" + selectedValue);

            var xhrInsuranceType = new XMLHttpRequest();
            xhrInsuranceType.open("POST", fetchInsuranceTypeUrl, true);
            xhrInsuranceType.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhrInsuranceType.onreadystatechange = function() {
                if (xhrInsuranceType.readyState === 4 && xhrInsuranceType.status === 200) {
                    insuranceType.value = xhrInsuranceType.responseText; // Update nomineeCount input
                }
            };
            xhrInsuranceType.send("memberId=" + selectedValue);

            var xhrFinalClaimAmount = new XMLHttpRequest();
            xhrFinalClaimAmount.open("POST", fetchFinalClaimAmountUrl, true);
            xhrFinalClaimAmount.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhrFinalClaimAmount.onreadystatechange = function() {
                if (xhrFinalClaimAmount.readyState === 4 && xhrFinalClaimAmount.status === 200) {
                    finalClaimAmount.value = xhrFinalClaimAmount.responseText; // Update nomineeCount input
                }
            };
            xhrFinalClaimAmount.send("memberId=" + selectedValue);
        });
    } else {
        console.error("Element with id 'memberId', 'first_name', or 'last_name' or 'nominee_count' or 'max_claim_amount' or 'insurance_type' not found");
    }
});