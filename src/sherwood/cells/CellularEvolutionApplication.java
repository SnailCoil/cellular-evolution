package sherwood.cells;

import sherwood.cells.environment.Environment;
import sherwood.cells.graphics.Display;
import sherwood.cells.physics.Engine;

public class CellularEvolutionApplication {

	public static void main(String[] args) {
		Environment environment = new Environment();
		new CellularEvolutionApplication(environment).run();
	}

	Engine engine;
	Display display;

	public CellularEvolutionApplication(Environment environment) {
		engine = new Engine(environment);
		display = new Display();
	}

	public void run() {
		boolean done = false;
		while(!done) {
			engine.update();
			display.drawEnvironment(engine.getEnvironment());
			done = display.hasEnded();
		}
	}
}
