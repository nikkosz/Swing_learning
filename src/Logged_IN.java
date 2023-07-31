import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


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

    public void changed(){ //sets the Text under text fields to be seen or not depending on what's in the text fields
        if(email.getText().isEmpty()){
            Log_IN.setEnabled(false);
            warning.setForeground(Color.red);
        }else{
            Log_IN.setEnabled(true);
            warning.setForeground(new Color(34, 37, 48));
        }
    }

    public Logged_IN() {
        Close.addActionListener(e -> {  //Disposing of a frame when "Close" button is pressed.
           Component Close = (Component) e.getSource();
           SwingUtilities.getWindowAncestor(Close).dispose();
           Main.main(null); //Don't know if it's good but well I quess it works? :D
        });

        email.getDocument().addDocumentListener(new DocumentListener() {    //checks for text in text field "email"
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

        Register.addActionListener(e -> { //button for registration, still not functional as of 31.07.2023

        });
        Log_IN.addActionListener(e -> {   //button for login, still not functional, used for testing purposes as of 31.07.2023
            System.exit(0); //just the check if button works when text field is not empty
        });
    }

    public static void run() {
        JFrame logged = new JFrame();
        logged.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        logged.setTitle("Logged");
        logged.setContentPane(new Logged_IN().Logged_IN_Panel);
        logged.setVisible(visible);
        logged.pack();                                                      //standard thing in terms of frames.

    }
}
