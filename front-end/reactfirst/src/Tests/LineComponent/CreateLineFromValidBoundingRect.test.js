import {
    CreateLineFromValidBoundingRect
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CreateLineFromValidBoundingRect";
import {
    checkAndPushLineDivs
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CheckAndPushLineDivs";

describe('CreateLineFromValidBoundingRect', () => {

    it('CreateLineFromValidBoundingRect', () => {
        let linkLineElementsC = [];
        window.checkAndPushLineDivsG = checkAndPushLineDivs;
        CreateLineFromValidBoundingRect(linkLineElementsC, "id1", {x: 1, y: 2}, {x: 3, y: 4});

        //proves that the bounding rect box works for creating lines, but does not prove it works correctly.
        expect(linkLineElementsC[0].key).toEqual("id1-x0=1-y0=17-x1=3-y1=19")
    })
})
