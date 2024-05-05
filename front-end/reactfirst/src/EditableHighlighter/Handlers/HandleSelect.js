import {handleFetchDebounce} from "./HandleFetchDebounce";

export function handleSelect() {
    return (evt) => {
        handleFetchDebounce(
            document.getElementById("description-area").textContent,
            document.getElementById("resume-area").textContent,
            () => {
            }
        );
    };
}