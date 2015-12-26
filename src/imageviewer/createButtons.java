package imageviewer;

import imageviewer.control.Command;
import imageviewer.model.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import jdk.nashorn.internal.objects.Global;

public class   createButtons {
    public static Map<String,Command>  commands = new HashMap<>();
    
    public static JButton nextButton() {
        JButton button = new JButton();
        button.setBackground(Color.white);
        button.setIcon(new ImageIcon("src/iconsButtons/next.png"));
        button.addActionListener(doCommand("next"));
        return button;
    }

    public static JButton prevButton() {
        JButton button = new JButton();
        button.setBackground(Color.white);
        button.setIcon(new ImageIcon("src/iconsButtons/prev.png"));
        button.addActionListener(doCommand("prev"));
        return button;
    }
    public static JButton rotateButton(){
        JButton button = new JButton();
        button.setBackground(Color.white);
        button.setIcon(new ImageIcon("src/iconsButtons/rotate.jpg"));
        button.addActionListener(doCommand("rotate"));
        
        return button;
    }
    public static JButton aumentZoomButton(){
        
        JButton button = new JButton();
        button.setBackground(Color.white);
        button.setIcon(new ImageIcon("src/iconsButtons/zoommas.png"));
        button.addActionListener(doCommand("aumentar"));
        return button;
    }
    public static JButton reduceZoomButton(){
        
        JButton button = new JButton();
        button.setBackground(Color.white);
        button.setIcon(new ImageIcon("src/iconsButtons/zoommenos.png"));
        button.addActionListener(doCommand("reducir"));
        return button;
    }
    
    public static ActionListener doCommand(final String operation) {
        return (ActionEvent e) -> {
            commands.get(operation).execute();
        };
    }
}
