export function getNonMatched(words) {
    let strings = Object.keys(words)
        .map(i => {
            return i.toString().replace(", ", ",").replace("[", "").replace("]", "")
        });
    let joined = strings.join(",");
    return joined.split(",");
}