import {render, screen, waitFor} from "@testing-library/react";
import App from "../../App";
import {
    setResumeInputTextBoxValue
} from "../../ToolBarArea/Resumes/PersistResume/Components/SetResumeInputTextBoxValue";
import {testing} from "../../testingBool";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";
import {handlePersistClick} from "../../ToolBarArea/Resumes/PersistResume/Handlers/HandlePersistClick";
import {loadResume} from "../../ToolBarArea/Resumes/LoadResume";
import {removeResume} from "../../ToolBarArea/Resumes/RemoveResume";
import {act} from "react-dom/test-utils";

describe('ResumeSelection', () => {

    jest.setTimeout(15000)
    it('ResumeSelection', async () => {
        render(<App showHiddenDivsResume={true} searchWordsAg={{"green": ["a"], "yellow": []}}/>);
        const linkElement = screen.getAllByText(/Available Resumes/i)[0];
        expect(linkElement).toBeInTheDocument();

        // set the resume name value to testResumeSelection
        setResumeInputTextBoxValue("testResumeSelection")

        // eslint-disable-next-line testing-library/no-node-access
        const value = document.getElementById("persist-resume-input").value;
        expect(value).toBe("testResumeSelection");

        // click persist
        await act(async () => {
            await handlePersistClick()()
        });

        //wait for it to show in the div
        setResumeInputTextBoxValue("") //dont want getAllByText to get the inputBoxValue
        await waitFor(() => {
            expect(screen.getAllByText('testResumeSelection')[0]).toBeInTheDocument()
        }, {timeout: 10000})

        //do the same thing again for a second resume name
        //*****************************************************

        // set the resume name value to testResumeSelection
        setResumeInputTextBoxValue("testAnotherResumeSelection")

        // eslint-disable-next-line testing-library/no-node-access
        const value2 = document.getElementById("persist-resume-input").value;
        expect(value2).toBe("testAnotherResumeSelection");

        // click persist
        await act(async () => {
            await handlePersistClick()()
        });

        //wait for it to show in the div
        setResumeInputTextBoxValue("") //dont want getAllByText to get the inputBoxValue
        await waitFor(() => {
            expect(screen.getAllByText('testAnotherResumeSelection')[0]).toBeInTheDocument()
        }, {timeout: 10000})

        //select the prior resume, then make sure the inputTextValue is changed
        await act(async () => {
            await loadResume("testResumeSelection")()
        });
        await waitFor(() => {
            // eslint-disable-next-line testing-library/no-node-access
            let persistResumeInput = document.getElementById("persist-resume-input");
            expect(persistResumeInput).not.toBeNull()
        }, {timeout: 10000})
        await waitFor(() => {
            // eslint-disable-next-line testing-library/no-node-access
            let persistResumeInputValue = document.getElementById("persist-resume-input").value;
            expect(persistResumeInputValue).toBe("testResumeSelection")
        }, {timeout: 10000})

        //Now delete them both using the UI, afterEach expects zeros for both
        await act(async () => {
            await removeResume("testResumeSelection")()
            await removeResume("testAnotherResumeSelection")()
        });
        await waitFor(() => {
            expect(screen.queryByText('testResumeSelection')).toBe(null)
        }, {timeout: 10000})
        await waitFor(() => {
            expect(screen.queryByText('testAnotherResumeSelection')).toBe(null)
        }, {timeout: 10000})
    })

    beforeEach(() => {
        testing.testing = true
    })
    afterEach(async () => {
        let result = await removeResumeFetch("testResumeSelection")
        expect(result.length).toBe(0)
        let result2 = await removeResumeFetch("testAnotherResumeSelection")
        expect(result2.length).toBe(0)
        testing.testing = false
        //todo: this is potentially dangerous, because if testing is false, you can add or delete from your local production database
        // it is likely that you wont share names, but we can make it even more unlikely by using guids in test names.
    })
})
