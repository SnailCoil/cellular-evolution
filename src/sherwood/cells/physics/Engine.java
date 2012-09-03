package sherwood.cells.physics;

import sherwood.cells.Organism;
import sherwood.cells.environment.Environment;

import java.util.ArrayList;
import java.util.Collection;

public class Engine {
	private Environment environment;
    private Collection<Organism> organisms = new ArrayList<Organism>();

	public Engine(Environment environment) {
		this.environment = environment;
	}

	public void update() {
        environment.update();
        for (Organism organism : organisms) {
            organism.update(environment);
        }

    }

	public Environment getEnvironment() {
		return environment;
	}
}
