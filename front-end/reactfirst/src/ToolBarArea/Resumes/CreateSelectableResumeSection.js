import {loadResume} from "./LoadResume";
import {removeResume} from "./RemoveResume";

export function createSelectableResumeSection(resumeName) {
    return (
        <div className={"resume-section"}
             key={resumeName}>
            <h5
                className={"selectable-resume"}
                onClick={loadResume(resumeName)}
            >
                {resumeName}
            </h5>
            <button
                onClick={removeResume(resumeName)}
                className={"remove-button"}
            >
                X
            </button>
        </div>
    );
}