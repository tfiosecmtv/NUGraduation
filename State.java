import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class State {
    public double x2, y2;
    public double x1, y1;
    public boolean isOver;
    public boolean isVisible;
    public String s;

    public abstract void step(Entity e);

    public Common common;
	public void first() {
		x1 = 0;
		y1 = -0.1;
	}

	public void second() {
		x1 = 0.1;
		y1 = -0.1;
	}

	public void third() {
		x1 = 0.1;
		y1 = 0;
	}

	public void fourth() {
		x1 = 0.1;
		y1 = 0.1;
	}

	public void five() {
		x1 = 0;
		y1 = 0.1;
	}

	public void sixth() {
		x1 = -0.1;
		y1 = 0.1;
	}

	public void seventh() {
		x1 = -0.1;
		y1 = 0;
	}

	public void eighth() {
		x1 = -0.1;
		y1 = -0.1;
	}
}


class Invisible extends State {
    public void step(Entity e) {
    }
}





