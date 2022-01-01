import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Generator {
    private JButton btnStart;
    private JPanel panelMain;
    private JTextField tfHely;
    private JButton btnOpen;

    public Generator() {
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello");
            }
        });
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    tfHely.setText("Folder: " + file.getName());
                    Main.main(file);
                } else {
                    tfHely.setText("No folder selected!");
                }
            }
        });
    }

    public static void main(String[] args) {
        createWindow();
    }

    public static void createWindow() {
        JFrame frame = new JFrame("Generator");
        frame.setContentPane(new Generator().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private static void createUI(JFrame frame) {

    }
}
