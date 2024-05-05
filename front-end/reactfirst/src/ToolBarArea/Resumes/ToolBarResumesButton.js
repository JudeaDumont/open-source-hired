import {toggleToolBarResumesDiv} from "./ToggleToolBarResumesDiv";

export function ToolBarResumesButton(showAvailableResumesBool, setShowDataViewBool) {
    return <button className={"toolbar-resume-button toolbar-button"}
                   onClick={
                       (evt) => toggleToolBarResumesDiv(evt, showAvailableResumesBool, setShowDataViewBool)
                   }
    >
        Resumes
    </button>;
}