import {HighLightPhrases} from "../../EditableHighlighter/Highlighter/HighLightPhrases";

describe('HighLightPhrases', () => {

    //TODO: this test will not work right now because the processing of the text skips over text that it determines is a match.
    // and because it will not search inner text of text it just matched and create nested divs.
    it('HighLightPhrases', () => {
        let textToLookUp = HighLightPhrases("secure identity", {
            "red": [],
            "green": ["identity --- security", "secure identity --- security"],
            "yellow": []
        });
        //todo: should be this
        // expect(textToLookUp).toEqual(
        //     `<div class='link line-secure-identity'></div>` +
        //              `<div onmouseenter="window.handleHoverG(this.textContent)" class='text-block green line-secure-identity'>` +
        //                 `<div onmouseenter="window.handleHoverG(this.textContent)" class='text-block green line-secure'>` +
        //                     `secure` +
        //                 `</div>` +
        //                 ` identity` +
        //              `</div>`
        // );
        expect(textToLookUp).toEqual(
            "<div class='link line-secure-identity'></div>" +
            "<div class='link line-identity'></div>" +
            "<div onmouseleave=\"window.setLinkElements([])\" " +
            "onmouseenter=\"window.handleHoverG(this.textContent)\" " +
            "class='text-block green'>secure identity</div>"
        );
    })
})