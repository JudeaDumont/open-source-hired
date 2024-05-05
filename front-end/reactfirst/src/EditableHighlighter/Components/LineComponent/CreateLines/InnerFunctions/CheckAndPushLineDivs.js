import {createLineDiv} from "./CreateLineDiv";

export function checkAndPushLineDivs(elementContainer, id, x0, y0, x1, y1) {
    if (x0 !== 0 && y0 !== 0 && x1 !== 0 && y1 !== 0) {
        elementContainer.push(
            createLineDiv(id, x0, y0, x1, y1))
    }
}