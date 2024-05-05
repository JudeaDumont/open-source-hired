import generateInOrderTextProps from "../../EditableHighlighter/Highlighter/GenerateInOrderTextProps";
import {MatchDestinationEnum} from "../../EditableHighlighter/Highlighter/MatchDestinationEnum";

describe('generateInOrderTextProps', () => {

    it('generateInOrderTextProps R does not match', () => {
        let textToLookUp = generateInOrderTextProps({
            "red": [],
            "green": ["a --- b"],
            "yellow": []
        }, "b", MatchDestinationEnum.JD);
        expect(textToLookUp).toEqual(["<div class='text-block white'>b</div>"]);
    })
    it('generateInOrderTextProps JD match', () => {
        let textToLookUp = generateInOrderTextProps({
            "red": [],
            "green": ["b --- a"],
            "yellow": []
        }, "b", MatchDestinationEnum.JD);
        expect(textToLookUp).toEqual([
            "<div class='link line-b'></div>",
            "<div onmouseleave=\"window.setLinkElements([])\" onmouseenter=\"window.handleHoverG(this.textContent)\" class='text-block green'>b</div>"
        ]);
    })
})
