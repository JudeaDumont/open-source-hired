import {setHighlightPhrases} from "./SetHighlightPhrases";
import {
    debounceSetHighlightPhrases
} from "../../Fetch/FetchCache/FetchNewCacheReturnPrevCache/DebounceSetHighlightPhrases";
import stripTags from "../Util/StripTags";
import getCaret from "../Caret/GetCaret";
import setCaret from "../Caret/SetCaret";
import {
    FetchNewCacheReturnPreviousCacheDebounce
} from "../../Fetch/FetchCache/FetchNewCacheReturnPrevCache/FetchNewCacheReturnPreviousCacheDebounce";
import {isElementTextMatchingArea} from "./IsElementTextMatchingArea";

export async function handleFetchDebounce(textJD, textR, after) {
    debounceSetHighlightPhrases(
        () => {
            let activeElement = document.activeElement;
            if (isElementTextMatchingArea(activeElement)) {
                let caret = getCaret(activeElement);
                setCaret(caret, activeElement)
            }
            setHighlightPhrases(stripTags(textJD), stripTags(textR));
            after();
        }, 5000)()
    FetchNewCacheReturnPreviousCacheDebounce(textJD, textR) //make sure search words are available once the debounce expires
}