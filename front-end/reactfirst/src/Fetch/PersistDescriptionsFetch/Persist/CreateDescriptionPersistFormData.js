export function createDescriptionPersistFormData(descriptionName, descriptionContent) {
    const formData = new FormData();
    formData.append("descriptionName", descriptionName);
    formData.append("content", descriptionContent);
    return formData;
} //todo: needs to be hooked up to descriptions endpoint