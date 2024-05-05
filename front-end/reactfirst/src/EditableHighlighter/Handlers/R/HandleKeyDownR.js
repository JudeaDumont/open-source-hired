import {handleFetchDebounce} from "../HandleFetchDebounce";
import {isArrowKey} from "../IsKey/IsArrowKey";
import {isControlKey} from "../IsKey/IsControlKey";
import {isEnterKey} from "../IsKey/IsEnterKey";
import {getSelection} from "../../Caret/GetSelection";
import {handleEnterPressR} from "./HandleEnterPressR";
import {isCtrlZ} from "../IsKey/IsCtrlZ";
import {isDelete} from "../IsKey/IsDelete";
import {isBackspace} from "../IsKey/IsBackspace";
import {addCharacterIntoString} from "../../Util/AddCharacterIntoString";
import stripTags from "../../Util/StripTags";
import browserCacheSetCurrentResumeContent
    from "../../../BrowserCache/CurrentResume/Content/browserCacheSetCurrentResumeContent";
import {isAlt} from "../IsKey/IsAlt";

export function handleKeyDownR() {
    return (evt) => {
        let activeElement = document.getElementById("resume-area");
        let selection = getSelection(activeElement)
        let textJD = document.getElementById("description-area").textContent;
        let textR = activeElement.textContent;
        if (isEnterKey(evt)) {
            //Enter Key
            handleEnterPressR(evt);
        } else if (isArrowKey(evt) || isControlKey(evt)) {
            //Arrow Keys
            handleFetchDebounce(textJD, textR, () => 0);
        } else if (isCtrlZ(evt)) {
            //Ctrl + Z undo goes here
            handleFetchDebounce(textJD, textR, () => 0);
        } else if (isDelete(evt)) {
            //Delete
        } else if (isBackspace(evt)) {
            //BackSpace
        } else if (isAlt(evt)) {
            //Alt
        } else if (evt.key !== null) {
            //Everything Else
            //console.log("document.getElementById(\"description-area\").textContent\n" + textJD)
            //string needs manual addition of key before passing to fetchDebounce
            let modifiedText = addCharacterIntoString(stripTags(textR), selection, evt.key);
            browserCacheSetCurrentResumeContent(modifiedText)
            handleFetchDebounce(textJD, modifiedText, () => 0);
        } else {
            handleFetchDebounce(textJD, textR, () => 0);
        }
    };
}