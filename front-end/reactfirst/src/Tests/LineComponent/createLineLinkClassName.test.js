import {
    createLineLinkClassName
} from "../../EditableHighlighter/Components/LineComponent/CreateLines/CreateLineDivs/CreateLineLinkClassName";

describe('createLineLinkClassName', () => {

    it('createLineLinkClassName', () => {
        let result = createLineLinkClassName("A A");

        expect(result).toEqual("line-a-a")
    })
})
