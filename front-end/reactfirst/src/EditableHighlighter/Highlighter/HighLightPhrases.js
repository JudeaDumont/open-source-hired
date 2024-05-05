import stripTags from "../Util/StripTags";
import generateInOrderTextProps from "./GenerateInOrderTextProps";
import {MatchDestinationEnum} from "./MatchDestinationEnum";

export function HighLightPhrases(fromString, searchWordsAg) {
    let string = generateInOrderTextProps(searchWordsAg,
        stripTags(fromString), MatchDestinationEnum.JD).join('');
    return string === "" ? "_" : string;
}

