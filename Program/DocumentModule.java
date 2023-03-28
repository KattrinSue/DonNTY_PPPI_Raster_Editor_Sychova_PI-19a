import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

// А) модуль работы с документами
public class DocumentModule {
    List<String> data;
    JFrame frame;
    String path;

    public DocumentModule(JFrame frame) {
        this.frame = frame;
    }
    
    public void openDocument(String filename) {
        // Реализовать открытие документа
    }
    
    public void createDocument(String filename) {
        // Реализовать создание документа
    }
    
    public void saveDocument(String filename) {
        // Реализовать сохранение документа
    }
}
