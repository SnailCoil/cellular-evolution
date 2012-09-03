package sherwood.cells;

import sherwood.cells.environment.Environment;
import sherwood.cells.organelles.Organelle;

import java.util.ArrayList;
import java.util.Collection;

public class Cell {
	Collection<Organelle> organelles = new ArrayList<Organelle>();

	public Cell() {
	}

    public void update(Environment environment) {
        for(Organelle organelle : organelles) {
            organelle.update(environment);
        }
    }
}
