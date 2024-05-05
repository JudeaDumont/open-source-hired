import {setCaretAfterRender} from "../EditableHighlighter";

export function SetCaretAfterRender() {
    if (setCaretAfterRender.f !== undefined) {
        setCaretAfterRender.f()
        setCaretAfterRender.f = undefined;
        //need the caret to be set AFTER the render
    }
}