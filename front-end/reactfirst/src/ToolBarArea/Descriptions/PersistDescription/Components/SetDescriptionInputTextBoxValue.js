export function setDescriptionInputTextBoxValue(name) {
    let persistDescriptionInputTextBox = document.getElementById("persist-description-input");
    if (persistDescriptionInputTextBox !== null) {
        persistDescriptionInputTextBox.value = name
    }
}