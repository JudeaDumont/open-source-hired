import {createLineLinkClassName} from "./CreateLines/CreateLineDivs/CreateLineLinkClassName";
import {linkLines} from "./LineComponent";

export function setupLinkLines(colorClassifcations) {
    linkLines.l = []
    for (let match in colorClassifcations.green) {
        let strings = colorClassifcations.green[match].split(" --- ");
        linkLines.l.push({
            from: createLineLinkClassName(strings[0]).trim(),
            to: createLineLinkClassName(strings[1]).trim()
        })
    }
}