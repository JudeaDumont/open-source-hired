import {text} from "../../EditableHighlighter/Initialize/InitialText";
import {render} from "@testing-library/react";
import App from "../../App";
import {setupLinkLines} from "../../EditableHighlighter/Components/LineComponent/SetupLinkLines";
import {
    getElementsInLink
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/GetElementsInLink";

describe('getElementsInLink', () => {

    it('getElementsInLink', () => {
        // overwrite the text that gets pulled from InitialText
        text.resume = "testJD"
        text.jobDescription = "testJD"

        // render the app with empty text
        render(<App searchWordsAg={{"green": ["testjd"], "yellow": []}}/>);

        let colorClassifications = {
            green: ["testjd --- testjd"]
        }
        setupLinkLines(colorClassifications);

        let {elementsByClassNameFrom, elementsByClassNameTo} =
            getElementsInLink({from:"line-testjd", to:"line-testjd"});
        expect(elementsByClassNameFrom.length).toEqual(1);
        expect(elementsByClassNameTo.length).toEqual(1);
    })
})
