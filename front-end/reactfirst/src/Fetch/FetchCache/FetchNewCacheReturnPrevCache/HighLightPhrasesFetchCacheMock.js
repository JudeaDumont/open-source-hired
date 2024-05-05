import {FetchNewCacheReturnPreviousCacheDebounce} from "./FetchNewCacheReturnPreviousCacheDebounce";
import {setupInsights} from "../../../SetupInsights";

export function HighLightPhrasesFetchCacheMock(textJD, textR) {
    let cachedSearchWords = FetchNewCacheReturnPreviousCacheDebounce(textJD, textR)
    return setupInsights(textJD, textR, cachedSearchWords);
}