import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


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

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver"); // trying to get register button action going with sql
                    String url ="jdbc:mysql://localhost:3306/account";
                    String username="test";
                    String password="test123";

                    con = DriverManager.getConnection(url, username, password);
                    stmt = con.createStatement();
                    String sql = "IF NOT EXISTS (SELECT 1 FROM email WHERE email = '"+email.getText()+"') BEGIN INSERT INTO email (email) values ('"+email.getText()+"') END ";

                    rs = stmt.executeQuery(sql); //it's not working at the moment and well I need to rethink the query to get appropiate result of it

                    while (rs.next()){ // gotta check the result set and then make it work with appropiate prompts
                        System.out.println(rs.getString(1)); //just a check if the query works, but as of now it trows exceptions kinda know why
                    }
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
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
