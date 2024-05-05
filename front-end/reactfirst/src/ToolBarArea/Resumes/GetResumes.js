import resumesFetch from "../../Fetch/ResumesFetch/ResumesFetch";

export async function getResumes() {
    return await resumesFetch().then((resumeMap) => {
            return resumeMap
        }
    );
}