import {setHighlightPhrases} from "./SetHighlightPhrases";
import stripTags from "../Util/StripTags";

export function handleFetchNoDebounce(textJD, textR) {
    setHighlightPhrases(stripTags(textJD), stripTags(textR));
}