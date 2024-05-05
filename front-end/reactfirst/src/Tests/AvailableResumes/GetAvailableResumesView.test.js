import {testing} from "../../testingBool";
import persistResumeFetch from "../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";
import {getResumesUI} from "../../ToolBarArea/Resumes/GetResumesUI";

describe('getAvailableResumesView', () => {

    it('getAvailableResumesView', async () => {
        let resultPersist = await persistResumeFetch("testGetAvailableResumesView", "test persist plaintext")
        expect(resultPersist[0]).toBe("test persist plaintext");

        let result = await getResumesUI();
        expect(result.map((item) => item.props.children[0].props.children))
            .toContain("testGetAvailableResumesView");
    })
})
beforeEach(() => {
    testing.testing = true
})
afterEach(async () => {
    let result = await removeResumeFetch("testGetAvailableResumesView")
    expect(result.length).toBe(1)
    testing.testing = false
})