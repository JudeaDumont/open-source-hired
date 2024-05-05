import getCaret from "./GetCaret";

export function getCaretPositionFromActiveElement() {
    let activeElement = document.activeElement;
    let currentCursorPosition = getCaret(activeElement);
    return {activeElement, currentCursorPosition};
}