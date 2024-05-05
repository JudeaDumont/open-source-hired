import {getResumesUI} from "./GetResumesUI";
import {useEffect, useState} from "react";
import {PersistResumesDiv} from "./PersistResume/Components/PersistResumesDiv";

export function ToolBarResumesDiv() {
    const [availableResumes, setAvailableResumes] = useState(<></>)
    window.refreshAvailableResumesDiv = setAvailableResumes
    useEffect(() => {
        getResumesUI().then((resumes) => {
            setAvailableResumes(resumes)
        })
    }, [availableResumes]);
    return <div className={"toolbar-resume-div toolbar-div"}>
        <h3>Available Resumes</h3>
        {PersistResumesDiv()}
        {availableResumes}
    </div>;
}