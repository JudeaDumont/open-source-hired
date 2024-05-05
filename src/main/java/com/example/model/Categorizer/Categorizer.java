package com.example.model.Categorizer;

// cat ->
//    {
//    alikephrasestext:
//        dtAlikePhrases{
//            {phrase, density},
//            {phrase, density}
//        },
//     alikephrasestext:
//         dtAlikePhrases{
//             {phrase, density},
//             {phrase, density}
//         }
//     }

import com.example.model.Categorizer.Members.OccurrenceLogic;

public class Categorizer extends OccurrenceLogic {
    private Categorizer() {

    }

    public static Categorizer Create() {
        return new Categorizer();
    }
}
