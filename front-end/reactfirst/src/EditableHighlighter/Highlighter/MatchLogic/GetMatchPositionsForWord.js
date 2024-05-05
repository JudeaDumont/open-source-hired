import {hugeMatchingRegularExpression} from "./HugeMatchingRegularExpression";

export function getMatchPositionsForWord(word, textToHighlight) {
    let regex =
        hugeMatchingRegularExpression(word);

    //todo: we are going to have to regex matching on the front end side, which will include the logic in: KeyPhrasePullLogic

    //want it to store the {position:['match-blue', 'match tests-green']}
    let matchPositions = []
    let match = -1

    //as long as you replace with the same number of characters this will not break
    let preprocessedTextToMatchAgainst = textToHighlight
        .toLowerCase()
        .replaceAll("-", " ")
        .replaceAll("/", " ")
        .replaceAll("|", " ")
        .replaceAll("(", " ")
        .replaceAll(")", " ")
        .replaceAll("\"", " ")
        .replaceAll(".", " ")

    while (match = (regex.exec(preprocessedTextToMatchAgainst))) {
        if (match[0] !== "") {
            matchPositions.push(match["index"]);
        } else {
            break;
        }
    }
    return matchPositions;
}