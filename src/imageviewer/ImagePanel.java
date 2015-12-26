
package imageviewer;
import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class  ImagePanel extends JPanel implements ImageDisplay{

    private Image image;
    private double rotation;
    private final float z;
    private float escalaX;
    private float escalaY;
    private int newX;
    private int newY;
    private float tamañoX;
    private float tamañoY;
    BufferedImage imagen;
    BufferedImage fondo;
    public ImagePanel(Image image) {
        this.image = image; 
        this.rotation=0;
        this.z=0;
        
    }
  
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        imagen = (BufferedImage) image.bitMap();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(rotation), this.getWidth()/2, this.getHeight()/2);
        ((Graphics2D)g).setTransform(tx);
        newX=(int) (imagen.getWidth()+escalaX);
        newY=(int) (imagen.getHeight()+escalaY);
        tamañoX=this.getWidth()+escalaX;
        tamañoY=this.getHeight()+escalaY;
        
        if(imagen.getWidth()<= this.getWidth() && imagen.getHeight()<=this.getHeight()){
            g2d.translate(this.getWidth()/ 2, this.getHeight()/ 2);
            g2d.translate(-newX / 2, -newY/ 2);
            g2d.drawImage(imagen,0,0,(int)newX,(int)newY,this);
        }else{
            g2d.translate(this.getWidth()/ 2, this.getHeight()/ 2);
            g2d.translate(-tamañoX/2, -tamañoY /2);
            g2d.drawImage(imagen,0,0,(int)tamañoX,(int)tamañoY,this);
        }
        setOpaque(false);
        System.out.println("Image size: "+newX+"x"+newY);
        
    }
    
    public float getZoom() {
        return z;
    }

    public float setZoom(float z) {
        if(z==1||z==0){
            escalaX=0;
            escalaY=0;
        }
        escalaX+=z;
        escalaY+=z;
        return z;
    }
    
    public double setRotation(double rotation) {
         if(rotation == 0){
            this.rotation=0;
            return rotation;
        }
        this.rotation = rotation+this.rotation;
        return rotation;
    }

    public double getRotation() {
        return rotation;
    }
    
    @Override
    public Image image() {
        return image;
    }

    @Override
    public void show(Image image,int rotation,float zoom) {
        this.image = image;
        this.setRotation(rotation);
        this.setZoom(zoom);
        this.repaint();
    }   
}
