export function concatenatePaste(textContent, pasteContent, selectionStart, selectionEnd) {
    return textContent.substring(0, selectionStart) +
        pasteContent +
        textContent.substring(selectionEnd);
}