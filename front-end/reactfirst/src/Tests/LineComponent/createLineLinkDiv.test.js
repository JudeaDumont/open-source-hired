import {
    createLineLinkDiv
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/CreateLineDivs/CreateLineLinkDiv";

describe('createLineLinkDiv', () => {

    it('createLineLinkDiv', () => {
        let result = createLineLinkDiv("a");

        expect(result).toEqual("<div class='link line-a'></div>")
    })
})
