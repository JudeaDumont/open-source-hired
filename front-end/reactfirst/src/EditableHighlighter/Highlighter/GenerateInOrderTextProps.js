import {getPositionsOfAllSearchWords} from "./MatchLogic/GetPositionsOfAllSearchWords";
import {extractMatchSearchWords} from "./MatchLogic/ExtractMatchSearchWords";
import {createHighlightedHtmls} from "./createHighlightedText/CreateHighlightedHtmls";

export default function generateInOrderTextProps(searchWordsAg, textToHighlight, matchDestination) {
    let destinationSpecificMatches =
        {
            yellow: searchWordsAg.yellow,
            red: searchWordsAg.red,
            green: extractMatchSearchWords(searchWordsAg.green, matchDestination)
        };
    let allMatchPositions = getPositionsOfAllSearchWords(destinationSpecificMatches, textToHighlight);
    return createHighlightedHtmls(textToHighlight, allMatchPositions);
}
