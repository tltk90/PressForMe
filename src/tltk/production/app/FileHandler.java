package tltk.production.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *
 * @author Tzahi Levi
 */
public class FileHandler {

    private static final String DIR_NAME = ".PressForMe";
    private static final String FILE_NAME = "combinations.prm";

    public static File getFile() {
        File dir = new File(System.getProperty("user.home"), DIR_NAME);
        if (!dir.exists()) {
//            try {
//                Files.createDirectory(Paths.get(dir.getAbsolutePath()));
//            } catch (IOException ex) {
//                System.err.println(ex.getMessage());
//                return null;
//            }
            dir.mkdir();
            makeDirHidden(dir);

        }

        File file = new File(dir, FILE_NAME);
        return file;
    }

    private static void makeDirHidden(File dir) {
        if (System.getProperty("os.name").startsWith("Win")) {

            try {
                Files.setAttribute(Paths.get(dir.getAbsolutePath()), "dos:hidden", true);
            } catch (IOException ex) {
                try {
                    Process process = Runtime.getRuntime().exec("attrib +s +h " + dir.getAbsolutePath());
                    process.waitFor();
                } catch (IOException | InterruptedException ex1) {
                }

            }

        }
    }
}
