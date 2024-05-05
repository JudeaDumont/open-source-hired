import {
    createLinesFromValidLink
} from "../../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CreateLinesFromValidLink";
import {text} from "../../../EditableHighlighter/Initialize/InitialText";
import {render} from "@testing-library/react";
import App from "../../../App";
import {setupLinkLines} from "../../../EditableHighlighter/Components/LineComponent/SetupLinkLines";
import {mockOutCheckAndPushLineDiv} from "./mockOutCheckAndPushLineDiv";

describe('createLinesFromValidLink', () => {

    it('createLinesFromValidLink', () => {
        // overwrite the text that gets pulled from InitialText
        text.resume = "a"
        text.jobDescription = "a"

        // render the app with empty text
        render(<App searchWordsAg={{"green": ["a"], "yellow": []}}/>);
        mockOutCheckAndPushLineDiv();

        let colorClassifications = {
            green: ["a --- a"]
        }
        setupLinkLines(colorClassifications);

        let linkLineElementsC = [];
        createLinesFromValidLink("a", {from: "line-a", to:"line-a"}, linkLineElementsC);
        expect(linkLineElementsC).toEqual([])

        expect(window.checkAndPushLineDivsG).toBeCalledTimes(1)})
})
