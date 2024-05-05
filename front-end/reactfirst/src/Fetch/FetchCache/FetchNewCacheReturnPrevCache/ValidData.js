export function validData(data) {
    return data !== undefined &&
        data.body !== undefined &&
        data.body.data !== undefined &&
        data.body.data.match !== undefined;
}