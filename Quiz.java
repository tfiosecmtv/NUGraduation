import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class Quiz extends Assessment {
    public Quiz() {
        common = new Common();
        name = "Quiz";
        points = (int) (Math.random() * 3) + 3;
    }

    public void draw(Graphics2D g2d, JPanel jp) {
    }
}
