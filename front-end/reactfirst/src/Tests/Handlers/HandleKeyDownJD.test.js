import {render} from "@testing-library/react";
import App from "../../App";
import {text} from "../../EditableHighlighter/Initialize/InitialText";
import {handleKeyDownJD} from "../../EditableHighlighter/Handlers/JD/HandleKeyDownJD";
import browserCacheGetCurrentDescriptionContent
    from "../../BrowserCache/CurrentDescription/Content/browserCacheGetCurrentDescriptionContent";
import setCaret from "../../EditableHighlighter/Caret/SetCaret";

describe('handleKeyDownJD', () => {
    jest.setTimeout(20000)
    it('handleKeyDownJD', async () => {
        text.resume = "aba"
        text.jobDescription = "aba"

        render(<App searchWordsAg={{"green": [], "yellow": []}}/>);

        // eslint-disable-next-line testing-library/no-node-access
        let descriptionArea = document.getElementById("description-area");

        //must set the active element for handleKeyDownJD to work
        descriptionArea.focus()

        //suppose we are testing setCaret too, good
        setCaret(1, descriptionArea)

        let innerFunction = handleKeyDownJD()
        let evt = {
            type: "keydown",
            keyCode: "65",
            key: "z",
        }
        innerFunction(evt);

        expect(browserCacheGetCurrentDescriptionContent()).toBe("azba")
    })
})
