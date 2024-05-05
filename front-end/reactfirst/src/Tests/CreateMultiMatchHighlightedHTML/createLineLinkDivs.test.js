import {
    createLineLinkDivs
} from "../../EditableHighlighter/Highlighter/createHighlightedText/innerFunctions/CreateLineLinkDivs";

describe('createLineLinkDivs', () => {

    it('createLineLinkDivs', () => {
        let inOrderTextElements = []
        let text = "chef jeff"
        let allMatchPositions = []
        allMatchPositions[0] = ["chef jeff=green", "chef=green"]
        allMatchPositions[5] = ["jeff=green"]
        let i = 0

        createLineLinkDivs(inOrderTextElements, text, allMatchPositions, i);
        expect(inOrderTextElements).toEqual([
            "<div class='link line-chef-jeff'></div>",
            "<div class='link line-chef'></div>",
            "<div class='link line-jeff'></div>"
        ]);
    })
})