import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class Academician extends Entity {
    String imageName;
    public State state;

    void generateRandomState() {
        int a = (int) (Math.random() * 3);
        if (a == 0) {
            state = new Rest();
        } else if (a == 1) {
            state = new ZigZag();
        } else {
            state = new GotoXY();
        }
    }

    public Academician(String s) {
        position = new Vector2D();
        position.x = (int) (Math.random() * 750);
        position.y = (int) (Math.random() * 350);
        this.name = s;
        generateRandomState();
        if (this.name.equals( "HansDeNivelle" )) {
            this.imageName = "HansDeNivelle.gif";
        } else if (this.name.equals( "SelimTemizer" )) {
            this.imageName = "SelimTemizer.gif";
        } else if (this.name.equals( "ShigeoKatsu" )) {
            this.imageName = "ShigeoKatsu.gif";
        } else {
            this.imageName = "VassiliosTourassis.gif";
        }
    }

    public Assessment createAssessment() {
        int randomInt = (int) (Math.random() * 3 + 1);
        if (randomInt == 1) {
            return new LabFactory().createAssessment( this.position );
        } else if (randomInt == 2) {
            return new HomeworkFactory().createAssessment( this.position );
        } else {
            return new QuizFactory().createAssessment( this.position );
        }
    }

    public void draw(Graphics2D g2d, JPanel jp) {
        Image img = Toolkit.getDefaultToolkit().getImage( this.imageName );
        g2d.drawImage( img, (int) position.x, (int) position.y, 50, 50, jp );
        g2d.drawString( state.s, (int) position.x , (int) position.y );
    }
}