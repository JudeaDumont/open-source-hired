import {render} from "@testing-library/react";
import App from "../../App";
import {text} from "../../EditableHighlighter/Initialize/InitialText";
import setCaret from "../../EditableHighlighter/Caret/SetCaret";
import {handleKeyDownR} from "../../EditableHighlighter/Handlers/R/HandleKeyDownR";
import browserCacheGetCurrentResumeContent
    from "../../BrowserCache/CurrentResume/Content/browserCacheGetCurrentResumeContent";

describe('handleKeyDownR', () => {
    jest.setTimeout(20000)
    it('handleKeyDownR', async () => {
        text.resume = "aba"
        text.jobDescription = "aba"

        render(<App searchWordsAg={{"green": [], "yellow": []}}/>);

        // eslint-disable-next-line testing-library/no-node-access
        let resumeArea = document.getElementById("resume-area");

        //must set the active element for handleKeyDownJD to work
        resumeArea.focus()

        //suppose we are testing setCaret too, good
        setCaret(1, resumeArea)

        let innerFunction = handleKeyDownR()
        let evt = {
            type: "keydown",
            keyCode: "65",
            key: "z",
        }
        innerFunction(evt);

        expect(browserCacheGetCurrentResumeContent()).toBe("azba")
    })
})
