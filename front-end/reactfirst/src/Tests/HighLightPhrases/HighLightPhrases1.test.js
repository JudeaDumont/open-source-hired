import {HighLightPhrases} from "../../EditableHighlighter/Highlighter/HighLightPhrases";

describe('HighLightPhrases', () => {

    it('HighLightPhrases', () => {
        let textToLookUp = HighLightPhrases("secure identity", {
            "red": [],
            "green": ["identity --- security", "secure --- security"],
            "yellow": []
        });
        expect(textToLookUp).toEqual(
            `<div class='link line-secure'></div>` +
                    `<div onmouseleave="window.setLinkElements([])" onmouseenter="window.handleHoverG(this.textContent)" class='text-block green'>secure</div>` +
                    `<div class='text-block white'> </div><div class='link line-identity'></div>` +
                    `<div onmouseleave="window.setLinkElements([])" onmouseenter="window.handleHoverG(this.textContent)" class='text-block green'>identity</div>`
        );
    })
})