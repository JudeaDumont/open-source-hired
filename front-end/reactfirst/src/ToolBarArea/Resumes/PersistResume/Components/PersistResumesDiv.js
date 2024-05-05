import browserCacheGetCurrentResumeName
    from "../../../../BrowserCache/CurrentResume/Name/browserCacheGetCurrentResumeName";
import {saveResumeButton} from "./SaveResumeButton";

export function PersistResumesDiv() {
    return <>
        <input id={"persist-resume-input"} type={"text"} defaultValue={browserCacheGetCurrentResumeName()}/>
        <br/>
        {saveResumeButton()}
    </>
}