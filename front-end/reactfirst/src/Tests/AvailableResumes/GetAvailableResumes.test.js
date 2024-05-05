import {getResumes} from "../../ToolBarArea/Resumes/GetResumes";
import {testing} from "../../testingBool";
import persistResumeFetch from "../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";

describe('getAvailableResumes', () => {

    it('getAvailableResumes', async () => {
        let resultPersist = await persistResumeFetch("testPersistGetAvailableResumes", "test persist plaintext")
        expect(resultPersist[0]).toBe("test persist plaintext");

        let result = await getResumes();
        expect(result["testPersistGetAvailableResumes"]).toEqual("test persist plaintext");
    })
})
beforeEach(() => {
    testing.testing = true
})
afterEach(async () => {
    let result = await removeResumeFetch("testPersistGetAvailableResumes")
    expect(result.length).toBe(1)
    testing.testing = false
})