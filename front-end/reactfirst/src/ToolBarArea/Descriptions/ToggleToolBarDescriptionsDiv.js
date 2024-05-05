import {closeDisplaysExcept} from "../CloseDisplaysExcept";

export function ToggleToolBarDescriptionsDiv(evt, showAvailableDescriptionsBool, setShowDataViewBool) {
    setShowDataViewBool(!showAvailableDescriptionsBool)
    closeDisplaysExcept({showAvailableDescriptionsBool})
}