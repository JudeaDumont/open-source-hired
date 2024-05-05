import {createResumeRemoveFormData} from "./CreateResumeRemoveFormData";
import {getRemoveBundleUrl} from "../../URLs/GetRemoveBundleUrl";

export default async function removeResumeFetch(resumeName) {
    let formData = createResumeRemoveFormData(resumeName);
    return await fetch(getRemoveBundleUrl(), {
        method: "POST",
        mode: 'cors',
        body: formData,
    }).then(r => r.json())
        .catch((e) => {
            //no-op, random fails, make sure the caller catches undefined.
        })
}