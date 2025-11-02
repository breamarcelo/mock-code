import javax.swing.JFrame;

public class MyFrame extends JFrame{
    public MyFrame() {
        setVisible(true);
        setSize(600, 450);
        add(new MyPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
