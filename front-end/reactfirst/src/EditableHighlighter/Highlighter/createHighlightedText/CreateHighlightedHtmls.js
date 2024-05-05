import {createUnhighlightedDiv} from "./innerFunctions/CreateUnhighlightedDiv";
import {pushHighlightedHtml} from "./innerFunctions/PushHighlightedHtml";

export function createHighlightedHtmls(textToHighlight, allMatchPositions) {
    let inOrderTextElements = [];
    let unHighlightedText = ""

    for (let i = 0; i < textToHighlight.length; i++) { //todo: this will never do multiple matches this way.
        if (allMatchPositions[i] !== undefined) { //all the matches at a certain position should be chained here... but are they?
            unHighlightedText = createUnhighlightedDiv(inOrderTextElements, unHighlightedText);
            i = pushHighlightedHtml(allMatchPositions, i, inOrderTextElements);
        } else {
            unHighlightedText += textToHighlight[i]
        }
    }
    unHighlightedText = createUnhighlightedDiv(inOrderTextElements, unHighlightedText)
    return inOrderTextElements;
}