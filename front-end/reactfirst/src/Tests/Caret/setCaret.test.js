import setCaret from "../../EditableHighlighter/Caret/SetCaret";
import {render} from "@testing-library/react";
import App from "../../App";
import getCaret from "../../EditableHighlighter/Caret/GetCaret";

describe('setCaret', () => {

    it('setCaret', () => {
        render(<App searchWordsAg={{"green": ["a"], "yellow": []}}/>);

        // eslint-disable-next-line testing-library/no-node-access
        let elementById = document.getElementById("resume-area");
        setCaret(2, elementById);
        let charCount = getCaret(elementById)
        expect(charCount).toEqual(2)
    })
});