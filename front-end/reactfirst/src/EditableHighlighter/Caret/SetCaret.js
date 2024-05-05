import createRange from "./innerFunctions/CreateRange";
import {setCaretAfterRender} from "../EditableHighlighter";
export default function setCaret(chars, element) {
    console.log("setCaret: " + chars + ", element: " + element.id)
    if (chars >= 0) {
        setCaretAfterRender.f = () => {
            let selection = window.getSelection();

            let range = createRange(element, {count: chars});

            if (range) {
                range.collapse(false);
                selection.removeAllRanges();
                selection.addRange(range);
            }
        }
        setCaretAfterRender.f()
    }
}