import javax.swing.*;
import java.awt.*;

class Displaybat extends JFrame {
    Displaybat()
    {
        super("Display");
        getContentPane().setBackground(Color.yellow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1920,1080);
        setLayout(null);
        setVisible(true);}

    public static void main(String[] args) {
        new Displaybat();
    }
}