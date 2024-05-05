import {MatchDestinationEnum} from "../MatchDestinationEnum";

export function extractMatchSearchWords(searchWordsMatch, matchDestination) {
    return searchWordsMatch.map(i => {
        let split = i.split(" --- ");
        if (matchDestination === MatchDestinationEnum.JD) {
            return split[0]
        } else if (matchDestination === MatchDestinationEnum.R) {
            return split[1]
        } else {
            throw new Error("bad MatchDestinationEnum")
        }
    })
}