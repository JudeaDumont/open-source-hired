import stripTags from "../EditableHighlighter/Util/StripTags";
describe('stripTags', () => {

    it('stripTags', () => {
        let stripTags1 = stripTags("<div>tests</div>");
        expect(stripTags1).toEqual("tests");
    })


    it('stripTags empty', () => {
        let stripTags1 = stripTags("<div></div>");
        expect(stripTags1).toEqual("");
    })


    it('stripTags keep br', () => {
        let stripTags1 = stripTags("<div><br></div>");
        expect(stripTags1).toEqual("");
    })

    it('weird nesting', () => {
        let stripTags1 = stripTags("<div class=\"blue\">The</div>" +
            "<div class=\"white\"> </div>" +
            "<div class=\"green\">dog</div>" +
            "<div class=\"white\"> is chasing </div>" +
            "<div class=\"blue\">the</div>" +
            "<div class=\"white\"> cat. </div>" +
            "<div class=\"red\">Or</div>" +
            "<div class=\"white\"> perhaps they're just playing?</div>" +
            "");
        expect(stripTags1).toEqual("The dog is chasing the cat. Or perhaps they're just playing?");
    })

})
