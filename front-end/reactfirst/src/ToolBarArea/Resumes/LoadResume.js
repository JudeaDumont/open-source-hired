import {getCachedResumeContent} from "../../Fetch/FetchCache/FetchResume/GetCachedResumeContent";
import {HighLightPhrasesFetch} from "../../Fetch/FetchCache/HighLightPhrasesFetch";
import browserCacheSetCurrentResumeContent
    from "../../BrowserCache/CurrentResume/Content/browserCacheSetCurrentResumeContent";
import {setCurrentResumeName} from "./SetCurrentResumeName";

export function loadResume(name) {
    return async () => {
        let [stringJD, stringR] = await HighLightPhrasesFetch(
            document.getElementById("description-area").textContent,
            getCachedResumeContent(name));
        await window.setHtmlJDG(
            stringJD);
        await window.setHtmlRG(
            stringR);
        setCurrentResumeName(name);
        browserCacheSetCurrentResumeContent(stringR)
    }
}