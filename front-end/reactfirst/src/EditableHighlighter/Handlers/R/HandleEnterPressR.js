import {addCharacterIntoString} from "../../Util/AddCharacterIntoString";
import browserCacheSetCurrentResumeContent
    from "../../../BrowserCache/CurrentResume/Content/browserCacheSetCurrentResumeContent";
import {handleFetchDebounce} from "../HandleFetchDebounce";
import setCaret from "../../Caret/SetCaret";
import {getSelection} from "../../Caret/GetSelection";
import stripTags from "../../Util/StripTags";

export function handleEnterPressR(evt) {
    evt.preventDefault()
    let activeElement = document.activeElement
    let selection = getSelection(activeElement);

    let modifiedText = addCharacterIntoString(stripTags(activeElement.textContent), selection);
    setCaret(selection.selectionEnd + 1 - (selection.selectionEnd - selection.selectionStart), activeElement)
    window.setHtmlRG(modifiedText)
    browserCacheSetCurrentResumeContent(modifiedText)
    handleFetchDebounce(
        document.getElementById("description-area").textContent,
        modifiedText,
        () => {
        });
}