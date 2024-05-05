export function processResumesIntoMap(jsonArrayWithResumes) {
    let mapNameResume = {}
    jsonArrayWithResumes.forEach((r)=>{
        let resumeObject = JSON.parse(r)
        mapNameResume[resumeObject.name] = resumeObject.plainTextToMatch
    });
    return mapNameResume
}