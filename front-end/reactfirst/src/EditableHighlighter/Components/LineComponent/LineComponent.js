import React, {useState} from "react";
import handleHover from "./Handlers/HandleHover";

export let linkLines = {}

window.handleHoverG = handleHover
window.setLinkElements = null

export default function LineComponent(props) {

    const [linkLineElements, setLinkLineElements] = useState(
        []
    )

    window.setLinkElements = setLinkLineElements

    return (
        <div>
            {linkLineElements}
        </div>
    );
}