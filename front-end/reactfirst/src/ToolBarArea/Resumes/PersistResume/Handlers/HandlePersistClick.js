import persistResumeFetch from "../../../../Fetch/PersistResumesFetch/Persist/PersistResumeFetch";
import {validName} from "../Validation/ValidName";
import {getPersistResumeInputValue} from "../Validation/GetPersistResumeInputValue";
import {getResumeAreaTextContent} from "../Validation/GetResumeAreaTextContent";
import browserCacheSetCurrentResumeName
    from "../../../../BrowserCache/CurrentResume/Name/browserCacheSetCurrentResumeName";

export function handlePersistClick() {
    return (evt) => {
        if (validName(getPersistResumeInputValue())) {
            persistResumeFetch(getPersistResumeInputValue(),
                getResumeAreaTextContent());
            browserCacheSetCurrentResumeName(getPersistResumeInputValue())
            console.log("Success: " +
                getPersistResumeInputValue() + " was saved successfully")
            if (window.refreshAvailableResumesDiv !== undefined) {
                window.refreshAvailableResumesDiv(<></>)
            }
        } else {
            alert("Error: Attempted to Save bundle with invalid name")
        }
    }
}