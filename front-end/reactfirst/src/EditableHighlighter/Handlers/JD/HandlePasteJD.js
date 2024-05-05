import setCaret from "../../Caret/SetCaret";
import {handlePasteLogic} from "../HandlePasteLogic";
import browserCacheSetCurrentDescriptionContent from "../../../BrowserCache/CurrentDescription/Content/browserCacheSetCurrentDescriptionContent";
import {handleFetchDebounce} from "../HandleFetchDebounce";

export function handlePasteJD() {
    return (evt) => {
        evt.preventDefault()
        let activeElement = document.getElementById("description-area");
        let {newTextContent, caretPosition} = handlePasteLogic(evt, activeElement);
        window.setHtmlJDG(newTextContent)
        browserCacheSetCurrentDescriptionContent(newTextContent)

        handleFetchDebounce(
            newTextContent,
            document.getElementById("resume-area").textContent,
            () => {
            }
        )

        setCaret(caretPosition, activeElement);
    };
}