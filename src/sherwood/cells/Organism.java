package sherwood.cells;

import sherwood.cells.environment.Environment;

import java.util.ArrayList;
import java.util.Collection;

public class Organism {
	Collection<Cell> cells = new ArrayList<Cell>();

	public Organism() {
	}

    public void update(Environment environment) {
        for(Cell cell : cells) {
            cell.update(environment);
        }
    }
}
