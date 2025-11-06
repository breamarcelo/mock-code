import java.awt.Toolkit;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    public MyFrame() {
        double screenW = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double screenH = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        setVisible(true);
        //setBounds((int) screenW/4, (int) screenH/4, (int) screenW/2, (int) screenH/2);
        setSize(400, 500);
        //add(new MyPanel());
        add(new GridPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
