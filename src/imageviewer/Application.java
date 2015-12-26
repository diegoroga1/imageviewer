
package imageviewer;
import imageviewer.control.AumentarImageCommand;
import imageviewer.control.NextImageCommand;
import imageviewer.control.PrevImageCommand;
import imageviewer.control.ReduceImageCommand;
import imageviewer.control.RotateImageCommand;
import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends JFrame{
    private ImageDisplay imageDisplay;
    public Application() {
        this.deployUI();
        this.createCommands();
    }
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    private void deployUI() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(700,700));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel(),BorderLayout.CENTER);
        this.getContentPane().add(toolbar(),BorderLayout.NORTH);
        this.pack();
    }
    
    private void createCommands() {
        createButtons.commands.put("next", new NextImageCommand(imageDisplay));
        createButtons.commands.put("prev", new PrevImageCommand(imageDisplay));
        createButtons.commands.put("rotate",new RotateImageCommand(imageDisplay));
        createButtons.commands.put("aumentar", new AumentarImageCommand(imageDisplay));
        createButtons.commands.put("reducir",new ReduceImageCommand(imageDisplay));
    }

    public ImagePanel imagePanel() {
        ImagePanel imagePanel = new ImagePanel(image());
        imageDisplay = imagePanel;
        return imagePanel;
    }

    private Image image() {
        return new FileImageReader("C:\\Users\\Pictures").read();
    }

    private  Component toolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(createButtons.prevButton());
        panel.add(createButtons.nextButton());
        panel.add(createButtons.rotateButton());
        panel.add(createButtons.aumentZoomButton());
        panel.add(createButtons.reduceZoomButton());
        return panel;
    }
}
