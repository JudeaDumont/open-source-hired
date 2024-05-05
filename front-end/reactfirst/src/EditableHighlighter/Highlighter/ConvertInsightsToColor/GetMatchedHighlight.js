export function getMatchedHighlight(words) {
    //special treatment of html elements for drawing lines will be done at the time the html is created
    //matched because looks like: {
    //     "c++ --- c++": "[\"c++\"]"
    // }
    //one on the left is JD, the one on the right is R
    let strings = Object.keys(words);
    return strings // just give me J --- R
}