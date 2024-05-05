export function createLineLinkClassName(text) {
    let trim = text.trim().toLowerCase();
    let replaceSpaces = trim.replaceAll(" ", "-");
    return "line-" + replaceSpaces;
}