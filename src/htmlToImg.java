import java.io.PrintWriter;

public class htmlToImg {
    private htmlToImg() {}

    public static void bodyImage(PrintWriter pw, String image, String prev, String next) {
        pw.println("\t\t<title>" + image + "</title>");
        pw.println("\t</head>");
        pw.println("\t<body>");
        pw.println("\t\t<br />");
        pw.println("\t\t<a href=\"./index.html\">^^</a>");
        pw.println("\t\t<br />");
        pw.println("\t\t\t<a href=\"" + prev + "\"><<</a>");
        pw.println("\t\t<b> " + image + "</b>");
        pw.println("\t\t\t<a href=\"" + next + "\">>></a>");
        pw.println("\t\t<br />");
        if (!next.isEmpty()) {
            pw.println("\t\t<a href=\"" + next + "\">"); // img kattinthatósága
        } // effektelt img
        pw.println("\t\t\t<img src=\"" + image + "\" width=\"450\" style=\"border-radius: 4px;" +
                "box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0.2), 0 8px 222px 0 rgba(0, 0, 0, 0.2);\" />");
        if (!next.isEmpty()) {
            pw.println("\t\t</a>");
        }
        pw.println("\t</body>");
        pw.println("</html>");
    }
}
