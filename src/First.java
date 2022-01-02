import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Website generator
 */

public class First {
    public static int folderCount = 0;
    public static int filesCount = 0;

    public static void first(File file) {
        int depth = 0;
        folderSearch(file, depth);
    }

    public static void folderSearch(File base, int depth) {
        List<String> extensions = List.of("jpg", "JPG", "png", "webp", "jpeg", "gif", "bmp", "svg");
        List<String> folder = new ArrayList<>();
        List<String> files = new ArrayList<>();

        for (File file : base.listFiles())
        {
            if (file.isDirectory())
            {
                folder.add(file.getName());
                ++folderCount;
                folderSearch(file, depth + 1); // recursive dir lookup
            }

            else if (isOk(extensions, file)) {
                files.add(file.getName());
                ++filesCount;
            }
        }

        // Sorting folders
        Collections.sort(folder);
        Collections.sort(files);

        // Creating index.html
        htmlProcess.createIndex(base.getPath(), folder, files, depth);

        for (int i = 0; i < files.size(); ++i)
        {
            String prev;
            if (i == 0) { prev = ""; }
            else { prev = htmlProcess.imgToHtml(files.get(i - 1)); }
            String next;
            if (i == files.size() - 1) {
                next = "";
            }
            else {
                next = htmlProcess.imgToHtml(files.get(i + 1));
            }
            // Creating image.html
            htmlProcess.createImage(htmlProcess.imgToHtml(base.getPath() + "/" + files.get(i)), files.get(i), prev, next, depth);
        }
    }

    public static boolean isOk(List<String> extensions, File file) {
        return extensions.contains(file.getName().split("\\.")[file.getName().split("\\.").length - 1]);
    }
}