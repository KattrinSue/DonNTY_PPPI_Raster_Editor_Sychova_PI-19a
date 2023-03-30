import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Модуль работы с документами
 * @author KattrinSue
 * @version 1.0.1
 */
public class DocumentModule {
    List<String> data;
    JFrame frame;
    String path;

    public DocumentModule(JFrame frame) {
        this.frame = frame;
    }

    public void openDocument(String filename) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "bmp", "jpg", "jpeg", "gif", "png");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            try {
                data = Files.readAllLines(Path.of(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public void createDocument() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "bmp", "jpg", "jpeg", "gif", "png");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showSaveDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            try {
                Files.createFile(Path.of(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public void saveDocument(String filename) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "bmp", "jpg", "jpeg", "gif", "png");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showSaveDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            try {
                Files.createFile(Path.of(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (String str : data) {
                try {
                    Files.writeString(Path.of(path), str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
