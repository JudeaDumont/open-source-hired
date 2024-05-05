export function validCachedText(description) {
    if (description === undefined ||
        description === "" ||
        description === "undefined") {
        return false;
    }

    let replace = description.trim().replace("_", "");

    if(replace === ""){
        return false;
    }

    return true;
}