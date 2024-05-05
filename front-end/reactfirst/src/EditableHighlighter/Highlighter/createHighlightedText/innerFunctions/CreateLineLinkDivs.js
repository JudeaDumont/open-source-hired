import {createLineLinkDiv} from "../../../Components/LineComponent/CreateLines/CreateLineDivs/CreateLineLinkDiv";
import {getTextAndColor} from "./CreateMultiMatchHighlightHTML/GetTextAndColor";

export function createLineLinkDivs(inOrderTextElements, text, allMatchPositions, i) {
    //push all the links for all the matches at every position from here to the end of the longest matches text
    //text = longest match
    for(let startI = i; startI < i + text.length; startI++) {
        for(let matchIndex in allMatchPositions[startI]) {
            let textAndColor = getTextAndColor(allMatchPositions[startI][matchIndex]);
            if (textAndColor.color==="green") {
                inOrderTextElements.push(createLineLinkDiv(textAndColor.text))
            }
        }
    }
}