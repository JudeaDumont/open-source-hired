import {fetchFromMatchEndpoint} from "../Fetch/FetchFromMatchEndpoint";
import {cachedSearchWords} from "../CachedSearchWords";
import {validData} from "./ValidData";

export function fetchNewCacheReturnPreviousCache(fromStringJD, fromStringR) {
    fetchFromMatchEndpoint(fromStringJD, fromStringR)
        .then(r => {
            if (r !== undefined) {
                return r.json()
            } else {
                return cachedSearchWords.c
            }
        }).then(
        async data => {
            if (validData(data)) {
                cachedSearchWords.c = data.body.data.match
            }
        })
    return cachedSearchWords.c
}