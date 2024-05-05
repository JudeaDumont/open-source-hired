import getSelectionStart from "./GetSelectionStart";
import getCaret from "./GetCaret";

export function getSelection(element) {
    let selectionStart = getSelectionStart(element);
    let selectionEnd = getCaret(element);

    if (selectionStart === selectionEnd + 1) { //edge case where one character is selected (idk)
        --selectionStart
        ++selectionEnd
    } else if (selectionStart > selectionEnd) {
        //bug discovered where backwards selection breaks paste, if start > end, start = end end = start
        let temp = selectionStart
        selectionStart = selectionEnd
        selectionEnd = temp
    }
    return {selectionStart, selectionEnd};
}