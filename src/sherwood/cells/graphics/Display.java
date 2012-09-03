package sherwood.cells.graphics;

import sherwood.cells.environment.Environment;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display {
	private static final int DEFAULT_NUM_BUFFERS = 2;
	private static DisplayMode[] BEST_DISPLAY_MODES = new DisplayMode[]{
			new DisplayMode(1920, 1080, 16, 0),
			new DisplayMode(1920, 1080, 8, 0)
	};

	private ViewPort viewPort;
	private GUI gui;
	private Frame mainFrame;
    private int width, height;
    private BufferStrategy bufferStrategy;

    public Display() {
		this(DEFAULT_NUM_BUFFERS);
	}

	public Display(int numBuffers) {

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
        mainFrame = createFrame(numBuffers, device);
        bufferStrategy = mainFrame.getBufferStrategy();
        width = mainFrame.getWidth();
        height = mainFrame.getHeight();
        viewPort = new ViewPort(width, height);
        gui = new GUI(width, height);
	}

    private Frame createFrame(int numBuffers, GraphicsDevice device) {
        GraphicsConfiguration gc = device.getDefaultConfiguration();
        Frame tempFrame = new Frame(gc);
        tempFrame.setUndecorated(true);
        tempFrame.setIgnoreRepaint(true);
        device.setFullScreenWindow(tempFrame);
        if (device.isDisplayChangeSupported()) {
            chooseBestDisplayMode(device);
        }
        tempFrame.createBufferStrategy(numBuffers);
        return tempFrame;
    }

    public void drawEnvironment(Environment environment) {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        if (!bufferStrategy.contentsLost()) {
            g.fillRect(0, 0, width, height);
		    viewPort.drawEnvironment(g, environment);
        }
	}

	public boolean hasEnded() {
		return false;
	}

	private static DisplayMode getBestDisplayMode(GraphicsDevice device) {
		for (DisplayMode bestDisplayMode : BEST_DISPLAY_MODES) {
			DisplayMode[] modes = device.getDisplayModes();
			for (DisplayMode mode : modes) {
				if (mode.getWidth() == bestDisplayMode.getWidth()
						&& mode.getHeight() == bestDisplayMode.getHeight()
						&& mode.getBitDepth() == bestDisplayMode.getBitDepth()
						) {
					return bestDisplayMode;
				}
			}
		}
		return null;
	}

	public static void chooseBestDisplayMode(GraphicsDevice device) {
		DisplayMode best = getBestDisplayMode(device);
		if (best != null) {
			device.setDisplayMode(best);
		}
	}
}
