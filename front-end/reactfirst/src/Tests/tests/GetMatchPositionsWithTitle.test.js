import {getMatchPositionsForWord} from "../../EditableHighlighter/Highlighter/MatchLogic/GetMatchPositionsForWord";

describe('Match slash', () => {

    it('Match slash', () => {
        let matchPositions = getMatchPositionsForWord(
            "a b testing",
            "A/B Testing");
        expect(matchPositions[0]).toEqual(0);
    })

    it('Match pipe', () => {
        let matchPositions = getMatchPositionsForWord(
            "a b testing",
            "A|B Testing");
        expect(matchPositions[0]).toEqual(0);
    })
})
