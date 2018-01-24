package Archiver;

        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.util.zip.ZipEntry;
        import java.util.zip.ZipOutputStream;

public class Archiver {
    public static void main(String[] args) {
        for (String x : args) {
            System.out.println(x);
        }

        String outputFile = "archiwum.zip";

        try (FileOutputStream fos = new FileOutputStream(outputFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            for (String fileName : args) {
                try (FileInputStream fis = new FileInputStream(fileName)) {
                    ZipEntry ze = new ZipEntry(fileName);
                    zos.putNextEntry(ze);
                    int bufferSize = 1024, c;
                    byte[] buffer = new byte[bufferSize];
                    while ((c = fis.read(buffer, 0, bufferSize)) > -1) {
                        zos.write(buffer, 0, c);
                    }
                }
            }
            zos.closeEntry();
            System.out.println("\nudało się :)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
