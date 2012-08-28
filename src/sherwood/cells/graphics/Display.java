package sherwood.cells.graphics;

import sherwood.cells.environment.Environment;

import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;

public class Display {
	private static final int DEFAULT_NUM_BUFFERS = 3;
	private static DisplayMode[] BEST_DISPLAY_MODES = new DisplayMode[]{
			new DisplayMode(1920, 1080, 16, 0),
			new DisplayMode(1920, 1080, 8, 0)
	};

	private ViewPort viewPort;
	private GUI gui;
	private Frame mainFrame;

	public Display() {
		this(DEFAULT_NUM_BUFFERS);
	}

	public Display(int numBuffers) {

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		try {
			GraphicsConfiguration gc = device.getDefaultConfiguration();
			device.setFullScreenWindow(mainFrame);
			mainFrame = new Frame(gc);
			mainFrame.setUndecorated(true);
			mainFrame.setIgnoreRepaint(true);
			if (device.isDisplayChangeSupported()) {
				chooseBestDisplayMode(device);
			}
			mainFrame.createBufferStrategy(numBuffers);
			Panel panel = new Panel();
			viewPort = new ViewPort(mainFrame.getBufferStrategy(), numBuffers, panel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void drawEnvironment(Environment environment) {
		viewPort.drawEnvironment(environment);
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
