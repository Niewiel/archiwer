import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUnZip {
    @NotNull
    private static String removeExtension(String filename) {
        return filename.substring(0, filename.lastIndexOf("."));
    }

    public static void main(String[] args) {

        String fileName = "archiwum.zip";
        try (FileInputStream fis = new FileInputStream(fileName);
             ZipInputStream zis = new ZipInputStream(fis)) {
            try (FileOutputStream fos = new FileOutputStream(removeExtension(fileName) + "1.dat")) {
                ZipEntry ze = zis.getNextEntry();
                int bufferSize = 1024, c;
                byte buffer[] = new byte[bufferSize];
                while ((c = zis.read(buffer, 0, bufferSize)) > -1) {
                    fos.write(buffer, 0, c);
                }
            }
            System.out.println("rozpakowano: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
