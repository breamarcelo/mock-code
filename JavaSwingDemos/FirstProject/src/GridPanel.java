import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridPanel extends JPanel {
    public GridPanel(){
        setLayout(new GridLayout(11,1));
        setSize(100, 200);
        add(new JLabel("Nombre:"));
        add(new JTextField());
        add(new JLabel("Apellidos:"));
        add(new JTextField());
        add(new JLabel("Email:"));
        add(new JTextField());
        add(new JLabel("Edad:"));
        add(new JTextField());
        add(new JLabel("Teléfono:"));
        add(new JTextField());
        JButton myBtn = new JButton("Añadir");
        myBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });
        add(myBtn);
    }


}
