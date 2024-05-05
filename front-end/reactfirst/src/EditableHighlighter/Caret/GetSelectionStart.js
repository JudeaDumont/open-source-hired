import isChildOf from "./innerFunctions/IsChildOf";
export default function getSelectionStart(parentElement) {
    let selection = window.getSelection(),
        charCount = -1,
        node;

    if (selection.anchorNode) {
        if (isChildOf(selection.anchorNode, parentElement)) {
            node = selection.anchorNode;
            charCount = selection.anchorOffset;

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