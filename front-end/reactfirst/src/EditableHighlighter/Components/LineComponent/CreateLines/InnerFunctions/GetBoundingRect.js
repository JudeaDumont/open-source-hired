export function getBoundingRect(boundingClientRectFrom, boundingClientRectTo) {
    let x0 = boundingClientRectFrom.x;
    let y0 = boundingClientRectFrom.y;
    let x1 = boundingClientRectTo.x;
    let y1 = boundingClientRectTo.y;
    return {x0, y0, x1, y1};
}