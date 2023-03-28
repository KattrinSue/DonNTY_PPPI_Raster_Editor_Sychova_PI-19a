import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import ProjectEditModule;
import MainGraphicsModule;
import DocumentModule;
import LayersModule;
import ImageEditModule;
import TextModule;

public class UserInterface {

  private JFrame mainFrame;
  private DrawingPanel drawingPanel;
  private DocumentModule documentModule;
  private EditModule editModule;
  private LayersModule layersModule;
  private TextModule textModule;
  private ImageEditModule imageEditModule;

  public Photoshop() {
    drawingPanel = new DrawingPanel();
    documentModule = new DocumentModule();
    editModule = new EditModule();
    layersModule = new LayersModule();
    textModule = new TextModule();
    imageEditModule = new ImageEditModule();
    createGUI();
  }

  private void createGUI() {
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setLayout(new BorderLayout());

    createMenuBar();

    JPanel contentPanel = new JPanel(new BorderLayout());

    JPanel toolsPanel = createToolsPanel();
    contentPanel.add(toolsPanel, BorderLayout.WEST);

    mainGraphicsModule = new MainGraphicsModule();
    contentPanel.add(mainGraphicsModule, BorderLayout.CENTER);

    mainFrame.add(contentPanel, BorderLayout.CENTER);

    mainFrame.setPreferredSize(new Dimension(1000, 700));
    mainFrame.pack();
    mainFrame.setVisible(true);
  }

  private JPanel createToolsPanel() {
    // реализовать панель инструментов
  }

  private void createMenuBar() {
    // реализовать панель меню
  }
}