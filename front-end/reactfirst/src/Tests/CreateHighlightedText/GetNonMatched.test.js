import {getNonMatched} from "../../EditableHighlighter/Highlighter/ConvertInsightsToColor/GetNonMatched";

describe('getNonMatched', () => {

    it('getNonMatched', () => {
        let textToLookUp = getNonMatched({"[these,are,alike,phrases]": "and the category they are under"});
        expect(textToLookUp).toEqual([
            "these",
            "are",
            "alike",
            "phrases"
        ]);
    })
})
