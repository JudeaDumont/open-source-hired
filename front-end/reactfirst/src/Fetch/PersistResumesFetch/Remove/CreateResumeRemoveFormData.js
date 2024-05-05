export function createResumeRemoveFormData(bundleName) {
    const formData = new FormData();
    formData.append("bundleName", bundleName);
    return formData;
}