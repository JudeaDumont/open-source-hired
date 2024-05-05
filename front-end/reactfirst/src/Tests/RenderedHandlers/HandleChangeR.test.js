import {render, screen, waitFor} from "@testing-library/react";
import App from "../../App";
import {text} from "../../EditableHighlighter/Initialize/InitialText";
import {handleKeyDownR} from "../../EditableHighlighter/Handlers/R/HandleKeyDownR";

describe('handleKeyDownR', () => {

    jest.setTimeout(20000)
    it('handleKeyDownR', async () => {
        // overwrite the text that gets pulled from InitialText
        text.resume = "_"
        text.jobDescription = "_"

        // render the app with empty text
        render(<App searchWordsAg={{"green": [], "yellow": []}}/>);

        //overwrite the global functions used to set html in r and jd, use as assert
        window.setHtmlRG = jest.fn(async (textR) => {
            await waitFor(() => {
                expect(textR)
                    .toContain("<div data-testid='highlighted-resume'><div class='text-block white'>_</div></div>")
            }, {timeout: 10000})
        })
        window.setHtmlJDG = jest.fn(async (textJD) => {
            await waitFor(() => {
                expect(textJD)
                    .toContain("_")
            }, {timeout: 10000})
        })

        //mock out the event
        let evt = {}
        evt.type = "input";
        evt.target = {}
        evt.target.value = "textR"

        //handlePasteR makes use of an innerfunction due to being referenced in App.js handle
        let innerFunc = handleKeyDownR();
        await innerFunc(evt);

        await waitFor(() => {
            expect(window.setHtmlJDG).toBeCalledTimes(1)
        }, {timeout: 10000})
        await waitFor(() => {
            expect(window.setHtmlRG).toBeCalledTimes(3)
        }, {timeout: 15000})
    })
})
