import {handlePasteR} from "../../EditableHighlighter/Handlers/R/HandlePasteR";
import {render, waitFor} from "@testing-library/react";
import App from "../../App";
import {text} from "../../EditableHighlighter/Initialize/InitialText";

describe('handlePasteR', () => {
    it('handlePasteR', async () => {
        // overwrite the text that gets pulled from InitialText
        text.resume = "_"
        text.jobDescription = "_"

        // render the app with empty text
        render(<App searchWordsAg={{"green": [], "yellow": []}}/>);

        //overwrite the global functions used to set html in r and jd, use as assert
        window.setHtmlRG = jest.fn(async (textR) => {
            await waitFor(() => {
                expect("<div data-testid='highlighted-resume'><div class='text-block white'>testR_</div></div>").toEqual(textR)
            }, {timeout: 10000})
        })
        window.setHtmlJDG = jest.fn(async (textJD) => {
            await waitFor(() => {
                expect("<div data-testid='highlighted-description'><div class='text-block white'>_</div></div>").toEqual(textJD)
            }, {timeout: 10000})
        })

        //mock out the event
        let evt = {}
        evt.clipboardData = {}
        evt.preventDefault = () => {
        }
        evt.clipboardData.getData = () => {
            return "testR"
        }

        // eslint-disable-next-line testing-library/no-node-access
        document.getElementById("resume-area").focus()

        //handlePasteR makes use of an innerfunction due to being referenced in App.js handle
        let innerFunc = handlePasteR();
        await innerFunc(evt);

        await waitFor(() => {
            expect(window.setHtmlRG).toBeCalledTimes(1)
        }, {timeout: 10000})

        await waitFor(() => {
            expect(window.setHtmlJDG).toBeCalledTimes(1)
        }, {timeout: 10000})
    })
})
