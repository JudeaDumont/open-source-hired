import {cachedSearchWords} from "../../Fetch/FetchCache/CachedSearchWords";
import {
    fetchNewCacheReturnPreviousCache
} from "../../Fetch/FetchCache/FetchNewCacheReturnPrevCache/FetchNewCacheReturnPreviousCache";


describe('FetchNewCacheReturnPreviousCache', () => {

    jest.setTimeout(15000)
    it('FetchNewCacheReturnPreviousCacheDebounce SHALL SET THE CACHE', async () => {
        cachedSearchWords.reset()
        let result = await fetchNewCacheReturnPreviousCache("documentation", "documentation");
        expect(result).toEqual("{\n    \"missed\": {\"ht\": {}, \"totalDensity\": 0},\n    \"matched\": {\"ht\": {}, \"totalDensity\": 0},\n    \"combinedMatchedBecause\": {\n    },\n    \"combinedSuperfluous\": {\n        \"ht\": {\n        }, \"totalDensity\": 0\n    },\n    \"matchPercentage\": 0\n}");
        await new Promise(res => setTimeout(res,1000));
        expect(cachedSearchWords.c).toContain("\"missed\":{\"ht\":{\"[java]\":1},\"totalDensity\":1},\"matched\":{\"ht\":{\"document-duties\":1},\"totalDensity\":1},\"matchedBecause\":{\"documentation --- documentation\":\"[\\\"document\\\",\\\"documentation\\\"]\"},\"superfluous\":{\"ht\":{},\"totalDensity\":0},\"matchPercentage\":50.0")
    })
})