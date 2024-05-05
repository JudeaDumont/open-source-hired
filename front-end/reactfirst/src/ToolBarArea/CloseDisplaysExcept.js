export function closeDisplaysExcept(bool) {
    if (bool.showAvailableResumesBool === undefined) {
        window.setShowResumesUIBool(false)
    }
    if (bool.showAvailableDescriptionsBool === undefined) {
        window.setShowDescriptionsBool(false)
    }
}