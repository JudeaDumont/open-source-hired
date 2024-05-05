import stripTags from "../../../EditableHighlighter/Util/StripTags";

export default function browserCacheSetCurrentDescriptionContent(description){
    localStorage['currentDescriptionContent'] = stripTags(description);
}