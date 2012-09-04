package sherwood.cells.environment;

import java.util.ArrayList;
import java.util.Collection;

public class Environment {
    private Collection<Organism> organisms = new ArrayList<Organism>();

    public void update() {
        for (Organism organism : organisms) {
            organism.update(this);
        }
    }
}
