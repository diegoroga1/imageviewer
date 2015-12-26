package imageviewer.model;

public interface Image {
    public Object bitMap();
    public Image prev();
    public Image next();
    public Image rotate();
    public Image aumentar();
    public Image reduce();

}