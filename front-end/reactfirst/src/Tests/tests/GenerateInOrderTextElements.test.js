import generateInOrderTextProps from "../../EditableHighlighter/Highlighter/GenerateInOrderTextProps";
import {MatchDestinationEnum} from "../../EditableHighlighter/Highlighter/MatchDestinationEnum";

describe('GenerateInOrderTextElements', () => {

    //to test this out I would need to mock out createElement from react.
    it('test generateInOrderTextProps', () => {
        let generateInOrderTextElements1 = generateInOrderTextProps({"green": ["a", "b"]}, "b c a a the", MatchDestinationEnum.JD);
        expect(generateInOrderTextElements1[0]).toEqual("<div class='link line-b'></div>")
        expect(generateInOrderTextElements1[1]).toEqual(
            "<div onmouseleave=\"window.setLinkElements([])\" onmouseenter=\"window.handleHoverG(this.textContent)\" class='text-block green'>b</div>")
        expect(generateInOrderTextElements1[2]).toEqual("<div class='text-block white'> c </div>")
        expect(generateInOrderTextElements1[3]).toEqual("<div class='link line-a'></div>")
        expect(generateInOrderTextElements1[4]).toEqual("<div onmouseleave=\"window.setLinkElements([])\" onmouseenter=\"window.handleHoverG(this.textContent)\" class='text-block green'>a</div>")
        expect(generateInOrderTextElements1[5]).toEqual("<div class='text-block white'> </div>")
        expect(generateInOrderTextElements1[6]).toEqual("<div class='link line-a'></div>")
        expect(generateInOrderTextElements1[7]).toEqual("<div onmouseleave=\"window.setLinkElements([])\" onmouseenter=\"window.handleHoverG(this.textContent)\" class='text-block green'>a</div>")
        expect(generateInOrderTextElements1[8]).toEqual("<div class='text-block white'> the</div>")
        expect(generateInOrderTextElements1[9]).toEqual(undefined)
    })
})
