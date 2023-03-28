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
  private MainGraphicsModule mainGraphicsModule;
  private DocumentModule documentModule;
  private ProjectEditModule projectEditModule;
  private LayersModule layersModule;
  private TextModule textModule;
  private ImageEditModule imageEditModule;

  public UserInterface() {
    mainFrame = new JFrame("Photoshop Clone");
    mainGraphicsModule = new MainGraphicsModule();
    documentModule = new DocumentModule(mainFrame);
    projectEditModule = new ProjectEditModule();
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
    JPanel toolsPanel = new JPanel();
    toolsPanel.setLayout(new BoxLayout(toolsPanel, BoxLayout.Y_AXIS));
    toolsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JButton newButton = new JButton("New");
    newButton.addActionListener(e -> documentModule.createDocument());

    JButton openButton = new JButton("Open");
    openButton.addActionListener(e -> documentModule.openDocument(selectedFile.getAbsolutePath()));

    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(e -> documentModule.saveDocument(selectedFile.getAbsolutePath()));

    JToggleButton selectButton = new JToggleButton(new ImageIcon(getClass().getResource("select.png")));
    selectButton.addActionListener(e -> mainGraphicsModule.setShapeSelection());

    JToggleButton drawButton = new JToggleButton(new ImageIcon(getClass().getResource("pencil.png")));
    drawButton.addActionListener(e -> mainGraphicsModule.setPencilDrawing());

    JToggleButton eraseButton = new JToggleButton(new ImageIcon(getClass().getResource("eraser.png")));
    eraseButton.addActionListener(e -> mainGraphicsModule.setErasing());

    JToggleButton fillButton = new JToggleButton(new ImageIcon(getClass().getResource("fill.png")));
    fillButton.addActionListener(e -> mainGraphicsModule.setFillDrawing());

    JToggleButton shapeButton = new JToggleButton(new ImageIcon(getClass().getResource("shape.png")));
    shapeButton.addActionListener(e -> {
      Object[] options = {"Rectangle", "Ellipse", "Triangle"};
      int value = JOptionPane.showOptionDialog(mainFrame, "Select Shape to Draw", "Shape Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      if (value == 0) {
        mainGraphicsModule.setShapeDrawing(MainGraphicsModule.ShapeType.RECTANGLE);
      } else if (value == 1) {
        mainGraphicsModule.setShapeDrawing(MainGraphicsModule.ShapeType.ELLIPSE);
      } else if (value == 2) {
        mainGraphicsModule.setShapeDrawing(MainGraphicsModule.ShapeType.TRIANGLE);
      }
    });

    JToggleButton textButton = new JToggleButton(new ImageIcon(getClass().getResource("text.png")));
    textButton.addActionListener(e -> {
      String text = JOptionPane.showInputDialog(mainFrame, "Enter Text to Draw");
      if (text != null) {
        mainGraphicsModule.setTextDrawing(text);
      }
    });

    JToggleButton selectColorButton = new JToggleButton(new ImageIcon(getClass().getResource("color-picker.png")));
    selectColorButton.addActionListener(e -> {
      Color color = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
      mainGraphicsModule.setDrawingColor(color);
    });

    toolsPanel.add(newButton);
    toolsPanel.add(openButton);
    toolsPanel.add(saveButton);
    toolsPanel.add(Box.createVerticalStrut(10));
    toolsPanel.add(selectButton);
    toolsPanel.add(drawButton);
    toolsPanel.add(eraseButton);
    toolsPanel.add(fillButton);
    toolsPanel.add(shapeButton);
    toolsPanel.add(textButton);
    toolsPanel.add(Box.createVerticalStrut(10));
    toolsPanel.add(selectColorButton);

    return toolsPanel;
  }

  private void createMenuBar() {
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");

    JMenuItem newMenuItem = new JMenuItem("New");
    newMenuItem.addActionListener(e -> documentModule.createDocument());

    JMenuItem openMenuItem = new JMenuItem("Open");
    openMenuItem.addActionListener(e -> documentModule.openDocument(selectedFile.getAbsolutePath()));

    JMenuItem saveMenuItem = new JMenuItem("Save");
    saveMenuItem.addActionListener(e -> documentModule.saveDocument(selectedFile.getAbsolutePath()));

    fileMenu.add(newMenuItem);
    fileMenu.add(openMenuItem);
    fileMenu.add(saveMenuItem);

    JMenu editMenu = new JMenu("Edit");

    JMenuItem undoMenuItem = new JMenuItem("Undo");
    undoMenuItem.addActionListener(e -> projectEditModule.undo());

    JMenuItem redoMenuItem = new JMenuItem("Redo");
    redoMenuItem.addActionListener(e -> projectEditModule.redo());

    editMenu.add(undoMenuItem);
    editMenu.add(redoMenuItem);

    JMenu layerMenu = new JMenu("Layers");

    JMenuItem newLayerMenuItem = new JMenuItem("New Layer");
    newLayerMenuItem.addActionListener(e -> layersModule.createLayer());

    JMenuItem duplicateLayerMenuItem = new JMenuItem("Duplicate Layer");
    duplicateLayerMenuItem.addActionListener(e -> layersModule.duplicateLayer());

    JMenuItem deleteLayerMenuItem = new JMenuItem("Delete Layer");
    deleteLayerMenuItem.addActionListener(e -> layersModule.deleteLayer());

    layerMenu.add(newLayerMenuItem);
    layerMenu.add(duplicateLayerMenuItem);
    layerMenu.add(deleteLayerMenuItem);

    JMenu textMenu = new JMenu("Text");

    JMenuItem openSymbolsPanelMenuItem = new JMenuItem("Open Symbols Panel");
    openSymbolsPanelMenuItem.addActionListener(e -> textModule.openSymbolsPanel());

    textMenu.add(openSymbolsPanelMenuItem);

    JMenu imageMenu = new JMenu("Image");
  }
}