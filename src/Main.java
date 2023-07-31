import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    JPanel Main_Panel;
    private JPanel LEFT_BAR;
    public JButton Initialize;

    public JButton quit;
    private JTextArea welcomeToMyLittleTextArea;

    public Main() {
        Initialize.addActionListener(e -> {
            initialize();
            //hide the Main pane.... damnit
            //Main main2 = new Main(); //not working
            //main2.Main_Panel.disable(); //not working
            Component Close = (Component) e.getSource();                // ALSO NEEDS THAT!
            SwingUtilities.getWindowAncestor(Close).setVisible(false); // THAT WORKS!!!!
        });
        quit.addActionListener(e -> System.exit(0));
    }

    private void initialize() {
        JOptionPane.showMessageDialog(null, "Initializing", "Swing_learning", JOptionPane.INFORMATION_MESSAGE);
        Logged_IN.run();
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setContentPane(new Main().Main_Panel);
        frame.setTitle("Swing_learning");
        frame.pack();
        frame.setVisible(true);

        //frame.addWindowListener(new WindowAdapter() { // doesn't work
        //    @Override                                 // going further
        //    public void windowClosing(WindowEvent e){ // and further
        //        setVisible(false);                    // still going
        //    }                                         // still...
        //});                                           // yup...
        //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //that ain't working either

    }



}
