export function getPersistDescriptionInputValue() {
    return document.getElementById("persist-description-input") === null ? "" :
        document.getElementById("persist-description-input").value;
}