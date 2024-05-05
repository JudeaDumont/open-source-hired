import {getNonMatched} from "../EditableHighlighter/Highlighter/ConvertInsightsToColor/GetNonMatched";

describe('getMissedHighlight', () => {

    it('test getNonMatched', () => {
        let result = getNonMatched({"[a]": 1, "[b,c]": 1});
        expect(result).toEqual(["a", "b", "c"])
    })
})
