import setCaret from "../../EditableHighlighter/Caret/SetCaret";
import {render} from "@testing-library/react";
import App from "../../App";
import {getCaretPositionFromActiveElement} from "../../EditableHighlighter/Caret/GetCaretPositionFromActiveElement";

describe('getSelection', () => {

    it('getSelection', () => {
        render(<App searchWordsAg={{"green": ["a"], "yellow": []}}/>);

        // eslint-disable-next-line testing-library/no-node-access
        let elementById = document.getElementById("resume-area");
        // eslint-disable-next-line testing-library/no-node-access
        setCaret(1, elementById);
        elementById.focus();
        // eslint-disable-next-line testing-library/no-node-access

        let {activeElement, currentCursorPosition} = getCaretPositionFromActiveElement()
        expect(currentCursorPosition).toEqual(1)
        // eslint-disable-next-line testing-library/no-node-access
        expect(activeElement).toEqual(elementById)
    })
    it('getSelection2', () => {
        render(<App searchWordsAg={{"green": ["a"], "yellow": []}}/>);

        // eslint-disable-next-line testing-library/no-node-access
        let elementById = document.getElementById("description-area");
        // eslint-disable-next-line testing-library/no-node-access
        setCaret(1, elementById);
        elementById.focus();
        // eslint-disable-next-line testing-library/no-node-access

        let {activeElement, currentCursorPosition} = getCaretPositionFromActiveElement()
        expect(currentCursorPosition).toEqual(1)
        // eslint-disable-next-line testing-library/no-node-access
        expect(activeElement).toEqual(elementById)
    })
});