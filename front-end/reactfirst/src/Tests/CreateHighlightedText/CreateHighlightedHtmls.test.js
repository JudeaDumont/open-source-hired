import {
    createHighlightedHtmls
} from "../../EditableHighlighter/Highlighter/createHighlightedText/CreateHighlightedHtmls";

describe('createHighlightedHtmls', () => {

    it('createHighlightedHtmls', () => {
        let textToLookUp = createHighlightedHtmls("testing", [["test=green"]]);
        expect(textToLookUp).toEqual([
            "<div class='link line-test'></div>",
            "<div onmouseleave=\"window.setLinkElements([])\" onmouseenter=\"window.handleHoverG(this.textContent)\" class='text-block green'>test</div>",
            "<div class='text-block white'>ing</div>"
        ]);
    })
})