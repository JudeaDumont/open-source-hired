export function addCharacterIntoString(textContent, selection, character) {
    return textContent.substring(0, selection.selectionStart) +
        (character === undefined ? "\n\r" : character)
        + textContent.substring(selection.selectionEnd, textContent.length)
}