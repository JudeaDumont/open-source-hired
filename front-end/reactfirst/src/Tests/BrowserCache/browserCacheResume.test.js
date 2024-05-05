import browserCacheSetCurrentResumeContent from "../../BrowserCache/CurrentResume/Content/browserCacheSetCurrentResumeContent";
import browserCacheGetCurrentResumeContent from "../../BrowserCache/CurrentResume/Content/browserCacheGetCurrentResumeContent";

describe('browserCacheSetCurrentResumeContent', () => {

    it('browserCacheSetCurrentResumeContent', () => {
        browserCacheSetCurrentResumeContent("aba");
        let result = browserCacheGetCurrentResumeContent();
        expect(result).toEqual("aba")
    })
})