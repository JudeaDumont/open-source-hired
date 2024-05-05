import {createResumePersistFormData} from "./CreateResumePersistFormData";
import {getPersistResumeBundleUrl} from "../../URLs/GetPersistResumeBundleUrl";

export default async function persistResumeFetch(resumeName, resumePlainText) {
    const formData = createResumePersistFormData(resumeName, resumePlainText);
    return await fetch(getPersistResumeBundleUrl(), {
        method: "POST",
        mode: 'cors',
        body: formData,
    })
        .then(r => r.json())
        .catch((e) => {
        //no-op, random fails, make sure the caller catches undefined.
    })
}