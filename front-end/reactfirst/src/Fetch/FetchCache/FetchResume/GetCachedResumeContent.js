import {cachedResumes} from "../../ResumesFetch/CachedResumes";

export function getCachedResumeContent(name) {
    return cachedResumes.cachedResumes[name];
}