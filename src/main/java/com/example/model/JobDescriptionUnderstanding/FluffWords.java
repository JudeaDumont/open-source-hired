package com.example.model.JobDescriptionUnderstanding;

import java.util.Arrays;
import java.util.List;

public class FluffWords {
    public static final List<String> dropWords = Arrays.asList(
            "", "a", "the", "so", "do", "key", "that", "than",
            "such", "great", "you", "we", "billion", "everyone",
            "it", "is", "which", "we’re",
            "today", "person", "making", "will",
            "one", "may",
            "nothing", "arizona", "this", "looking", "can", "lieu", "$20", "over",
            "california", "while", "after",
            "hiring", "opportunity", ""
            , "include", "all", "there’s"
            , "more", "simple", "is" , "i", "about",
            "locations", "join", "what", "they", "our",
            "written", "colorado", "typically", "for"
            , "job", "be",
            "these", "itself", "apply", "at", "as", "its", "7", "sure", "an",
            "good”", "strong", "110",
            "in", "s", "and", "to", "of", "$20", "ing", "on", "ation", "by", "first", "with", "er"
            , "good", "without", "theres", "from", "changes", "existing", "ers", "ment", "or", "other", "nstrated"
            //if a word is partially matched, and an "ing" or "ers" is left over, just drop it and count the match.
    );
}
