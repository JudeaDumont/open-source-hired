export function greenText(text, pos){
    return {
        children: text,                 //the text that got pulled from "chunk" string position
        className: 'green',  //highlightClassNames = `${highlightClass} ${isActive ? activeClassName : ''}` // just needs highlight class, active means nothing
        key: text+'-' + pos,                         //unique react element ID
        style: {}
    }
}