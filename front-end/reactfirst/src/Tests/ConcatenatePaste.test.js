import {concatenatePaste} from "../EditableHighlighter/Util/ConcatenatePaste";

describe('concatenatePaste', () => {

    it('concatenatePaste', () => {
        let result = concatenatePaste("a b a", "c", 2, 3);
        expect(result).toEqual("a c a");
    })
})
