import handleHover from "../../../EditableHighlighter/Components/LineComponent/Handlers/HandleHover";
import {text} from "../../../EditableHighlighter/Initialize/InitialText";
import {render} from "@testing-library/react";
import App from "../../../App";
import {setupLinkLines} from "../../../EditableHighlighter/Components/LineComponent/SetupLinkLines";
import {mockOutCheckAndPushLineDiv} from "./mockOutCheckAndPushLineDiv";

describe('handleHover', () => {

    it('handleHover', async () => {
        // overwrite the text that gets pulled from InitialText
        text.resume = "testJD"
        text.jobDescription = "testJD"

        // render the app with empty text
        render(<App searchWordsAg={{"green": ["testjd"], "yellow": []}}/>);
        mockOutCheckAndPushLineDiv();

        window.setLinkElements = jest.fn((elements) => {
            expect(elements).toEqual([]) //todo: this is not testable in this way because there is no browser to draw in, so it is always 0
        })

        let colorClassifications = {
            green: ["testjd --- testjd"]
        }
        setupLinkLines(colorClassifications);

        await handleHover("testJD");

        expect(window.setLinkElements).toBeCalledTimes(1)
        expect(window.checkAndPushLineDivsG).toBeCalledTimes(1)
    })
})
