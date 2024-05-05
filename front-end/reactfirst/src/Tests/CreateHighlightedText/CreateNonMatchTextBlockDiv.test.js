import {
    createNonMatchTextBlockDiv
} from "../../EditableHighlighter/Highlighter/createHighlightedText/innerFunctions/CreateNonMatchTextBlockDiv";

describe('createNonMatchTextBlockDiv', () => {

    it('createNonMatchTextBlockDiv', () => {
        let textToLookUp = createNonMatchTextBlockDiv("green", "trying");
        expect(textToLookUp).toEqual(
            "<div class='text-block green'>trying</div>"
        );
    })
})
