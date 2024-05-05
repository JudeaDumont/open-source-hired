import browserCacheGetCurrentDescriptionName
    from "../../../../BrowserCache/CurrentDescription/Name/browserCacheGetCurrentDescriptionName";
import {saveDescriptionButton} from "./SaveDescriptionButton";

export function PersistDescriptionsDiv() {
    return <>
        <input id={"persist-description-input"} type={"text"} defaultValue={browserCacheGetCurrentDescriptionName()}/>
        <br/>
        {saveDescriptionButton()}
    </>
}