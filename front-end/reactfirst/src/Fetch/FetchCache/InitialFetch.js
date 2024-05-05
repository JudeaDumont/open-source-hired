import {HighLightPhrasesFetch} from "./HighLightPhrasesFetch";

export async function initialFetch() {
    let [stringJD, stringR] = await HighLightPhrasesFetch(
        document.getElementById("description-area").textContent,
        document.getElementById("resume-area").textContent);
    await window.setHtmlJDG(
        stringJD);
    await window.setHtmlRG(
        stringR);
}