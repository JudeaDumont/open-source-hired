import React from "react";
import react, {useEffect, useState} from "react";
import ContentEditable from "react-contenteditable";
import {handleKeyDownJD} from "./Handlers/JD/HandleKeyDownJD";
import {handlePasteJD} from "./Handlers/JD/HandlePasteJD";
import {handleKeyDownR} from "./Handlers/R/HandleKeyDownR";
import {handlePasteR} from "./Handlers/R/HandlePasteR";
import {initialFetch} from "../Fetch/FetchCache/InitialFetch";
import LineComponent from "./Components/LineComponent/LineComponent";
import {SetCaretAfterRender} from "./Caret/SetCaretAfterRender";
import {getInitialDescription} from "./GetInitialDescription";
import {getInitialResume} from "./GetInitialResume";
import {handleSelect} from "./Handlers/HandleSelect";
import {handleClick} from "./Handlers/HandleClick";

export let setCaretAfterRender = {};

export default function EditableHighlighter(props) {

    let thisRefJD = react.createRef();
    let thisRefR = react.createRef();

    const [htmlJD, setHtmlJD] = useState(
        getInitialDescription(props)
    )
    window.setHtmlJDG = setHtmlJD

    const [htmlR, setHtmlR] = useState(
        getInitialResume(props)
    )
    window.setHtmlRG = setHtmlR

    useEffect(() => {
        (async () => {
            await initialFetch();
        })()
    }, []);

    useEffect(() => {

        // code to run after render goes here
        SetCaretAfterRender();
    }, [htmlJD, htmlR]);

    const handleBlur = (evt) => {

    };

    const onKeyDownJD = handleKeyDownJD();
    const onPasteJD = handlePasteJD();

    const onKeyDownR = handleKeyDownR();
    const onPasteR = handlePasteR();

    const onSelect = handleSelect();
    const onClick = handleClick();

    return (<div>
            <LineComponent></LineComponent>
            <div
            >
                <ContentEditable html={htmlJD}
                                 onChange={()=>0}
                                 onKeyDown={onKeyDownJD}
                                 onPaste={onPasteJD}
                                 innerRef={thisRefJD}
                                 onBlur={handleBlur}
                                 className={"editable"}
                                 id={"description-area"}
                                 data-testid={"description-area"}
                                 onSelect={onSelect}
                                 onClick={onClick}
                >
                </ContentEditable>
            </div>
            <div>
                <ContentEditable html={htmlR}
                                 onChange={()=>0}
                                 onKeyDown={onKeyDownR}
                                 onPaste={onPasteR}
                                 innerRef={thisRefR}
                                 onBlur={handleBlur}
                                 className={"editable"}
                                 id={"resume-area"}
                                 data-testid={"resume-area"}
                                 onSelect={onSelect}
                                 onClick={onClick}
                >
                </ContentEditable>
            </div>
        </div>
    );
}
