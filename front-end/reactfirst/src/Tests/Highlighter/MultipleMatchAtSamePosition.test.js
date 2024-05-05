import {getPositionsOfAllSearchWords} from "../../EditableHighlighter/Highlighter/MatchLogic/GetPositionsOfAllSearchWords";

describe('GetFindAll', () => {

    it('test all match positions', () => {
        let allMatchPositions = getPositionsOfAllSearchWords({"green":["a","a b"]},"search for a b");
        expect(allMatchPositions[11][0]).toEqual("a=green");
        expect(allMatchPositions[11][1]).toEqual("a b=green");
    })
})
