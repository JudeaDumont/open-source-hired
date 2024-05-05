import {handleFetchDebounce} from "./HandleFetchDebounce";

export function handleClick() {
    return (evt) => {
        handleFetchDebounce(
            document.getElementById("description-area").textContent,
            document.getElementById("resume-area").textContent,
            () => {
            }
        );
    };
}