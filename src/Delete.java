import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Delete {
    public static void del(File base, int depth) {
        List<String> extensions = List.of("html");
        List<String> folder = new ArrayList<>();

        for (File file : base.listFiles()) {
            if (file.isDirectory()) {
                folder.add(file.getName());
                del(file, depth + 1);
            }

            else if (isOk(extensions, file)) {
                file.delete();
            }
        }
    }

    public static boolean isOk(List<String> extensions, File file) {
        return extensions.contains(file.getName().split("\\.")[file.getName().split("\\.").length - 1]);
    }
}
