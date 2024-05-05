import {ToggleToolBarDescriptionsDiv} from "./ToggleToolBarDescriptionsDiv";

export function ToolBarDescriptionsButton(showDescriptionsBool, setShowDataViewBool) {
    return <button className={"toolbar-description-button toolbar-button"}
                   onClick={
                       (evt) =>
                           ToggleToolBarDescriptionsDiv(evt, showDescriptionsBool, setShowDataViewBool)
                   }
    >
        Jobs
    </button>;
}

//todo: once the description plumbing is implemented, we can write another test for all the implementations
// essentially duplicating "ResumeSelection.test.js"