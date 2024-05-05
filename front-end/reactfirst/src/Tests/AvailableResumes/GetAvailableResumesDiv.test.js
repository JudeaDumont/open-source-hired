import {testing} from "../../testingBool";
import persistResumeFetch from "../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";
import {ToolBarResumesDiv} from "../../ToolBarArea/Resumes/ToolBarResumesDiv";
import {render, screen, waitFor} from "@testing-library/react";

describe('GetAvailableResumesDiv', () => {

    it('GetAvailableResumesDiv', async () => {
        let resultPersist = await persistResumeFetch("testPersistAvailableResumes", "test persist plaintext")
        expect(resultPersist[0]).toBe("test persist plaintext");

        render(<ToolBarResumesDiv></ToolBarResumesDiv>);

        await waitFor(() => {
            let byText = screen.getByText(/testPersistAvailableResumes/i);
            expect(byText).toBeInTheDocument();
        }, {timeout:1000});
    })
})
beforeEach(() => {
    testing.testing = true
})
afterEach(async () => {
    let result = await removeResumeFetch("testPersistAvailableResumes")
    expect(result.length).toBe(1)
    testing.testing = false
})