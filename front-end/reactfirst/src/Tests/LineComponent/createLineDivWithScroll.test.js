import {
    createLineDiv
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/CreateLineDiv";

describe('createLineDiv', () => {

    it('createLineDiv', () => {
        window.scrollY = 1
        let result = createLineDiv("id1", 1, 2, 3, 4);
        expect(result.key).toEqual("id1-x0=1-y0=18-x1=3-y1=20")
    })

    it('createLineDiv2', () => {
        window.scrollY = 0
        let result = createLineDiv("id1", 1, 2, 3, 4);
        expect(result.key).toEqual("id1-x0=1-y0=17-x1=3-y1=19")
    })
})
