import {HighLightPhrases} from "./Highlighter/HighLightPhrases";
import {validCachedText} from "./ValidCachedText";
import browserCacheGetDescription from "../BrowserCache/CurrentDescription/Content/browserCacheGetCurrentDescriptionContent";
import {text} from "./Initialize/InitialText";

export function getInitialDescription(props) {
    return HighLightPhrases(
        validCachedText(browserCacheGetDescription()) ? browserCacheGetDescription() : text.jobDescription,
        props.searchWordsAg);
}