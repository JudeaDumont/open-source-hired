export default function browserCacheGetCurrentResumeName() {
    if (localStorage['currentResumeName'] !== undefined) {
        return localStorage['currentResumeName']
    } else {
        return ""
    }
}