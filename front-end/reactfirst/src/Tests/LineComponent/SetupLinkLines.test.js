import {setupLinkLines} from "../../EditableHighlighter/Components/LineComponent/SetupLinkLines";
import {linkLines} from "../../EditableHighlighter/Components/LineComponent/LineComponent";

describe('setupLinkLines', () => {

    it('setupLinkLines', () => {
        let colorClassifications = {
            green: ["matchA --- matchB"]
        }
        setupLinkLines(colorClassifications);
        expect(linkLines.l[0]).toEqual({"from":"line-matcha", "to":"line-matchb"});
    })
})
