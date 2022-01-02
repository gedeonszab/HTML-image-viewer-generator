import java.io.PrintWriter;
import java.util.List;

public class htmlToIndex {
    private htmlToIndex() {}

    public static void bodyIndex(PrintWriter pw, List<String> files, List<String> images, int depth, String title) {
        pw.println("\t\t<title>" + title + "</title>");
        pw.println("\t</head>");
        pw.println("\t<body>");
        pw.println("\t\t<h2>Directories:</h2>");
        pw.println("\t\t\t<ul>");
        // visszalépés, ha nem a főoldalon vagyunk
        if (depth != 0) {
            pw.println("\t\t\t\t<li><a href=\"../index.html\"><<</a></li>");
        }
        // directory-k listázása indexbe
        for (String file : files) {
            pw.println("\t\t\t\t<li><a href=\"" + file + "/index.html" + "\">" + file + "</a></li>");
        }
        pw.println("\t\t\t</ul>");
        pw.println("\t\t\t<hr style=\"border: 1px; margin: 1px; border-style: solid;\">");

        // img listázása indexbe
        if (images.size() > 0)
        {
            pw.println("\t\t<h2>Images:</h2>");
            pw.println("\t\t\t<ul style=\"list-style-type: circle;\">");
            for (String img : images) {
                pw.println("\t\t\t\t<li><a href=\"" + htmlProcess.imgToHtml(img) + "\">" + img + "</a></li>");
            }
            pw.println("\t\t\t</ul>");
        } // else empty
        pw.println("\t</body>");
        pw.println("</html>");
    }
}
