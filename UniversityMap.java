import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class UniversityMap extends Entity {
    public String name = "NUMap-Faded.jpg";
    public State state = new Stationary();

    public void draw(Graphics2D g2d, JPanel jp) {
        Image img = Toolkit.getDefaultToolkit().getImage( name );
        g2d.drawImage( img, 0, 0, jp );
    }
}