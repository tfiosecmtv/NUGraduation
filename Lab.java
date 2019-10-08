import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class Lab extends Assessment {

    public Lab() {
        common = new Common();
        name = "Lab";
        points = (int) (Math.random() * 3) + 2;
    }

    public void draw(Graphics2D g2d, JPanel jp) {
    }
}