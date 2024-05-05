import {createMatchTextBlockDiv} from "./CreateMatchTextBlockDiv";
import {createNonMatchTextBlockDiv} from "./CreateNonMatchTextBlockDiv";
import {getLongestMatch} from "./CreateMultiMatchHighlightHTML/GetLongestMatch";
import {createLineLinkDivs} from "./CreateLineLinkDivs";

export function pushHighlightedHtml(allMatchPositions, i, inOrderTextElements) {
    //highlight the longest match only, create links for all matches
    let {text, color} = getLongestMatch(allMatchPositions, i);
    if (color === "green") {
        createLineLinkDivs(inOrderTextElements, text, allMatchPositions, i);
        inOrderTextElements.push(createMatchTextBlockDiv(color, text))
    } else {
        inOrderTextElements.push(createNonMatchTextBlockDiv(color, text))
    }
    i += text.length - 1    //this skips to the end of the longest match
    return i;
}