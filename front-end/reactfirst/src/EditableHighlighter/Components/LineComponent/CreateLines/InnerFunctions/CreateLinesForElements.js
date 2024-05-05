import {CreateLineFromValidBoundingRect} from "./CreateLineFromValidBoundingRect";
import {uuidv4} from "../../../../../Util/GUID";

export function createLinesForElements(elementsByClassNameFrom, elementsByClassNameTo, linkLineElementsC) {
    for (let fromI = 0; fromI < elementsByClassNameFrom.length; fromI++) {
        let boundingClientRectFrom = elementsByClassNameFrom[fromI].getBoundingClientRect();
        for (let toI = 0; toI < elementsByClassNameTo.length; toI++) {
            let boundingClientRectTo = elementsByClassNameTo[toI].getBoundingClientRect();
            CreateLineFromValidBoundingRect(
                linkLineElementsC,
                "line-" + uuidv4(),
                boundingClientRectFrom,
                boundingClientRectTo);
        }
    }
}