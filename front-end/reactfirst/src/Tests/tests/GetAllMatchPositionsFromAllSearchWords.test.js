import {getPositionsOfAllSearchWords} from "../../EditableHighlighter/Highlighter/MatchLogic/GetPositionsOfAllSearchWords";

describe('GetFindAll', () => {

    it('test all match positions', () => {
        let allMatchPositions = getPositionsOfAllSearchWords({"green":["a","b"]},"search for ab b a");
        expect(allMatchPositions[16][0]).toEqual("a=green");
        expect(allMatchPositions[14][0]).toEqual("b=green");
    })

    it('test double a', () => {
        let allMatchPositions = getPositionsOfAllSearchWords({"green":["a","b"]},"search for ab a a");
        expect(allMatchPositions[14][0]).toEqual("a=green");
        expect(allMatchPositions[16][0]).toEqual("a=green");
    })
})
