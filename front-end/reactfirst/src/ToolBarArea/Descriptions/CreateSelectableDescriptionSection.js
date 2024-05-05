import {loadDescription} from "./LoadDescription";
import {removeDescription} from "./RemoveDescription";

export function createSelectableDescriptionSection(descriptionName) {
    return (
        <div className={"description-section"}
             key={descriptionName}>
            <h5
                className={"selectable-description"}
                onClick={loadDescription(descriptionName)}
            >
                {descriptionName}
            </h5>
            <button
                onClick={removeDescription(descriptionName)}
                className={"remove-button"}
            >
                X
            </button>
        </div>
    );
}