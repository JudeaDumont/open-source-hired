export function createMatchTextBlockDiv(color, text) {
    return "<div " +
        "onmouseleave=\"window.setLinkElements([])\" " +
        "onmouseenter=\"window.handleHoverG(this.textContent)\" " +
        "class='text-block " + color + "'>" + text + "</div>";
}