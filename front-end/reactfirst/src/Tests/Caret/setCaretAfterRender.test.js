import {SetCaretAfterRender} from "../../EditableHighlighter/Caret/SetCaretAfterRender";
import {setCaretAfterRender} from "../../EditableHighlighter/EditableHighlighter";

describe('stripTags', () => {

    it('SetCaretAfterRender', () => {
        const mockFunc = jest.fn()
        setCaretAfterRender.f = mockFunc
        SetCaretAfterRender();
        expect(mockFunc).toBeCalledTimes(1)
    })
});