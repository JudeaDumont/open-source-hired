import persistResumeFetch from "../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";
import resumesFetch from "../../Fetch/ResumesFetch/ResumesFetch";
import {testing} from "../../testingBool";
import {cachedResumes} from "../../Fetch/ResumesFetch/CachedResumes";

test('AvailableResumesFetch', async () => {
    let resultPersist = await persistResumeFetch("testPersistAvailableResumesFetch", "test persist plaintext")
    expect(resultPersist[0]).toBe("test persist plaintext");

    let result = await resumesFetch()
    expect(result["testPersistAvailableResumesFetch"]).toBe("test persist plaintext");
    expect(cachedResumes.cachedResumes["testPersistAvailableResumesFetch"]).toBe("test persist plaintext")
});
beforeEach(() => {
    testing.testing = true
})
afterEach(async () => {
    let result = await removeResumeFetch("testPersistAvailableResumesFetch")
    expect(result.length).toBe(1)
    testing.testing = false
    //todo: this is potentially dangerous, because if testing is false, you can add or delete from your local production database
    // it is likely that you wont share names, but we can make it even more unlikely by using guids in test names.
})
