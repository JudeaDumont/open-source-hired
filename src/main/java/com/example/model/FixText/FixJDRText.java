package com.example.model.FixText;

import static com.example.model.FixText.FixPoolText.fixPoolText;

public class FixJDRText {

    public static String fixJDRText(String plainText) {
        return fixPoolText(
                plainText.replace(",", " ") //take commas out of incoming plaintext
                        .replace("  ", " ")
                        .replace(":", " ")
                        .replace(";", " ")
        );
    }
}
