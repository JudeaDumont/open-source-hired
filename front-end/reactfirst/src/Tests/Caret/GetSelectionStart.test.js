import setCaret from "../../EditableHighlighter/Caret/SetCaret";
import {render} from "@testing-library/react";
import App from "../../App";
import getSelectionStart from "../../EditableHighlighter/Caret/GetSelectionStart";

describe('getSelectionStart', () => {

    it('getSelectionStart', () => {
        render(<App searchWordsAg={{"green": ["a"], "yellow": []}}/>);

        // eslint-disable-next-line testing-library/no-node-access
        let elementById = document.getElementById("resume-area");
        // eslint-disable-next-line testing-library/no-node-access
        setCaret(1, elementById);
        // eslint-disable-next-line testing-library/no-node-access
        let charCount = getSelectionStart(elementById)
        expect(charCount).toEqual(1)
    })
});