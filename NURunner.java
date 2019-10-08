import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.lang.*;
import java.util.List;

class MyFrame extends JFrame {
    public MyFrame() {
        super();
        setTitle( "NU Graduation by Aidana Imangozhina" );
        Display display = new Display();
        setContentPane( display );
        setResizable( false );
        pack();
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}

public class NURunner {

    public Display display;
    public Common common;

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                new MyFrame().setVisible( true );
            }
        } );


    }
}