import persistDescriptionFetch from "../../Fetch/PersistDescriptionsFetch/Persist/PersistDescriptionFetch";
import removeDescriptionFetch from "../../Fetch/PersistDescriptionsFetch/Remove/RemoveDescriptionFetch";
import {testing} from "../../testingBool";

test('persistDescriptionFetch', async () => {
    let result = await persistDescriptionFetch(
        "testDescriptionSave", "test description content save")
    expect(result[0]).toBe("test description content save");
});

beforeEach(() => {
    testing.testing = true
})

afterEach(async () => {
    let result = await removeDescriptionFetch("testDescriptionSave")
    expect(result.length).toBe(1)
    testing.testing = false
})