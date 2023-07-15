import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class Main extends JFrame {

    private JPanel Main_Panel;
    private JPanel LEFT_BAR;
    public JButton Initialize;

    public JButton quit;


    public Main() {
        Initialize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize();
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void initialize() {

    }

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setContentPane(new Main().Main_Panel);
        frame.setTitle("Swing_learning");
        frame.pack();
        frame.setVisible(true);


    }

}
