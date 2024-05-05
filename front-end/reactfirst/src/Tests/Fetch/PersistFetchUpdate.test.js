import persistResumeFetch from "../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";
import {testing} from "../../testingBool";

test('persist fetch', async () => {
    let result = await persistResumeFetch("testUpdate_a", "x")
    expect(result[0]).toBe("x");
    let result2 = await persistResumeFetch("testUpdate_a", "y")
    expect(result2[0]).toBe("y");
});

beforeEach(() => {
    testing.testing = true
})

afterEach(async () => {
    let result = await removeResumeFetch("testUpdate_a")
    expect(result.length).toBe(1)
    testing.testing = false
})
