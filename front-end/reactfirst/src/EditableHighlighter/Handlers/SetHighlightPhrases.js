import {
    HighLightPhrasesFetchCacheMock
} from "../../Fetch/FetchCache/FetchNewCacheReturnPrevCache/HighLightPhrasesFetchCacheMock";

export function setHighlightPhrases(textJD, textR) {
    const [htmlJD, htmlR] = HighLightPhrasesFetchCacheMock(
        textJD,
        textR
    );
    window.setHtmlRG(htmlR)
    window.setHtmlJDG(htmlJD)
}