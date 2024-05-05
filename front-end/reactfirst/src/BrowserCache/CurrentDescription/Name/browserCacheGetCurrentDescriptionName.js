export default function browserCacheGetCurrentDescriptionName() {
    if (localStorage['currentDescriptionName'] !== undefined) {
        return localStorage['currentDescriptionName']
    } else {
        return ""
    }
}