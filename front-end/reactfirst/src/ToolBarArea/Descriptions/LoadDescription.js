import {HighLightPhrasesFetch} from "../../Fetch/FetchCache/HighLightPhrasesFetch";
import {getCachedDescriptionContent} from "../../Fetch/FetchCache/FetchDescription/GetCachedDescriptionContent";
import {setCurrentDescriptionName} from "./SetCurrentDescriptionName";
import browserCacheSetCurrentDescriptionContent
    from "../../BrowserCache/CurrentDescription/Content/browserCacheSetCurrentDescriptionContent";

export function loadDescription(name) {
    return async () => {
        let [stringJD, stringR] = await HighLightPhrasesFetch(
            getCachedDescriptionContent(name),
            document.getElementById("resume-area").textContent
            );
        await window.setHtmlJDG(
            stringJD);
        await window.setHtmlRG(
            stringR);
        setCurrentDescriptionName(name);
        browserCacheSetCurrentDescriptionContent(stringR)
    }
}