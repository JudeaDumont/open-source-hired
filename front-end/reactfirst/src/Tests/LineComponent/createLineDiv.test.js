import {
    createLineDiv
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CreateLineDiv";

describe('createLineDiv', () => {

    it('createLineDiv', () => {
        let result = createLineDiv("id1", 1, 2, 3, 4);
        expect(result.key).toEqual("id1-x0=1-y0=17-x1=3-y1=19")
    })
})
