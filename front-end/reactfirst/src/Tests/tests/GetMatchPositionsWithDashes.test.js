import {getMatchPositionsForWord} from "../../EditableHighlighter/Highlighter/MatchLogic/GetMatchPositionsForWord";

describe('GetMatchPositionsWithDashes', () => {

    it('GetMatchPositionsWithDashes', () => {
        let matchPositions = getMatchPositionsForWord(
            "empirical-results-driven",
            "empirical results driven");
        expect(matchPositions[0]).toEqual(0);
    })

    it('GetMatchPositionsWithDashesResume', () => {
        let matchPositions = getMatchPositionsForWord(
            "empirical results driven",
            "empirical-results-driven");
        expect(matchPositions[0]).toEqual(0);
    })

    it('GetMatchPositionsWithDashesResume2', () => {
        let matchPositions = getMatchPositionsForWord(
            "front line leadership",
            "front-line leadership");
        expect(matchPositions[0]).toEqual(0);
    })
})
