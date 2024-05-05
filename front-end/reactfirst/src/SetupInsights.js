import {
    convertInsightsToColorClassifications
} from "./EditableHighlighter/Highlighter/ConvertInsightsToColor/ConvertInsightsToColorClassifications";
import {setupLinkLines} from "./EditableHighlighter/Components/LineComponent/SetupLinkLines";
import generateInOrderTextProps from "./EditableHighlighter/Highlighter/GenerateInOrderTextProps";
import stripTags from "./EditableHighlighter/Util/StripTags";
import {MatchDestinationEnum} from "./EditableHighlighter/Highlighter/MatchDestinationEnum";

export function setupInsights(textJD, textR, searchWords) {
    const colorClassifications = convertInsightsToColorClassifications(searchWords)

    setupLinkLines(colorClassifications);

    let stringJD = "<div data-testid='highlighted-description'>" + generateInOrderTextProps(colorClassifications,
        stripTags(textJD), MatchDestinationEnum.JD).join('') + "</div>";
    let stringR = "<div data-testid='highlighted-resume'>" + generateInOrderTextProps(colorClassifications,
        stripTags(textR), MatchDestinationEnum.R).join('') + "</div>";
    return [stringJD === "" ? "_" : stringJD, stringR === "" ? "_" : stringR];
}