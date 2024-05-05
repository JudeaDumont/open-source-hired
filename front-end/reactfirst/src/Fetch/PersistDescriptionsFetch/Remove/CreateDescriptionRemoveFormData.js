export function createDescriptionRemoveFormData(descriptionName) {
    const formData = new FormData();
    formData.append("descriptionName", descriptionName);
    return formData;
}