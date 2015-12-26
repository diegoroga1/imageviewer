package imageviewer.control;

import imageviewer.ImagePanel;
import imageviewer.view.ImageDisplay;

public class RotateImageCommand implements Command {
    private final ImageDisplay imageDisplay;
    public RotateImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().rotate(),90,1);
    }
}
