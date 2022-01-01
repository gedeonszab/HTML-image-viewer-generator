import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Website generator
 */

public class Main
{
    public static int folderCount = 0;
    public static int filesCount = 0;

    public static void main(File file)
    {
        Scanner in = new Scanner(System.in);
        File home = new File(String.valueOf(in));

        System.out.println("Your HTML image browser!");
        System.out.print("Give a title: ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        new htmlProcess(title);

        int depth = 0;
        folderSearch(home, depth); // Bejárás
        System.out.printf("Directories found: %s\n", folderCount);
        System.out.printf("Images found: %s\n", filesCount);
        System.out.printf("HTML files created: %s\n", folderCount + filesCount);
        System.out.println("\nDONE!");
    }

    public static void folderSearch(File base, int depth)
    {
        List<String> extensions = List.of("jpg", "JPG", "png", "webp", "jpeg", "gif", "bmp", "svg");
        List<String> folder = new ArrayList<>();
        List<String> files = new ArrayList<>();

        for (File file : base.listFiles())
        {
            if (file.isDirectory())
            {
                folder.add(file.getName());
                ++folderCount;
                folderSearch(file, depth + 1); // rekurzív bejárás
            }

            else if (isOk(extensions, file)) {
                files.add(file.getName());
                ++filesCount;
            }
        }

        // rendezés abc sorrendbe
        Collections.sort(folder);
        Collections.sort(files);

        // index készítés
        htmlProcess.compileIndex(base.getPath(), folder, files, depth);

        for (int i = 0; i < files.size(); ++i)
        {
            String prev;
            if (i == 0) {
                prev = "";
            }
            else {
                prev = htmlProcess.imgToHtml(files.get(i - 1));
            }
            String next;
            if (i == files.size() - 1) {
                next = "";
            }
            else {
                next = htmlProcess.imgToHtml(files.get(i + 1));
            }
            // img készítés
            htmlProcess.compileImg(htmlProcess.imgToHtml(base.getPath() + "/" + files.get(i)), files.get(i), prev, next, depth);
        }
    }

    public static boolean isOk(List<String> extensions, File file) {
        return extensions.contains(file.getName().split("\\.")[file.getName().split("\\.").length - 1]);
    }
}