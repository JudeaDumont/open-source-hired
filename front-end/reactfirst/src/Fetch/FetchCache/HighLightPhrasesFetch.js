import {cachedSearchWords} from "./CachedSearchWords";
import {fetchFromMatchEndpoint} from "./Fetch/FetchFromMatchEndpoint";
import {setupInsights} from "../../SetupInsights";

export async function HighLightPhrasesFetch(textJD, textR) {
    try {
        return await fetchFromMatchEndpoint(textJD, textR)
            .then(r => {
                return r.json()
            }).then(
                async data => { //todo: next I want data hooked in, matches colored
                    cachedSearchWords.c = data.body.data.match
                    return setupInsights(textJD, textR, cachedSearchWords.c);
                }
            )
    } catch (e) {
        return cachedSearchWords.c
    }
}