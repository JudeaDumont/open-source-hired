import stripTags from "../../../EditableHighlighter/Util/StripTags";

export default function browserCacheSetCurrentResumeContent(resume){
    localStorage['currentResumeContent'] = stripTags(resume);
}