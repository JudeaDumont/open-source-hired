import {render, waitFor} from "@testing-library/react";
import App from "../../App";
import {text} from "../../EditableHighlighter/Initialize/InitialText";
import {handleKeyDownJD} from "../../EditableHighlighter/Handlers/JD/HandleKeyDownJD";

describe('handleKeyDownJD', () => {
    jest.setTimeout(20000)
    it('handleKeyDownJD', async () => {
        // overwrite the text that gets pulled from InitialText
        text.resume = "_"
        text.jobDescription = "_"

        // render the app with empty text
        render(<App searchWordsAg={{"green": [], "yellow": []}}/>);

        //overwrite the global functions used to set html in r and jd, use as assert
        window.setHtmlRG = jest.fn(async (textR) => {
            await waitFor(() => {
                expect(`<div data-testid='highlighted-resume'><div class='text-block white'>_</div></div>`).toEqual(textR)
            }, {timeout: 10000})
        })
        window.setHtmlJDG = jest.fn(async (textJD) => {
            await waitFor(() => {
                expect(`<div data-testid='highlighted-description'><div class='text-block white'>
_</div></div>`).toEqual(textJD)
            }, {timeout: 15000})
        })

        //mock out the event
        let evt = {}
        evt.type = "keydown";
        evt.keyCode = 13;
        evt.preventDefault = () => {
        }

        // eslint-disable-next-line testing-library/no-node-access
        document.getElementById("resume-area").focus()

        //handleKeyDownJD makes use of an innerfunction due to being referenced in App.js handle
        let innerFunc = handleKeyDownJD();
        await innerFunc(evt);

        await waitFor(() => {
            expect(window.setHtmlRG).toBeCalledTimes(1)
        }, {timeout: 10000})

        await waitFor(() => {
            expect(window.setHtmlJDG).toBeCalledTimes(3)
        }, {timeout: 10000})
    })
})
