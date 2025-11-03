import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
    public MyPanel() {
        Button btn = new Button();
        btn.setSize(100, 100);
        btn.setLabel("hello");
        add(btn);

        Label label1 = new Label("Hello World!");
        label1.setBounds(350, 100, 100, 100);
        add(label1);
    }
        
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(50, 50, 100, 60);
        g.drawLine(50, 50, 150, 110);
        g.setColor(Color.darkGray);
        g.fillRect(200, 50, 100, 60);
    }
}
