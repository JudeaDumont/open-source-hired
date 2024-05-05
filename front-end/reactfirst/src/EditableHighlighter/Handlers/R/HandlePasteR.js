import setCaret from "../../Caret/SetCaret";
import {handlePasteLogic} from "../HandlePasteLogic";
import browserCacheSetCurrentResumeContent
    from "../../../BrowserCache/CurrentResume/Content/browserCacheSetCurrentResumeContent";
import {handleFetchDebounce} from "../HandleFetchDebounce";

export function handlePasteR() {
    return (evt) => {
        evt.preventDefault()
        let activeElement = document.getElementById("resume-area");
        let {newTextContent, caretPosition} = handlePasteLogic(evt, activeElement);
        window.setHtmlRG(newTextContent)
        browserCacheSetCurrentResumeContent(newTextContent)

        handleFetchDebounce(
            document.getElementById("description-area").textContent,
            newTextContent,
            () => {
            }
        )

        setCaret(caretPosition, activeElement);
    };
}