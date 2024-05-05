import {getElementsInLink} from "./GetElementsInLink";
import {createLinesForElements} from "./CreateLinesForElements";

export function createLinesFromLink(link, linkLineElementsC) {
    let {elementsByClassNameFrom, elementsByClassNameTo} = getElementsInLink(link);
    createLinesForElements(elementsByClassNameFrom, elementsByClassNameTo, linkLineElementsC);
}