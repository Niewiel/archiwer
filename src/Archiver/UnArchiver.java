package Archiver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnArchiver {
    public static void main(String[] args) {
        int bufferSize = 1024, c;
        for (String fileName : args) {
            try (FileInputStream fis = new FileInputStream(fileName);
                 ZipInputStream zis = new ZipInputStream(fis)) {
                ZipEntry ze;
                while ((ze=zis.getNextEntry()) != null) {
                    try (FileOutputStream fos = new FileOutputStream("plik.dat")) {
                        byte buffer[] = new byte[bufferSize];
                        System.out.println("\nRozpakowuję: " + fileName);
                        while ((c = zis.read(buffer)) > -1) {
                            fos.write(buffer, 0, c);
                            System.out.println("rozpakowano: " + fileName);
                        }
                    }
                }
                System.out.println("skończone");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
