package imageviewer.control;

import imageviewer.ImagePanel;
import imageviewer.view.ImageDisplay;

public class ReduceImageCommand implements Command {
    private final ImageDisplay imageDisplay;
    public ReduceImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().reduce(),0, (float) -100);
    }
}
