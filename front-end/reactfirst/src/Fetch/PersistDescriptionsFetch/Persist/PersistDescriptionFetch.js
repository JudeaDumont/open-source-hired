import {createDescriptionPersistFormData} from "./CreateDescriptionPersistFormData";
import {getPersistDescriptionUrl} from "../../URLs/GetPersistDescriptionUrl";
//todo: needs to be hooked up to description endpoint after it is created
export default async function persistDescriptionFetch(descriptionName, descriptionPlainText) {
    const formData = createDescriptionPersistFormData(descriptionName, descriptionPlainText);
    return await fetch(getPersistDescriptionUrl(), {
        method: "POST",
        mode: 'cors',
        body: formData,
    })
        .then(r => r.json())
        .catch((e) => {
        //no-op, random fails, make sure the caller catches undefined.
    })
}