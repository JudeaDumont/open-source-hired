export function getElementsInLink(link) {
    let elementsByClassNameFrom = document.getElementById("description-area")
        .getElementsByClassName(link.from);
    let elementsByClassNameTo = document.getElementById("resume-area")
        .getElementsByClassName(link.to);
    return {elementsByClassNameFrom, elementsByClassNameTo};
}