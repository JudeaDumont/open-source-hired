import {cachedSearchWords} from "../CachedSearchWords";
import {fetchNewCacheReturnPreviousCache} from "./FetchNewCacheReturnPreviousCache";

let lastCall = new Date().getTime()

export function FetchNewCacheReturnPreviousCacheDebounce(fromStringJD, fromStringR) {
    let current = new Date().getTime();
    if (lastCall + 1000 < current) {
        lastCall = current
        fetchNewCacheReturnPreviousCache(fromStringJD, fromStringR);
    }
    return cachedSearchWords.c
}
