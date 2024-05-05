package com.example.model.JobDescriptionUnderstanding;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.regex.Pattern;

import static com.example.model.JobDescriptionUnderstanding.FluffWords.dropWords;
import static z.util.StringProcessing.SplitWithNoEmpties.splitNoEmpties;

public class UnderstandingLogic extends Json {
    protected void getUnderstanding(Hashtable<String, PhraseCluster> clusters,
                                    String jobDescriptionPlainText) {
        Set<String> phrases = new HashSet<>();
        for (PhraseCluster hugeListOfRecognizedKeyword : clusters.values()) {
            phrases.addAll(hugeListOfRecognizedKeyword.keySet());
        }
        removeAllKnownPhrasesAndCount(phrases, jobDescriptionPlainText);
    }

    private JobDescriptionUnderstanding removeAllKnownPhrasesAndCount(Set<String> phrases, String jobDescriptionPlainText) {
        for (String phrase : phrases) {
            jobDescriptionPlainText = removeAndCountPhrase(jobDescriptionPlainText, phrase);
        }
        return dropFluffWordsAndGetMissing(jobDescriptionPlainText);
    }

    private JobDescriptionUnderstanding dropFluffWordsAndGetMissing(String jobDescriptionPlainText) {
        for (String dropWord : dropWords) {
            jobDescriptionPlainText = jobDescriptionPlainText.replaceAll("\\b" + dropWord + "\\b", "");
        }
        return createJobDescriptionUnderstandingFromStats(jobDescriptionPlainText);
    }

    private JobDescriptionUnderstanding createJobDescriptionUnderstandingFromStats(String remaining) {
        this.setRemainingAndCalcMatchPercentage(splitNoEmpties(remaining));
        return (JobDescriptionUnderstanding) this;
    }

    private String removeAndCountPhrase(String jobDescriptionPlainText, String phrase) {
        if (jobDescriptionPlainText.contains(phrase)) {
            jobDescriptionPlainText = jobDescriptionPlainText.replaceFirst(Pattern.quote(phrase), "");
            String[] strings = splitNoEmpties(phrase.trim());
            int length = strings.length;
            matchs += length;
            jobDescriptionPlainText = removeAndCountPhrase(jobDescriptionPlainText, phrase);
        }
        return jobDescriptionPlainText;
    }
}
