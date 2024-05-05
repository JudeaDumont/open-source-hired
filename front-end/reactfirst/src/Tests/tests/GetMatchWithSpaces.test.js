import {getMatchPositionsForWord} from "../../EditableHighlighter/Highlighter/MatchLogic/GetMatchPositionsForWord";

describe('GetMatchWithSpaces', () => {

    it('GetMatchWithSpaces', () => {
        let matchPositions = getMatchPositionsForWord(
            "senior software engineer iv",
            "     senior software engineer iv     ");
        expect(matchPositions[0]).toEqual(5);
    })
})
