import {
    pushHighlightedHtml
} from "../../EditableHighlighter/Highlighter/createHighlightedText/innerFunctions/PushHighlightedHtml";

describe('pushHighlightedHtml', () => {

    it('pushHighlightedHtml', () => {
        let inOrderTextElements = []
        let textToLookUp = pushHighlightedHtml([["test=green"]], 0, inOrderTextElements);
        expect(inOrderTextElements[0]).toEqual("<div class='link line-test'></div>")
        expect(inOrderTextElements[1]).toEqual(
            "<div onmouseleave=\"window.setLinkElements([])\" onmouseenter=\"window.handleHoverG(this.textContent)\" class='text-block green'>test</div>")
        expect(textToLookUp).toEqual(3);
    })
})
