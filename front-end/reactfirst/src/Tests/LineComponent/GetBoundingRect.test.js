import {
    getBoundingRect
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/InnerFunctions/GetBoundingRect";

describe('getBoundingRect', () => {

    it('getBoundingRect', () => {
        let result = getBoundingRect({x:1, y:2}, {x:3, y:4});
        expect(result).toEqual({x0:1, y0:2, x1:3, y1:4})
    })
})
