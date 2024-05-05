import {getMatchPositionsForWord} from "../../EditableHighlighter/Highlighter/MatchLogic/GetMatchPositionsForWord";

describe('GetFindAll', () => {

    it('test c#', () => {
        let matchPositions = getMatchPositionsForWord("c#", "c#");
        expect(matchPositions[0]).toEqual(0);
    })

    it('test c# and just a c', () => {
        let matchPositions = getMatchPositionsForWord("c#", "c");
        expect(matchPositions[0]).toEqual(undefined);
    })
    it('test pluralization', () => {
        let matchPositions = getMatchPositionsForWord("test", "tests");
        expect(matchPositions[0]).toEqual(0);
    })
})
