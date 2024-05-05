import {
    createLinesForElements
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CreateLinesForElements";
import {
    checkAndPushLineDivs
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CheckAndPushLineDivs";

describe('createLinesForElements', () => {

    it('createLinesForElements', () => {
        let linkLineElementsC = [];
        let elementFrom = {
            getBoundingClientRect: () => {
                return {x: 1, y: 2}
            }
        };
        let elementTo = {
            getBoundingClientRect: () => {
                return {x: 3, y: 4}
            }
        };

        window.checkAndPushLineDivsG = checkAndPushLineDivs;
        createLinesForElements([elementFrom], [elementTo], linkLineElementsC);

        //proves that the bounding rect box works for creating lines, but does not prove it works correctly.
        expect(linkLineElementsC[0].key).toContain("-x0=1-y0=17-x1=3-y1=19")
    })
})
