package sherwood.cells.physics;

import sherwood.cells.environment.Environment;

public class Engine {
	private Environment environment;

	public Engine(Environment environment) {
		this.environment = environment;
	}

	public void update() {
        environment.update();
    }

	public Environment getEnvironment() {
		return environment;
	}
}
