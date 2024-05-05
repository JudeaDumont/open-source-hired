package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.Json;

import com.example.model.FixText.FixPoolText;
import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Members;

import java.util.ArrayList;

import static z.util.FileIO.FilesFromResourceDirectory.getFiles;
import static z.util.FileIO.ReadResourceAsString.getString;

public class LoadJson extends LoadJsonText {
    protected LoadJson() {
    }

    private static void loadJsonFiles(ArrayList<String> filesFromResourceDirectory) {
        for (String fileName : filesFromResourceDirectory) {
            loadJsonFile(fileName);
            Members.loadedFiles.add(fileName);
        }
    }

    protected static void loadJsonPoolFiles() {
        loadJsonFiles(getFiles("json-pool"));
    }

    private static void loadJsonFile(String fileName) {
        loadJsonSingleDoubleTripleLayer(
                FixPoolText.fixPoolText(
                        getString(fileName)
                )
        );
    }
}
