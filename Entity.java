import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class Entity {
    public String name;
    public Vector2D position;
    public State state;
    public Common common;

    public abstract void draw(Graphics2D g2d, JPanel jp) throws IOException;

    public void step() {
    }
}



