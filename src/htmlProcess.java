import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class htmlProcess
{
    private static String title;
    private static PrintWriter pw;

    public htmlProcess(String title) {
        htmlProcess.title = title;
    }

    public static String imgToHtml(String image)
    {
        StringBuilder sb = new StringBuilder(image);
        sb.replace(image.lastIndexOf('.') + 1, image.length(), "html");

        return sb.toString();
    }

    public static void compileIndex(String path, List<String> files, List<String> images, int depth)
    {
        try {
            pw = new PrintWriter(path + "/" + "index.html", StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Hiba! Kivétel történt!");
            pw.close();
        }
        buildBase(depth);
        htmlToIndex.buildIndex(pw, files, images, depth, title);
        // System.out.println(path);
        pw.close();
    }

    public static void compileImg(String path, String image, String prev, String next, int depth)
    {
        try {
            pw = new PrintWriter(path, StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Hiba! Kivétel történt!");
            pw.close();
        }
        buildBase(depth);
        htmlToImg.buildImg(pw, image, prev, next);
        // System.out.println(image);
        pw.close();
    }

    public static void buildBase(int depth)
    {
        pw.println("<!DOCTYPE html>");
        pw.println("<html style=\"font-family: 'Courier New', monospace;\">");
        pw.println("\t<head>");
        pw.println("\t\t<a href=\"" + "../".repeat(depth) + "index.html\">"); // visszalépés repeatelése
        pw.println("\t\t\t<h1>Start page</h1>");
        pw.println("\t\t</a>");
        pw.println("\t\t<hr style=\"border: 1px; margin: 1px; border-style: solid;\">");
        // System.out.println(path);
    }
}
