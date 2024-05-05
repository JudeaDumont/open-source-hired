package z.util.BundleFIleWriter;

import com.example.model.ResumeBundle.Members.Persist.FileBundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteBundleFiles {
    public static String writeBundleFiles(InputStream plainTextStream,
                                          InputStream pdfStream,
                                          InputStream odtStream,
                                          FileBundle fileBundle,
                                          String bundlePath,
                                          String uuidString) throws IOException {

        byte[] plainTextBytes = plainTextStream.readAllBytes();
        String plainTextToMatch = new String(plainTextBytes, StandardCharsets.UTF_8);
        fileBundle.setPlainTextToMatch(plainTextToMatch);

        Files.createDirectories(Paths.get(bundlePath));
        File plainTextFile = new File(bundlePath + "txt.txt");

        FileOutputStream outPlainText = new FileOutputStream(
                plainTextFile);
        outPlainText.write(plainTextBytes);
        outPlainText.close();

        if (pdfStream != null) {
            byte[] pdfBytes = pdfStream.readAllBytes();
            FileOutputStream outpdf = new FileOutputStream(
                    bundlePath + "pdf.pdf");
            outpdf.write(pdfBytes);
            outpdf.close();
        }

        if (odtStream != null) {
            byte[] odtBytes = odtStream.readAllBytes();
            FileOutputStream outodt = new FileOutputStream(
                    bundlePath + "odt.odt");
            outodt.write(odtBytes);
            outodt.close();
        }
        return plainTextToMatch;
    }
}
