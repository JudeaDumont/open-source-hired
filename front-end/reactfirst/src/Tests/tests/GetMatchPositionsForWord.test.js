import {getMatchPositionsForWord} from "../../EditableHighlighter/Highlighter/MatchLogic/GetMatchPositionsForWord";
import {testing} from "../../testingBool";

describe('GetFindAll', () => {

    it('test multiple match positions', () => {
        let matchPositions = getMatchPositionsForWord("text", "tests text text text to match my bruv");
        expect(matchPositions[0]).toEqual(6);
        expect(matchPositions[1]).toEqual(11);
        expect(matchPositions[2]).toEqual(16);
    })


    it('test single letter match', () => {
        let matchPositions = getMatchPositionsForWord("a", "search for ab b a");
        expect(matchPositions[0]).toEqual(16);
    })


    it('test bug 02042024', () => {
        let matchPositions = getMatchPositionsForWord("continuous integration pipeline", "- Coordinate and deliver continuous integration pipeline, test automation frameworks, and core product code");
        expect(matchPositions[0]).toEqual(25);
    })
    // it('test s', () => {
    //     let matchPositions = getMatchPositionsForWord("optimization", "optimizations");
    //     expect(matchPositions[0]).toEqual(0);
    // })
    beforeEach(() => {
        testing.testing = true
    })
    afterEach(() => {
        testing.testing = false
    })
})
