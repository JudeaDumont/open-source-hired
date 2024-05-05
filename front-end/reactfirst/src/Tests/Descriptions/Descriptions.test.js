import {render, screen, waitFor} from "@testing-library/react";
import App from "../../App";
import {
    setDescriptionInputTextBoxValue
} from "../../ToolBarArea/Descriptions/PersistDescription/Components/SetDescriptionInputTextBoxValue";
import {testing} from "../../testingBool";
import removeDescriptionFetch from "../../Fetch/PersistDescriptionsFetch/Remove/RemoveDescriptionFetch";
import {loadDescription} from "../../ToolBarArea/Descriptions/LoadDescription";
import {removeDescription} from "../../ToolBarArea/Descriptions/RemoveDescription";
import {act} from "react-dom/test-utils";
import {
    handlePersistDescriptionClick
} from "../../ToolBarArea/Descriptions/PersistDescription/Handlers/HandlePersistDescriptionClick";

describe('DescriptionSelection', () => {

    jest.setTimeout(15000)
    it('DescriptionSelection', async () => {
        render(<App showHiddenDivsDescription={true} searchWordsAg={{"green": ["a"], "yellow": []}}/>);
        const linkElement = screen.getAllByText(/Available Descriptions/i)[0];
        expect(linkElement).toBeInTheDocument();

        // set the description name value to testDescriptionSelection
        setDescriptionInputTextBoxValue("testDescriptionSelection")

        // eslint-disable-next-line testing-library/no-node-access
        const value = document.getElementById("persist-description-input").value;
        expect(value).toBe("testDescriptionSelection");

        // click persist
        await act(async () => {
            await handlePersistDescriptionClick()()
        });

        //wait for it to show in the div
        setDescriptionInputTextBoxValue("") //dont want getAllByText to get the inputBoxValue
        await waitFor(() => {
            expect(screen.getAllByText('testDescriptionSelection')[0]).toBeInTheDocument()
        }, {timeout: 10000})

        //do the same thing again for a second description name
        //*****************************************************

        // set the description name value to testDescriptionSelection
        setDescriptionInputTextBoxValue("testAnotherDescriptionSelection")

        // eslint-disable-next-line testing-library/no-node-access
        const value2 = document.getElementById("persist-description-input").value;
        expect(value2).toBe("testAnotherDescriptionSelection");

        // click persist
        await act(async () => {
            await handlePersistDescriptionClick()()
        });

        //wait for it to show in the div
        setDescriptionInputTextBoxValue("") //dont want getAllByText to get the inputBoxValue
        await waitFor(() => {
            expect(screen.getAllByText('testAnotherDescriptionSelection')[0]).toBeInTheDocument()
        }, {timeout: 10000})

        //select the prior description, then make sure the inputTextValue is changed
        await act(async () => {
            await loadDescription("testDescriptionSelection")()
        });
        await waitFor(() => {
            // eslint-disable-next-line testing-library/no-node-access
            let persistDescriptionInput = document.getElementById("persist-description-input");
            expect(persistDescriptionInput).not.toBeNull()
        }, {timeout: 10000})
        await waitFor(() => {
            // eslint-disable-next-line testing-library/no-node-access
            let persistDescriptionInputValue = document.getElementById("persist-description-input").value;
            expect(persistDescriptionInputValue).toBe("testDescriptionSelection")
        }, {timeout: 10000})

        //Now delete them both using the UI, afterEach expects zeros for both
        await act(async () => {
            await removeDescription("testDescriptionSelection")()
            await removeDescription("testAnotherDescriptionSelection")()
        });
        await waitFor(() => {
            expect(screen.queryByText('testDescriptionSelection')).toBe(null)
        }, {timeout: 10000})
        await waitFor(() => {
            expect(screen.queryByText('testAnotherDescriptionSelection')).toBe(null)
        }, {timeout: 10000})
    })

    beforeEach(() => {
        testing.testing = true
    })
    afterEach(async () => {
        let result = await removeDescriptionFetch("testDescriptionSelection")
        expect(result.length).toBe(0)
        let result2 = await removeDescriptionFetch("testAnotherDescriptionSelection")
        expect(result2.length).toBe(0)
        testing.testing = false
        //todo: this is potentially dangerous, because if testing is false, you can add or delete from your local production database
        // it is likely that you wont share names, but we can make it even more unlikely by using guids in test names.
    })
})
