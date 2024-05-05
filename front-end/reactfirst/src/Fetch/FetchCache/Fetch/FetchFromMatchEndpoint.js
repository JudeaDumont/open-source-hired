import {createFormData} from "./CreateFormData";
import {getMatchUrl} from "../../URLs/GetMatchUrl";

export function fetchFromMatchEndpoint(fromStringJD, fromStringR) {
    const formData = createFormData(fromStringJD, fromStringR);
    return fetch(getMatchUrl(), {
        method: 'POST',
        mode: 'cors',
        body: formData // body data type must match "Content-Type" header
    }).catch((e) => {
        //no-op, random fails, make sure the caller catches undefined.
    })
}