export function getPersistResumeInputValue() {
    return document.getElementById("persist-resume-input") === null ? "" :
        document.getElementById("persist-resume-input").value;
}