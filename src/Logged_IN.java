import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Logged_IN extends JFrame {
    static boolean visible = true;
    private JPanel Logged_IN_Panel;
    private JPanel Panel;
    private JButton Close;
    private JPanel Pane;
    private JFormattedTextField email;
    private JPasswordField password;

    public Logged_IN() {
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Component Close = (Component) e.getSource();
               SwingUtilities.getWindowAncestor(Close).dispose();
               Main swing = new Main();
               swing.main(null); //Don't know if it's good but well I quess it works? :/
            }
        });

    }

    public static void run() {
        JFrame logged = new JFrame();
        logged.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        logged.setTitle("Logged");
        logged.setContentPane(new Logged_IN().Logged_IN_Panel);
        logged.setVisible(visible);
        logged.pack();

    }
}
