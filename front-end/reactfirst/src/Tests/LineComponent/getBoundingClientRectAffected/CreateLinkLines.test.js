import {createLinkLines} from "../../../EditableHighlighter/Components/LineComponent/CreateLines/CreateLinkLines";
import {text} from "../../../EditableHighlighter/Initialize/InitialText";
import {render} from "@testing-library/react";
import App from "../../../App";
import {setupLinkLines} from "../../../EditableHighlighter/Components/LineComponent/SetupLinkLines";
import {mockOutCheckAndPushLineDiv} from "./mockOutCheckAndPushLineDiv";

describe('createLinkLines', () => {

    it('createLinkLines', () => {
        // overwrite the text that gets pulled from InitialText
        text.resume = "testJD"
        text.jobDescription = "testJD"

        // render the app with empty text
        render(<App searchWordsAg={{"green": ["testjd"], "yellow": []}}/>);
        mockOutCheckAndPushLineDiv();

        let colorClassifications = {
            green: ["testjd --- testjd"]
        }
        setupLinkLines(colorClassifications);

        let linkLines = createLinkLines("testJD");
        expect(linkLines).toEqual([])

        expect(window.checkAndPushLineDivsG).toBeCalledTimes(1)
    })
})
