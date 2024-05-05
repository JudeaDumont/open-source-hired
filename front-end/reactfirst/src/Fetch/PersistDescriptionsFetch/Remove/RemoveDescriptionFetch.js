import {createDescriptionRemoveFormData} from "./CreateDescriptionRemoveFormData";
import {getRemoveDescriptionUrl} from "../../URLs/GetRemoveDescriptionUrl";

export default async function removeDescriptionFetch(resumeName) {
    let formData = createDescriptionRemoveFormData(resumeName);
    return await fetch(getRemoveDescriptionUrl(), {
        method: "POST",
        mode: 'cors',
        body: formData,
    }).then(r => r.json())
        .catch((e) => {
            //no-op, random fails, make sure the caller catches undefined.
        })
}