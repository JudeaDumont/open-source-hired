export function setResumeInputTextBoxValue(name) {
    let persistResumeInputTextBox = document.getElementById("persist-resume-input");
    if (persistResumeInputTextBox !== null) {
        persistResumeInputTextBox.value = name
    }
}