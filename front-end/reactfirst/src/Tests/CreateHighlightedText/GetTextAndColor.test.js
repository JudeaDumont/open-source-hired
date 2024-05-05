import {
    getTextAndColor
} from "../../EditableHighlighter/Highlighter/createHighlightedText/innerFunctions/CreateMultiMatchHighlightHTML/GetTextAndColor";

describe('getTextAndColor', () => {

    it('getTextAndColor', () => {
        let textToLookUp = getTextAndColor("testing=green");
        expect(textToLookUp).toEqual({
                "text": "testing",
                "color": "green"
            }
        );
    })
})
