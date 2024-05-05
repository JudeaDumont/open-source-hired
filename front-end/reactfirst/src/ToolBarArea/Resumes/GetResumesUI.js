import {getResumes} from "./GetResumes";
import {createSelectableResumeSection} from "./CreateSelectableResumeSection";

export async function getResumesUI() {
    return await getResumes().then((resumes) => {
            let selectableResumes = []
            Object.keys(resumes).forEach((key, index) => {
                selectableResumes.push(createSelectableResumeSection(key))
            });
            return selectableResumes
        }
    );
}