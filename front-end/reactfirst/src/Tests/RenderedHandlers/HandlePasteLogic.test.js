import {handlePasteLogic} from "../../EditableHighlighter/Handlers/HandlePasteLogic";

describe('handlePasteLogic', () => {

    it('handlePasteLogic', () => {
        let evt = {}
        evt.clipboardData = {}
        evt.clipboardData.getData = () => {
            return "b"
        }
        let textToLookUp = handlePasteLogic(evt, document.activeElement);
        expect(textToLookUp).toEqual({
                "newTextContent": "b",
                "caretPosition": 0
            }
        );
    })
})
