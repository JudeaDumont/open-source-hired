export function isArrowKey(evt) {
    return evt.code === "ArrowDown" ||
        evt.code === "ArrowRight" ||
        evt.code === "ArrowLeft" ||
        evt.code === "ArrowUp";
}