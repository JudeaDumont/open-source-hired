import {closeDisplaysExcept} from "../CloseDisplaysExcept";

export function toggleToolBarResumesDiv(evt, showAvailableResumesBool, setShowDataViewBool) {
    setShowDataViewBool(!showAvailableResumesBool)
    closeDisplaysExcept({showAvailableResumesBool})
}