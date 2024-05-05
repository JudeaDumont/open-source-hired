import isChildOf from "./innerFunctions/IsChildOf";

export default function getCaret(parentElement) {
    var selection = window.getSelection(),
        charCount = -1,
        node;

    if (selection.focusNode) {
        if (isChildOf(selection.focusNode, parentElement)) {
            node = selection.focusNode;
            charCount = selection.focusOffset;

            while (node) {
                if (node === parentElement) {
                    break;
                }

                if (node.previousSibling) {
                    node = node.previousSibling;
                    charCount += node.textContent.length;
                } else {
                    node = node.parentNode;
                    if (node === null) {
                        break;
                    }
                }
            }
        }
    }

    return charCount;
}