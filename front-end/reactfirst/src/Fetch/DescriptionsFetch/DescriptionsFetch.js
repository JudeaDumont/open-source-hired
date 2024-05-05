import {cachedDescriptions} from "./CachedDescriptions";
import {getAllDescriptionsUrl} from "../URLs/GetAllDescriptionsUrl";
import {processDescriptionsIntoMap} from "../../ToolBarArea/Descriptions/ProcessDescriptionsIntoMap";

export default async function descriptionsFetch() {
    try {
        return await fetch(getAllDescriptionsUrl(), {
            method: "GET",
            mode: 'cors'
        }).then(r => {
            return r.json()
        }).then(j => {
            cachedDescriptions.cachedDescriptions = processDescriptionsIntoMap(j);
            return cachedDescriptions.cachedDescriptions
        })
    } catch (e) {
        //no-op, sometimes fails with "insufficient resources"
        return cachedDescriptions.cachedDescriptions;
    }
}