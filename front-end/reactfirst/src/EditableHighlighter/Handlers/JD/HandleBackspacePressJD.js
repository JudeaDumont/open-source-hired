export function handleBackspacePressJD(text, selection) {
    return selection.selectionStart === selection.selectionEnd
        ? text.substring(0, selection.selectionStart) + text.substring(selection.selectionEnd)
        : text.substring(0, selection.selectionStart) + text.substring(selection.selectionEnd);
}