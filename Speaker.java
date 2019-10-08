import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Speaker extends Entity {
    public String imageName;

    public Speaker(String s) {
        state = new Stationary();
        position = new Vector2D();
        //position.x = 550;
        position.y = 330;
        this.name = s;
        state = new Stationary();
        if (name.equals( "Tokayev" )) {
            imageName = "KassymJomartTokayev.gif";
        } else {
            imageName = "NursultanNazarbayev.gif";
        }

    }

    public void draw(Graphics2D g2d, JPanel jp) {
        Image img = Toolkit.getDefaultToolkit().getImage( this.imageName );
        g2d.drawImage( img, (int) position.x, (int) position.y, 50, 50, jp );
        g2d.drawString( name, (int) position.x + 9, (int) position.y );
    }
}