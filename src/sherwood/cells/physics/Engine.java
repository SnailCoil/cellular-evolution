package sherwood.cells.physics;

import sherwood.cells.Environment;

public class Engine {
	Environment environment;

	public Engine(Environment environment) {
		this.environment = environment;
	}

	public void update() {
	}

	public Environment getEnvironment() {
		return environment;
	}
}
