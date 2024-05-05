import {HighLightPhrases} from "./Highlighter/HighLightPhrases";
import {text} from "./Initialize/InitialText";
import {validCachedText} from "./ValidCachedText";
import browserCacheGetCurrentResumeContent from "../BrowserCache/CurrentResume/Content/browserCacheGetCurrentResumeContent";

export function getInitialResume(props) {
    return HighLightPhrases(
        validCachedText(browserCacheGetCurrentResumeContent()) ? browserCacheGetCurrentResumeContent() : text.resume,
        props.searchWordsAg);
}