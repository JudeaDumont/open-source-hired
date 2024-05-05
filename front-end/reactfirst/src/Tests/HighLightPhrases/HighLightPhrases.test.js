import {HighLightPhrases} from "../../EditableHighlighter/Highlighter/HighLightPhrases";

describe('HighLightPhrases', () => {

    it('HighLightPhrases', () => {
        let textToLookUp = HighLightPhrases("Testing", {"red": [], "green": ["testing --- test"], "yellow": []});
        expect(textToLookUp).toEqual(
            "<div class='link line-testing'></div><div onmouseleave=\"window.setLinkElements([])\" onmouseenter=\"window.handleHoverG(this.textContent)\" class='text-block green'>Testing</div>");
    })
})