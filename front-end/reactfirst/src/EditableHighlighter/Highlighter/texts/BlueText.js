export function blueText(text, pos) {
    return {
        children: text,                 //the text that got pulled from "chunk" string position
        className: 'blue',  //highlightClassNames = `${highlightClass} ${isActive ? activeClassName : ''}` // just needs highlight class, active means nothing
        key: text + '-' + pos,                    //unique react element ID
        style: {}
    }
}