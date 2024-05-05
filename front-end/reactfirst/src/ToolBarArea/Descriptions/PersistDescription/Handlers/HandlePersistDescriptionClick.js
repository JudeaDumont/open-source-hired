import {validName} from "../Validation/ValidName";
import {getPersistDescriptionInputValue} from "../Validation/GetPersistDescriptionInputValue";
import {getDescriptionAreaTextContent} from "../Validation/GetDescriptionAreaTextContent";
import browserCacheSetCurrentDescriptionName
    from "../../../../BrowserCache/CurrentDescription/Name/browserCacheSetCurrentDescriptionName";
import persistDescriptionFetch from "../../../../Fetch/PersistDescriptionsFetch/Persist/PersistDescriptionFetch";

export function handlePersistDescriptionClick() {
    return (evt) => {
        if (validName(getPersistDescriptionInputValue())) {
            persistDescriptionFetch(getPersistDescriptionInputValue(),
                getDescriptionAreaTextContent());
            browserCacheSetCurrentDescriptionName(getPersistDescriptionInputValue())
            console.log("Success: " +
                getPersistDescriptionInputValue() + " was saved successfully")
            if (window.refreshAvailableDescriptionsDiv !== undefined) {
                window.refreshAvailableDescriptionsDiv(<></>)
            }
        } else {
            alert("Error: Attempted to Save bundle with invalid name")
        }
    }
}