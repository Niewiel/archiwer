import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZip {
    private static String removeExtension(String filename) {
        return filename.substring(0,filename.lastIndexOf("."));
    }

    public static void main(String[] args) {
        String fileName = "ludzie.dat";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            try (FileOutputStream fos = new FileOutputStream(removeExtension(fileName) + ".zip"); ZipOutputStream zos = new ZipOutputStream(fos)) {
                ZipEntry ze = new ZipEntry(fileName);
                zos.putNextEntry(ze);
                int bufferSize=1024,c;
                byte[] buffer = new byte[bufferSize];
                while ((c=fis.read(buffer,0,bufferSize))>-1){
                    zos.write(buffer,0,c);
                }
                zos.closeEntry();
                System.out.println("udało się :)");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
