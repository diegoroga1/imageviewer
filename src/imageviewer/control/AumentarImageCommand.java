package imageviewer.control;

import imageviewer.ImagePanel;
import imageviewer.view.ImageDisplay;

public class AumentarImageCommand implements Command {
    private final ImageDisplay imageDisplay;
    public AumentarImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().aumentar(),0, (float) 100);
    }
    
}
