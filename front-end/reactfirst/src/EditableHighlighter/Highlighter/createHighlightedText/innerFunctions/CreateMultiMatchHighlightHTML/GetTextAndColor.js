//"text=color" //"java=green"
export function getTextAndColor(textAndColor) {
    let split = textAndColor.split("=");
    let text = split[0];
    let color = split[1];
    return {text, color};
}