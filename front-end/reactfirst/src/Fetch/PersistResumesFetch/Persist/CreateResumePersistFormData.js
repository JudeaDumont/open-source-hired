export function createResumePersistFormData(resumeName, resumePlainText) {
    const formData = new FormData();
    formData.append("bundleName", resumeName);
    formData.append("content", resumePlainText);
    return formData;
}