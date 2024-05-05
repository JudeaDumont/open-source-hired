import removeDescriptionFetch from "../../Fetch/PersistDescriptionsFetch/Remove/RemoveDescriptionFetch";

export function removeDescription(descriptionName) {
    return async () => {
        await removeDescriptionFetch(descriptionName)
        if (window.refreshAvailableDescriptionsDiv!==undefined) {
            window.refreshAvailableDescriptionsDiv(<></>);
        }
    };
}