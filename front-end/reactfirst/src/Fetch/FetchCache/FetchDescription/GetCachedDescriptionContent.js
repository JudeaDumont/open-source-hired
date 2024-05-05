import {cachedDescriptions} from "../../DescriptionsFetch/CachedDescriptions";

export function getCachedDescriptionContent(name) {
    return cachedDescriptions.cachedDescriptions[name];
}