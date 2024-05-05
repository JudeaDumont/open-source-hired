import {createLinkLines} from "../CreateLines/CreateLinkLines";

export default function handleHover(textContent) {
    if (window.setLinkElements !== null) {
        let linkLineElementsC = createLinkLines(textContent);
        window.setLinkElements(linkLineElementsC)
    }
}