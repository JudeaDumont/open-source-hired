package com.example.model.Categorizer.Members;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Set;

public class OccurrenceLogic extends DensityLogic {
    protected OccurrenceLogic() {
    }

    public Set<String> getOccurrences(String phrase, String category) {
        Set<String> occurrences = new HashSet<>();
        for (String s : getCategorized().keySet()) {
            Hashtable<String, PhraseCluster> stringPhraseClusterHashtable = getCategorized().get(s);
            for (String string : stringPhraseClusterHashtable.keySet()) {
                PhraseCluster phraseCluster = stringPhraseClusterHashtable.get(string);
                if (phraseCluster.containsKey(phrase) && Objects.equals(phraseCluster.getCategory(), category)) {
                    occurrences.addAll(phraseCluster.GetOccurred());
                }
            }
        }
        return occurrences;
    }

    public Set<String> getRelated(String phrase) {
        Set<String> occurrences = new HashSet<>();
        for (String s : getCategorized().keySet()) {
            Hashtable<String, PhraseCluster> stringPhraseClusterHashtable = getCategorized().get(s);
            for (String string : stringPhraseClusterHashtable.keySet()) {
                PhraseCluster phraseCluster = stringPhraseClusterHashtable.get(string);
                if (phraseCluster.containsKey(phrase)) {
                    occurrences.addAll(phraseCluster.GetRelated());
                }
            }
        }
        return occurrences;
    }
}
