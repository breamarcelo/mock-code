import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(50, 50, 100, 60);
        g.drawLine(50, 50, 150, 110);
        g.setColor(Color.darkGray);
        g.fillRect(200, 50, 100, 60);

   
    }
}
