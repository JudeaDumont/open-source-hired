import {extractMatchSearchWords} from "../../EditableHighlighter/Highlighter/MatchLogic/ExtractMatchSearchWords";
import {MatchDestinationEnum} from "../../EditableHighlighter/Highlighter/MatchDestinationEnum";

describe('ExtractMatchSearchWords', () => {

    it('ExtractMatchSearchWordsJD', () => {
        let textToLookUp = extractMatchSearchWords(["a --- b"], MatchDestinationEnum.JD);
        expect(textToLookUp).toEqual(["a"]);
    })

    it('ExtractMatchSearchWordsR', () => {
        let textToLookUp = extractMatchSearchWords(["a --- b"], MatchDestinationEnum.R);
        expect(textToLookUp).toEqual(["b"]);
    })
})
