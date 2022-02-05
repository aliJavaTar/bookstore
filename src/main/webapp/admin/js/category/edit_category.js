function validateFormInput() {

    let fieldName = document.getElementById("name");


    if (fieldName.value.length == 0) {
        alert("name is required!")
        fieldName.focus();
        return false;
    }

    return true;
}