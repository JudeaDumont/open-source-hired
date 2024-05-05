import removeResumeFetch from "../../Fetch/PersistResumesFetch/Remove/RemoveResumeFetch";

export function removeResume(resumeName) {
    return async () => {
        await removeResumeFetch(resumeName)
        if (window.refreshAvailableResumesDiv!==undefined) {
            window.refreshAvailableResumesDiv(<></>);
        }
    };
}