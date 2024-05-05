//todo: put a fetch limiter in! haha, it can get real slow if you blast "java" in 800 times.
export function createFormData(fromStringJD, fromStringR) {
    const formData = new FormData();
    formData.append("jdPlainText", fromStringJD);
    formData.append("rPlainText", fromStringR);
    return formData;
}