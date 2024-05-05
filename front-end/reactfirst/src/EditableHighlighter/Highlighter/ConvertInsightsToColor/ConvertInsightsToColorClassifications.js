import {getNonMatched} from "./GetNonMatched";
import {getMatchedHighlight} from "./GetMatchedHighlight";

export function convertInsightsToColorClassifications(data) {
    let dataObject = JSON.parse(data);
    let colorClassifications = {}
    colorClassifications.red = getNonMatched(dataObject.combinedMissed.ht);
    colorClassifications.yellow = getNonMatched(dataObject.combinedSuperfluous.ht);
    colorClassifications.green = getMatchedHighlight(dataObject.combinedMatchedBecause);

    return colorClassifications;
}