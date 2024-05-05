export default function browserCacheGetCurrentResumeContent() {
    if (localStorage['currentResumeContent'] !== undefined) {
        return localStorage['currentResumeContent']
    } else {
        return ""
    }
}