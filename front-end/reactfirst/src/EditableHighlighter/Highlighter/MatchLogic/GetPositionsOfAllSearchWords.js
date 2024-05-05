import {getMatchPositionsForWord} from "./GetMatchPositionsForWord";

//want it to store {position:['match-blue', 'match tests=green']}
export function getPositionsOfAllSearchWords(searchWordsAg, textToHighlight) {
    var allMatchPositions = {}
    for (let color in searchWordsAg) {
        for (let i in searchWordsAg[color]) {
            let matchPositionsForWord = getMatchPositionsForWord(searchWordsAg[color][i], textToHighlight);

            for (const position of matchPositionsForWord) {
                //if(allMatchPositions[position]!==undefined){throw new Error('DUPLICATE HIGHLIGHT!');}
                if(allMatchPositions[position] === undefined){
                    allMatchPositions[position] = []
                }
                allMatchPositions[position].push(
                    textToHighlight
                        .substring(position, position + searchWordsAg[color][i].length)
                    + '=' + color)
            }
        }
    }
    return allMatchPositions;
}