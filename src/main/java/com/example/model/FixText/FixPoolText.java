package com.example.model.FixText;

public class FixPoolText {
    public static String fixPoolText(String plainText) {
        plainText = plainText
                .toLowerCase()
                .replaceAll("\\s+", " ")
                .replace("\\u0027", "")
                .replace("\\u0026", "")
                .replace("\u00a0"," ")
                .replaceAll("[()!|&<>_.?/\\-\t]", " ")//replace with space
                .replaceAll("[^a-zA-Z0-9+#:{}\", ]", "")//replace everything else, gets rid of trash
                .replace(", ", ",")
                .stripLeading()
                .stripTrailing();
        while(plainText.contains("  ")){
            plainText = plainText.replace("  ", " ");
        }
        return plainText;
    }
    public static String fixPoolTextX(String plainText) {
        return plainText
                .toLowerCase()
                .replaceAll("\\s+", " ")
                .replaceAll("[^\\p{ASCII}]", "")
                .replace("-", " ")
                .replace("/", " ")
                .replace("\t", " ")
                .replace("(", " ")
                .replace(")", " ")
                .replace("!", " ")
                .replace("|", " ")
                .replace("&", " ")
                .replace(".", " ")
                .replace(", ", ",")
                .replace("?", "")
                .replace("\\u0027", "")
                .replace("\\u0026", "")
                .replace("  ", " ")
                .replace("  ", " ")
                .replace("  ", " ")
                .replace("  ", " ")
                .replace("  ", " ")
                .replace("  ", " ")
                .replace("  ", " ")
                .replace("  ", " ")
                .replace("  ", " ")
                .stripLeading()
                .stripTrailing();
    }
}
