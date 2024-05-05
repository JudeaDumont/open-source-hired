export default function isChildOf(node, parentElement) {
    while (node !== null) {
        if (node === parentElement) {
            return true;
        }
        node = node.parentNode;
    }

    return false;
}