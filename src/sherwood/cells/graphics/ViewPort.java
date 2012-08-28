package sherwood.cells.graphics;

import sherwood.cells.environment.Environment;

import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.image.BufferStrategy;

public class ViewPort {
	private Panel panel;
	private BufferStrategy bufferStrategy;

	public ViewPort(BufferStrategy bufferStrategy, int numBuffers, Panel panel) {
	}

	public void drawEnvironment(Environment e) {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		if (!bufferStrategy.contentsLost()) {
			g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
			bufferStrategy.show();
			g.dispose();
		}
	}

	public boolean hasEnded() {
		return false;
	}
}
