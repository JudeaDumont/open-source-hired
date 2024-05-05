import browserCacheSetCurrentDescriptionName
    from "../../BrowserCache/CurrentDescription/Name/browserCacheSetCurrentDescriptionName";
import {setDescriptionInputTextBoxValue} from "./PersistDescription/Components/SetDescriptionInputTextBoxValue";

export function setCurrentDescriptionName(name) {
    browserCacheSetCurrentDescriptionName(name)
    setDescriptionInputTextBoxValue(name);
}