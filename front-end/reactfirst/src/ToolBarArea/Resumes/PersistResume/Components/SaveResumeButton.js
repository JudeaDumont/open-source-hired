import {handlePersistClick} from "../Handlers/HandlePersistClick";

export function saveResumeButton() {
    return <button onClick={handlePersistClick()}>SAVE</button>;
}