import {convertInsightsToColorClassifications} from "../../EditableHighlighter/Highlighter/ConvertInsightsToColor/ConvertInsightsToColorClassifications";
import {testing} from "../../testingBool";

describe('convertInsightsToColorClassifications', () => {

    it('test convertInsightsToColorClassifications', () => {
        let generateInOrderTextElements1 = convertInsightsToColorClassifications(
            "{\"combinedMissed\":{\"ht\":{\"[c++,a]\":1,\"[python]\":1},\"totalDensity\":2},\"matched\":{\"ht\":{},\"totalDensity\":0},\"combinedMatchedBecause\":{},\"combinedSuperfluous\":{\"ht\":{\"[c#]\":1},\"totalDensity\":1},\"matchPercentage\":0.0}");
        expect(generateInOrderTextElements1).toEqual({"green": [],"red": ["c++", "a", "python"], "yellow": ["c#"]})
    })
})
beforeEach(() => {
    testing.testing = true
})
afterEach(() => {
    testing.testing = false
})
