import {getMatchedHighlight} from "../EditableHighlighter/Highlighter/ConvertInsightsToColor/GetMatchedHighlight";

describe('GetMatchedHighlight', () => {

    it('test getMatchedHighlight', () => {
        let result = getMatchedHighlight({"c++ --- c++": "[\"c++\"]"});
        expect(result).toEqual(["c++ --- c++"])
    })
})
