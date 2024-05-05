import browserCacheSetCurrentDescriptionContent from "../../BrowserCache/CurrentDescription/Content/browserCacheSetCurrentDescriptionContent";
import browserCacheGetCurrentDescriptionContent from "../../BrowserCache/CurrentDescription/Content/browserCacheGetCurrentDescriptionContent";

describe('browserCacheSetCurrentDescriptionContent', () => {

    it('browserCacheSetCurrentDescriptionContent', () => {
        browserCacheSetCurrentDescriptionContent("aba");
        let result = browserCacheGetCurrentDescriptionContent();
        expect(result).toEqual("aba")
    })
})
