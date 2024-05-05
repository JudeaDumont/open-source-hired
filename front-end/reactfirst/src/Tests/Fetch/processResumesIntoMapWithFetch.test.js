import persistResumeFetch from "../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";
import resumesFetch from "../../Fetch/ResumesFetch/ResumesFetch";
import {testing} from "../../testingBool";
import {cachedResumes} from "../../Fetch/ResumesFetch/CachedResumes";
import {getCachedResumeContent} from "../../Fetch/FetchCache/FetchResume/GetCachedResumeContent";

test('processResumesIntoMap', async () => {
    let resultPersist = await persistResumeFetch("testProcessResumesIntoMap", "test persist plaintext")
    expect(resultPersist[0]).toBe("test persist plaintext");

    await resumesFetch()
    expect(cachedResumes.cachedResumes["testProcessResumesIntoMap"]).toBe("test persist plaintext")
    expect(getCachedResumeContent("testProcessResumesIntoMap")).toBe("test persist plaintext")
});
beforeEach(() => {
    testing.testing = true
})
afterEach(async () => {
    let result = await removeResumeFetch("testProcessResumesIntoMap")
    expect(result.length).toBe(1)
    testing.testing = false
    //todo: this is potentially dangerous, because if testing is false, you can add or delete from your local production database
    // it is likely that you wont share names, but we can make it even more unlikely by using guids in test names.
})
