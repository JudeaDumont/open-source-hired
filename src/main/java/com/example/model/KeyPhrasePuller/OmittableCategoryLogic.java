package com.example.model.KeyPhrasePuller;

import com.example.model.Categorizer.Categorizer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.example.model.KeyPhrasePuller.MapPhrasesFromPlainText.AddKeyPhrasesFromRawText;

public class OmittableCategoryLogic {
    public static final List<String> OmittableCategories = Arrays.asList(
            "tech", "cloud-tech", "db-tech", "adjacent-tech");

    //Operates on the keyphrases pulled from a job description
    public static Categorizer HijackVagueJobDescription(Categorizer categorizer) {
        boolean containsTech = false;
//        boolean containsCloudTech = false;
//        boolean containsDbTech = false;
//        boolean containsAdjacentTech = false;

        for (String s : categorizer.getCategorized().keySet()) {
            if (Objects.equals(s, "tech")) {
                containsTech = true;
                break;
            }
//            else if (Objects.equals(s, "cloud-tech")) {
//                containsCloudTech = true;
//            } else if (Objects.equals(s, "db-tech")) {
//                containsDbTech = true;
//            } else if (Objects.equals(s, "adjacent-tech")) {
//                containsAdjacentTech = true;
//            }
        }

        if (!containsTech) {
            AddKeyPhrasesFromRawText("java", categorizer);
            categorizer.hadVagueTech();
        }
//        if(!containsCloudTech){
//            AddKeyPhrasesFromRawText("cloud", categorizer);
//        }
//        if(!containsDbTech){
//            AddKeyPhrasesFromRawText("sql", categorizer);
//        }
//        if(!containsAdjacentTech){
//            AddKeyPhrasesFromRawText("react", categorizer);
//        }

        return categorizer;
    }
}
