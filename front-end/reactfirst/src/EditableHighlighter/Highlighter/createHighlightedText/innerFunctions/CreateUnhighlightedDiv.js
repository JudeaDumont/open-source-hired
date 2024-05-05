export function createUnhighlightedDiv(inOrderTextElements, unHighlightedText) {
    if (unHighlightedText !== "") {
        inOrderTextElements.push("<div class='text-block white'>" + unHighlightedText + "</div>")
    }
    return ""
}