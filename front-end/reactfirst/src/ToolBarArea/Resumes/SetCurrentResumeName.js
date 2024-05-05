import browserCacheSetCurrentResumeName from "../../BrowserCache/CurrentResume/Name/browserCacheSetCurrentResumeName";
import {setResumeInputTextBoxValue} from "./PersistResume/Components/SetResumeInputTextBoxValue";

export function setCurrentResumeName(name) {
    browserCacheSetCurrentResumeName(name)
    setResumeInputTextBoxValue(name);
}