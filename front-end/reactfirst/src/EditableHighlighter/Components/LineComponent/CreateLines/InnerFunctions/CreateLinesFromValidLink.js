import {createLineLinkClassName} from "../CreateLineDivs/CreateLineLinkClassName";
import {createLinesFromLink} from "./CreateLinesFromLink";

export function createLinesFromValidLink(textContent, link, linkLineElementsC) {
    let linkClassName = createLineLinkClassName(textContent).trim();
    if (
        linkClassName.includes(link.from.substring(4)) || //doing includes with the "line-" removed takes care of partial word matches
        linkClassName.includes(link.to.substring(4)) ||
        link.from.includes(linkClassName.substring(4))||
        link.to.includes(linkClassName.substring(4))
    ) {
        createLinesFromLink(link, linkLineElementsC);
    }
}