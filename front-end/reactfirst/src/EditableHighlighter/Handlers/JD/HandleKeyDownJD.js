import {isEnterKey} from "../IsKey/IsEnterKey";
import {handleEnterPressJD} from "./HandleEnterPressJD";
import {isArrowKey} from "../IsKey/IsArrowKey";
import {isControlKey} from "../IsKey/IsControlKey";
import {handleFetchDebounce} from "../HandleFetchDebounce";
import {getSelection} from "../../Caret/GetSelection";
import {isBackspace} from "../IsKey/IsBackspace";
import {isDelete} from "../IsKey/IsDelete";
import {isCtrlZ} from "../IsKey/IsCtrlZ";
import {addCharacterIntoString} from "../../Util/AddCharacterIntoString";
import stripTags from "../../Util/StripTags";
import browserCacheSetCurrentDescriptionContent
    from "../../../BrowserCache/CurrentDescription/Content/browserCacheSetCurrentDescriptionContent";
import {isAlt} from "../IsKey/IsAlt";
import {handleBackspacePressJD} from "./HandleBackspacePressJD";

export function handleKeyDownJD() {
    return (evt) => {
        let activeElement = document.activeElement;
        let selection = getSelection(activeElement)
        let textJD = document.getElementById("description-area").textContent;
        let textR = document.getElementById("resume-area").textContent;
        if (isEnterKey(evt)) {
            //Enter Key
            handleEnterPressJD(evt);
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
            let modifiedText = handleBackspacePressJD(stripTags(textJD), selection);
            browserCacheSetCurrentDescriptionContent(modifiedText)
            handleFetchDebounce(modifiedText, textR, () => 0);
        } else if (isAlt(evt)) {
            //Alt
        } else if (evt.key!== undefined && evt.key !== null) {
            //Everything Else
            //console.log("document.getElementById(\"description-area\").textContent\n" + textJD)
            //string needs manual addition of key before passing to fetchDebounce
            let modifiedText = addCharacterIntoString(stripTags(textJD), selection, evt.key);
            browserCacheSetCurrentDescriptionContent(modifiedText)
            handleFetchDebounce(modifiedText, textR, () => 0);
        } else {
            handleFetchDebounce(textJD, textR, () => 0);
        }
    };
}