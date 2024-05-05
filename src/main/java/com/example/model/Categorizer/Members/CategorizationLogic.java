package com.example.model.Categorizer.Members;

import com.example.model.PhraseCluster.Members.ConstructionMethods;
import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;

public class CategorizationLogic extends Members {
    protected CategorizationLogic() {
    }

    public void categorize(String phraseOccurrence, PhraseCluster phraseCluster) {
        String category = phraseCluster.getCategory();
        String phraseClusterName = phraseCluster.getPhraseClusterName();

        categorizeFixed(phraseOccurrence, phraseCluster, category, phraseClusterName);
    }

    //can tap into categories here, change the way phrase clusters are organized
    private void categorizeFixed(
            String phraseOccurrence,
            PhraseCluster phraseCluster,
            String category,
            String phraseClusterName) {
        Hashtable<String, Hashtable<String, PhraseCluster>> categorized = getCategorized();
        if (categorized.containsKey(category) && categorized.get(category).containsKey(phraseClusterName)) {
            categorizeIntoExistingCategoryExistingCluster(phraseOccurrence, category, phraseClusterName);
        } else if (!categorized.containsKey(category)) {
            categorizeIntoNewCategory(phraseOccurrence, phraseCluster, category, phraseClusterName);
        } else if (categorized.containsKey(category) && !categorized.get(category).containsKey(phraseClusterName)) {
            categorizeIntoExistingCategoryNewCluster(phraseOccurrence, phraseCluster, category, phraseClusterName);
        } else {
            throw new RuntimeException("Should not be possible");
        }
    }

    private void categorizeIntoExistingCategoryNewCluster(
            String phraseOccurrence,
            PhraseCluster phraseCluster,
            String category,
            String phraseClusterName) {
        PhraseCluster phrases = ConstructionMethods.createAlikePhrasesWithOccurrence(phraseOccurrence, phraseCluster);
        getCategorized().get(category).put(phraseClusterName, phrases);
    }

    private void categorizeIntoNewCategory(
            String phraseOccurrence,
            PhraseCluster phraseCluster,
            String category,
            String phraseClusterName) {
        Hashtable<String, PhraseCluster> techWords = new Hashtable<>();
        PhraseCluster phrases = ConstructionMethods.createAlikePhrasesWithOccurrence(phraseOccurrence, phraseCluster);
        techWords.put(phraseClusterName, phrases);
        getCategorized().put(category, techWords);
    }

    private void categorizeIntoExistingCategoryExistingCluster(String phraseOccurrence,
                                                               String category,
                                                               String phraseClusterName) {
        getCategorized().get(category).get(phraseClusterName).Add(phraseOccurrence, 1L);
    }
}
