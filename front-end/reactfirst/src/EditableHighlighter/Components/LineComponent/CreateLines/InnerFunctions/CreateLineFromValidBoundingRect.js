import {getBoundingRect} from "./GetBoundingRect";

export function CreateLineFromValidBoundingRect(linkLineElementsC, id, boundingClientRectFrom, boundingClientRectTo) {
    let {x0, y0, x1, y1} = getBoundingRect(boundingClientRectFrom, boundingClientRectTo);
    window.checkAndPushLineDivsG( //indirection availability for testing
        linkLineElementsC,
        id
        , x0, y0, x1, y1);
}