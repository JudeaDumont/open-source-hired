import getCaret from "../../../EditableHighlighter/Caret/GetCaret";
import setCaret from "../../../EditableHighlighter/Caret/SetCaret";
import {setHighlightPhrases} from "../../../EditableHighlighter/Handlers/SetHighlightPhrases";
import stripTags from "../../../EditableHighlighter/Util/StripTags";
import {getSelection} from "../../../EditableHighlighter/Caret/GetSelection";
import {isElementTextMatchingArea} from "../../../EditableHighlighter/Handlers/IsElementTextMatchingArea";

let singleton = {
    timeoutId: null
};
export const debounceSetHighlightPhrases = (callback, wait) => {
    return (...args) => {
        window.clearTimeout(singleton.timeoutId);
        singleton.timeoutId = window.setTimeout(() => {
            let activeElement = document.activeElement;
            let selection = getSelection(activeElement);

            if (!isElementTextMatchingArea(activeElement) || selection.selectionEnd - selection.selectionStart === 0) {
                callback(...args);
            }
            debounceSetHighlightPhrases(() => {
                let activeElement = document.activeElement;
                let textJD = document.getElementById("description-area");
                let textR = document.getElementById("resume-area");
                if (isElementTextMatchingArea(activeElement)) {
                    let caret = getCaret(activeElement);
                    setCaret(caret, activeElement)
                }
                setHighlightPhrases(
                    stripTags(
                        textJD === null ?
                            "" : textJD.textContent
                    ),
                    stripTags(textR === null ? "" : textR.textContent))
            }, 5000)()
        }, wait);
    };
}