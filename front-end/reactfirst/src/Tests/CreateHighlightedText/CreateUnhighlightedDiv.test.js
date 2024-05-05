import {
    createUnhighlightedDiv
} from "../../EditableHighlighter/Highlighter/createHighlightedText/innerFunctions/CreateUnhighlightedDiv";

describe('createUnhighlightedDiv', () => {

    it('createUnhighlightedDiv', () => {
        let inOrderelements = []
        createUnhighlightedDiv(inOrderelements, "unwanted");
        expect(inOrderelements).toEqual([
            "<div class='text-block white'>unwanted</div>"
        ]);
    })
})
