import {getAllBundlesUrl} from "../URLs/GetAllBundlesUrl";
import {cachedResumes} from "./CachedResumes";
import {processResumesIntoMap} from "../../ToolBarArea/Resumes/ProcessResumesIntoMap";

export default async function resumesFetch() {
    try {
        return await fetch(getAllBundlesUrl(), {
            method: "GET",
            mode: 'cors'
        }).then(r => {
            return r.json()
        }).then(j => {
            cachedResumes.cachedResumes = processResumesIntoMap(j);
            return cachedResumes.cachedResumes
        })
    } catch (e) {
        //no-op, sometimes fails with "insufficient resources"
        return cachedResumes.cachedResumes;
    }
}