import {
    createMatchTextBlockDiv
} from "../../EditableHighlighter/Highlighter/createHighlightedText/innerFunctions/CreateMatchTextBlockDiv";

describe('createMatchTextBlockDiv', () => {

    it('createMatchTextBlockDiv', () => {
        let textToLookUp = createMatchTextBlockDiv("green", "testing");
        expect(textToLookUp).toEqual(
        "<div onmouseleave=\"window.setLinkElements([])\" onmouseenter=\"window.handleHoverG(this.textContent)\" class='text-block green'>testing</div>"
        );
    })
})
