import browserCacheGetCurrentResumeName from "../../BrowserCache/CurrentResume/Name/browserCacheGetCurrentResumeName";
import browserCacheSetCurrentResumeName from "../../BrowserCache/CurrentResume/Name/browserCacheSetCurrentResumeName";

describe('browserCacheSetCurrentResumeName', () => {

    it('browserCacheSetCurrentResumeName', () => {
        browserCacheSetCurrentResumeName("aba");
        let result = browserCacheGetCurrentResumeName();
        expect(result).toEqual("aba")
    })
})