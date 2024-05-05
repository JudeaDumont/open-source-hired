import {render} from '@testing-library/react';
import App from '../App';
import {text} from "../EditableHighlighter/Initialize/InitialText";
import handleHover from "../EditableHighlighter/Components/LineComponent/Handlers/HandleHover";
import {setupLinkLines} from "../EditableHighlighter/Components/LineComponent/SetupLinkLines";

test('renders learn react link', () => {
    text.resume = "jdtest";
    text.jobDescription = "jdtest";
    render(<App searchWordsAg={{"green": ["jdtest"], "yellow": []}}/>);

    window.setLinkElements = jest.fn((elements) => {
        expect(elements).toEqual([]) //todo: this is not testable in this way because there is no browser to draw in, so it is always 0
    })

    let colorClassifications = {
        green: ["jdtest --- jdtest"]
    }
    setupLinkLines(colorClassifications);

    handleHover("jdtest");
    expect(window.setLinkElements).toBeCalledTimes(1)

});
