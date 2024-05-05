import setCaret from "../../EditableHighlighter/Caret/SetCaret";
import {render} from "@testing-library/react";
import App from "../../App";
import {getSelection} from "../../EditableHighlighter/Caret/GetSelection";

describe('getSelection', () => {

    it('getSelection', () => {
        render(<App searchWordsAg={{"green": ["a"], "yellow": []}}/>);

        // eslint-disable-next-line testing-library/no-node-access
        let elementById = document.getElementById("resume-area");
        // eslint-disable-next-line testing-library/no-node-access
        setCaret(1, elementById);
        // eslint-disable-next-line testing-library/no-node-access
        let {selectionStart, selectionEnd} = getSelection(elementById)
        expect(selectionStart).toEqual(1)
        expect(selectionEnd).toEqual(1)
    })
});