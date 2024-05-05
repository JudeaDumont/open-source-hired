import {
    getLongestMatch
} from "../../EditableHighlighter/Highlighter/createHighlightedText/innerFunctions/CreateMultiMatchHighlightHTML/GetLongestMatch";

describe('CreateMultiMatchHighlightedHTML', () => {

    it('CreateMultiMatchHighlightedHTML', () => {
        let result = getLongestMatch([["a=green", "a b=green"]], 0);
        expect(result).toEqual({text:"a b", color:"green"});
    })
})