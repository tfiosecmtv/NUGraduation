import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Display extends JPanel {
    public Common common = new Common();

    public Display() {
        super();
        common.startAnimating( this );
    }

    public void paintComponent(Graphics g) {
        super.paintComponent( g );
		if(common.hash_Set.size() == 10 ) {
			common.myTimer1.stop();
			common.myTimer2.stop();
			common.myTimer3.stop();
		}
        Graphics2D g2d = (Graphics2D) g;
        common.drawAllEntities( g2d, this );
    }

    public Dimension getPreferredSize() {
        return new Dimension( 800, 400 );
    }
}