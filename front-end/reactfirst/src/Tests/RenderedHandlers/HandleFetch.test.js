import {handleFetchDebounce} from "../../EditableHighlighter/Handlers/HandleFetchDebounce";
import {waitFor} from "@testing-library/react";

describe('handleFetch', () => {
    jest.setTimeout(20000)
    it('handleFetch', async () => {
        window.setHtmlRG = jest.fn(async (textR) => {
            await waitFor(() => {
                expect("<div data-testid='highlighted-resume'><div class='text-block white'>testR</div></div>").toEqual(textR)
            }, {timeout: 10000})
        })
        window.setHtmlJDG = jest.fn(async (textJD) => {
            await waitFor(() => {
                expect("<div data-testid='highlighted-description'><div class='text-block white'>testJD</div></div>").toEqual(textJD)
            }, {timeout: 10000})
        })
        handleFetchDebounce("testJD", "testR", ()=>{});

        await waitFor(() => {
            expect(window.setHtmlRG).toBeCalledTimes(1)
        }, {timeout: 10000})

        await waitFor(() => {
            expect(window.setHtmlJDG).toBeCalledTimes(1)
        }, {timeout: 10000})
    })
})
