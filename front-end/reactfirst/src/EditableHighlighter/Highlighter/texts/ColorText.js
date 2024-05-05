export function colorText(text, color, pos){
    return {
        children: text,                 //the text that got pulled from "chunk" string position
        className: color,  //highlightClassNames = `${highlightClass} ${isActive ? activeClassName : ''}` // just needs highlight class, active means nothing
        key: text + '-' + pos,                     //unique react element ID
        style: {}
    }
}