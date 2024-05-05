import {getPositionsOfAllSearchWords} from "../../EditableHighlighter/Highlighter/MatchLogic/GetPositionsOfAllSearchWords";

describe('GetFindAll', () => {

    it('test all match positions', () => {
        let allMatchPositions = getPositionsOfAllSearchWords(
            {"green":["java 11"]},"java 11");
        expect(allMatchPositions[0][0]).toEqual("java 11=green");
    })
})
