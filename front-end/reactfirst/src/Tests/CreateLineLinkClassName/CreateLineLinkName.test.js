import {
    createLineLinkClassName
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/CreateLineDivs/CreateLineLinkClassName";
describe('CreateLineLinkName', () => {

    it('CreateLineLinkName', () => {
        let textToLookUp = createLineLinkClassName("tesT To LookUp");
        expect(textToLookUp).toEqual("line-test-to-lookup");
    })
})
