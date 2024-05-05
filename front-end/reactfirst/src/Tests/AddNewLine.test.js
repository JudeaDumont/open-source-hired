import {addCharacterIntoString} from "../EditableHighlighter/Util/AddCharacterIntoString";
describe('stripTags', () => {

    it('addNewLine', () => {
        let newLined = addCharacterIntoString("aba", {selectionStart:0, selectionEnd:0});
        expect(newLined).toEqual("\n\raba");
    })
    it('addNewLine2', () => {
        let newLined = addCharacterIntoString("aba", {selectionStart:1, selectionEnd:1});
        expect(newLined).toEqual("a\n\rba");
    })
    it('addNewLine3', () => {
        let newLined = addCharacterIntoString("aba", {selectionStart:2, selectionEnd:2});
        expect(newLined).toEqual("ab\n\ra");
    })
    it('addNewLine4', () => {
        let newLined = addCharacterIntoString("aba", {selectionStart:3, selectionEnd:3});
        expect(newLined).toEqual("aba\n\r");
    })
    it('addNewLine5', () => {
        let newLined = addCharacterIntoString("aba", {selectionStart:1, selectionEnd:2});
        expect(newLined).toEqual("a\n\ra");
    })
})
