import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class Student extends Entity {
    void generateRandomState() {
        int a = (int) (Math.random() * 4);
        if (a == 0) {
            state = new Rest();
        } else if (a == 1) {
            state = new ZigZag();
        } else if (a == 2) {
            state = new GotoXY();
        } else {
            state = new Closest();
        }
    }

    public int grade = 0;
    public State state;

    public Student(String s) {
        position = new Vector2D();
        position.x = (int) (Math.random() * 750);
        position.y = (int) (Math.random() * 350);
        this.name = s;
        generateRandomState();
    }

    public void draw(Graphics2D g2d, JPanel jp) {
        g2d.setPaint( Color.CYAN );
        g2d.fillOval( (int) position.x, (int) position.y, 20, 20 );
        g2d.setPaint( Color.BLACK );
        g2d.drawString( name, (int) position.x, (int) position.y );
        g2d.drawString( Integer.toString( grade ), (int) position.x + 5, (int) position.y + 18 );
        g2d.drawString( state.s, (int) position.x, (int) position.y + 30 );
    }

}