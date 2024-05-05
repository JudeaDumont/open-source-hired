import {addCharacterIntoString} from "../../Util/AddCharacterIntoString";
import {handleFetchDebounce} from "../HandleFetchDebounce";
import setCaret from "../../Caret/SetCaret";
import {getSelection} from "../../Caret/GetSelection";
import stripTags from "../../Util/StripTags";
import browserCacheSetCurrentDescriptionContent
    from "../../../BrowserCache/CurrentDescription/Content/browserCacheSetCurrentDescriptionContent";

export function handleEnterPressJD(evt) {
    evt.preventDefault()
    let activeElement = document.getElementById("description-area")
    let selection = getSelection(activeElement);

    let modifiedText = addCharacterIntoString(stripTags(activeElement.textContent), selection);
    setCaret(selection.selectionEnd + 1 - (selection.selectionEnd - selection.selectionStart), activeElement)
    window.setHtmlJDG(modifiedText)
    browserCacheSetCurrentDescriptionContent(modifiedText)
    handleFetchDebounce(
        modifiedText,
        document.getElementById("resume-area").textContent,
        () => {
        });
}