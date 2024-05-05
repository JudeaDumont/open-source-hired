import {loadResume} from "../../ToolBarArea/Resumes/LoadResume";
import App from "../../App";
import {render, screen, waitFor} from "@testing-library/react";
import {testing} from "../../testingBool";
import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";
import persistResumeFetch from "../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import resumesFetch from "../../Fetch/ResumesFetch/ResumesFetch";
import {act} from "react-dom/test-utils";
import browserCacheGetCurrentResumeName from "../../BrowserCache/CurrentResume/Name/browserCacheGetCurrentResumeName";

describe('loadResume', () => {

    jest.setTimeout(20000)
    it('loadResume', async () => {

        render(<App searchWordsAg={{"green": [], "yellow": []}}></App>)

        await waitFor(() => {
            expect(screen.getByTestId('highlighted-description')).toBeInTheDocument()
        }, {timeout: 17000})

        window.setHtmlRG = jest.fn((textR) => {
            expect(textR).toEqual(
                    `<div data-testid='highlighted-resume'><div class='link line-test'></div><div onmouseleave="window.setLinkElements([])" onmouseenter="window.handleHoverG(this.textContent)" class='text-block green'>test</div><div class='text-block white'> </div><div class='text-block yellow'>persist</div><div class='text-block white'> </div><div class='text-block yellow'>plaintext</div></div>`
            )
        })
        window.setHtmlJDG = jest.fn((textJD) => {
            expect(textJD).not.toBeNull()
        })

        let resultPersist = await persistResumeFetch("testPersistAvailableResumesFetch", "test persist plaintext")
        expect(resultPersist[0]).toBe("test persist plaintext");

        expect(window.setHtmlRG).toBeCalledTimes(0)

        await resumesFetch()

        expect(window.setHtmlRG).toBeCalledTimes(0)

        await act(async () => {
            await (loadResume("testPersistAvailableResumesFetch"))()
        });

        let browserCacheGetCurrentResume1 = browserCacheGetCurrentResumeName();
        expect(browserCacheGetCurrentResume1).toBe("testPersistAvailableResumesFetch")

        expect(window.setHtmlRG).toBeCalledTimes(1)
        expect(window.setHtmlJDG).toBeCalledTimes(1)
    })
})
beforeEach(() => {
    testing.testing = true
})
afterEach(async () => {
    let result = await removeResumeFetch("testPersistAvailableResumesFetch")
    expect(result.length).toBe(1)
    testing.testing = false
    //todo: this is potentially dangerous,
    // because if testing is false, say: if you run all tests in parallel,
    // you can add or delete from your local production database
    // it is likely that you wont share names, but we can make it even more unlikely by using guids in test names.
    // that way the worst that happens iis you get weirdly names tests in your prod DB
})