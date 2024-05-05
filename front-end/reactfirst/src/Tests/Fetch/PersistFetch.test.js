import persistResumeFetch from "../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";
import {testing} from "../../testingBool";

test('persist fetch', async () => {
    let result = await persistResumeFetch("testPlainTextBundleResumeSave", "test resume plaintext bundle save")
    expect(result[0]).toBe("test resume plaintext bundle save");
});

beforeEach(() => {
    testing.testing = true
})

afterEach(async () => {
    let result = await removeResumeFetch("testPlainTextBundleResumeSave")
    expect(result.length).toBe(1)
    testing.testing = false
})

//todo: now I want an endpoint to save resume plaintext under a guid of an existing resume.
// so if it is a guid it replaces, and if it is a name it creates a new one?
// what about keeping a history of a particular resume?
// you could probably organize the resumes by a last created timestamp under a particular name
// then return whatever the most recent one was?
// then you could write an endpoint like: get getHistory
// and it would pull all the resumes of a particular name.

//todo: the moment is coming where I want to have an alternative production database, which is pretty cool.
// so, when the java servlets are running, they will use a different datasource than the current one.
