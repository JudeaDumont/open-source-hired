import {getTextAndColor} from "./GetTextAndColor";

export function getLongestMatch(allMatchPositions, i) {
    let longestMatch = {}
    let longestNum = 0
    for(let matchPosition in allMatchPositions[i]) {
        let {color, text} = getTextAndColor(allMatchPositions[i][matchPosition]);
        if(text.length > longestNum){
            longestNum = text.length
            longestMatch.color = color
            longestMatch.text = text
        }
    }
    return longestMatch
}