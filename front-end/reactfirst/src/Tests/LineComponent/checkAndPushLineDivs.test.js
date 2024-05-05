import {
    checkAndPushLineDivs
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CheckAndPushLineDivs";

describe('checkAndPushLineDivs', () => {

    it('checkAndPushLineDivs', () => {
        let elementContainer = [];
        checkAndPushLineDivs(elementContainer, "id1", 1, 2, 3, 4);
        expect(elementContainer[0].key).toEqual("id1-x0=1-y0=17-x1=3-y1=19")
    })
})
