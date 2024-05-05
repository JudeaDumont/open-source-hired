import {concatenatePaste} from "../Util/ConcatenatePaste";
import {getSelection} from "../Caret/GetSelection";

export function handlePasteLogic(evt, activeElement) {
    let textContent = activeElement.textContent;
    let clipboardText = evt.clipboardData.getData('text/plain');
    let {selectionStart, selectionEnd} = getSelection(activeElement);

    let newTextContent = concatenatePaste(textContent, clipboardText, selectionStart, selectionEnd)

    let caretPosition = selectionStart + clipboardText.length;
    return {newTextContent, caretPosition};
}