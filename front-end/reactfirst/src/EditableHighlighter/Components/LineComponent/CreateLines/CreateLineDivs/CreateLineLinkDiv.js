import {createLineLinkClassName} from "./CreateLineLinkClassName";

export function createLineLinkDiv(text) {
    let lineLinkClassName = createLineLinkClassName(text);
    return "<div class='link " + lineLinkClassName + "'></div>";
}