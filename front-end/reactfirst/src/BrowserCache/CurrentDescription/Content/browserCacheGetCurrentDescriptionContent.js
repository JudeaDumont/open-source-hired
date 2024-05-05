export default function browserCacheGetCurrentDescriptionContent() {
    if (localStorage['currentDescriptionContent'] !== undefined) {
        return localStorage['currentDescriptionContent']
    } else {
        return ""
    }
}