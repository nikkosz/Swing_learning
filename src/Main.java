import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    JPanel Main_Panel;
    private JPanel LEFT_BAR;
    public JButton Initialize;

    public JButton quit;

    public Main() {
        Initialize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize();
                //hide the Main pane.... damnit
                //Main main2 = new Main();
                //main2.Main_Panel.disable();
                Component Close = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(Close).setVisible(false); // THAT WORKS!!!!


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
        JOptionPane.showMessageDialog(null, "Initializng", "Swing_learning", JOptionPane.INFORMATION_MESSAGE);
        Logged_IN logged_in = new Logged_IN();
        Logged_IN.run();


    }
    public void frames(){

    }


    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setContentPane(new Main().Main_Panel);
        frame.setTitle("Swing_learning");
        frame.pack();
        frame.setVisible(true);

        //frame.addWindowListener(new WindowAdapter() {
        //    @Override
        //    public void windowClosing(WindowEvent e){
        //        setVisible(false);
        //    }

        //});
        //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

    }



}
