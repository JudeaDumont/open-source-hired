import {linkLines} from "../LineComponent";
import {createLinesFromValidLink} from "./InnerFunctions/CreateLinesFromValidLink";

export function createLinkLines(textContent) {
    let linkLineElementsC = []
    for (let linkI in linkLines.l) {
        let link = linkLines.l[linkI]
        createLinesFromValidLink(textContent, link, linkLineElementsC);
    }
    return linkLineElementsC;
}