function validateFormInput() {
    let fieldEmail = document.getElementById("email");
    let fieldFullName = document.getElementById("fullName");
    let fieldPassword = document.getElementById("password");
    console.log(fieldEmail, fieldFullName, fieldPassword);
    if (fieldEmail.value.length == 0) {
        alert("email is required!")
        fieldEmail.focus();
        return false;
    }
    if (fieldFullName.value.length == 0) {
        alert("fullName is required!")
        fieldFullName.focus();
        return false;
    }
    if (fieldPassword.value.length == 0) {
        alert("password is required!")
        fieldPassword.focus();
        return false;
    }
    return true;
}