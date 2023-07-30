import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private JButton Log_IN;
    private JButton Register;
    private JLabel warning;

    public void changed(){
        if(email.getText().equals("")){
            Log_IN.setEnabled(false);
            warning.setForeground(Color.red);
        }else{
            Log_IN.setEnabled(true);
            warning.setForeground(new Color(34, 37, 48));
        }
    }

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

        email.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
        });

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Log_IN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //just the check if button is disabled while mail is empty
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
