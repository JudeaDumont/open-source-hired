import {handlePersistDescriptionClick} from "../Handlers/HandlePersistDescriptionClick";

export function saveDescriptionButton() {
    return <button onClick={handlePersistDescriptionClick()}>SAVE</button>;
}