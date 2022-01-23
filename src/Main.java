import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void copyFolder (String sourceLocation , String destinationLocation)
        throws IOException {
        Files.walk(Paths.get(sourceLocation))
                .forEach(source->{Path destination = Paths.get(destinationLocation , source.toString()
                .substring(sourceLocation.length()));

        try {
            Files.copy(source,destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
                });

    }

    public static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        if (files == null || files.length == 0){
            return length;
        }
        for (File file : files) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += getFolderSize(file);
            }
        }
        return length;
    }

    public static void main(String[] args) {


        for (;;)
        {

            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();

            System.out.println(getFolderSize( new File(path)) + " Byte ");


        }

    }
}
